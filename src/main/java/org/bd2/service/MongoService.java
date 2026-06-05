package org.bd2.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bd2.model.Venta;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class MongoService {

    private static final String URI = "mongodb://localhost:27017";
    private static final String DB_NAME = "farmacia";
    private static final String COLLECTION_NAME = "ventas";

    public static void insertarVentas(List<Venta> ventas) {
        insertarVentas(ventas, false);
    }

    public static void insertarVentas(List<Venta> ventas, boolean limpiarAntes) {
        try (MongoClient client = MongoClients.create(URI)) {
            MongoDatabase db = client.getDatabase(DB_NAME);
            MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);

            if (limpiarAntes) {
                collection.deleteMany(new Document());
            }

            List<Document> documentos = new ArrayList<>();
            for (Venta venta : ventas) {
                String json = JsonService.toJson(venta);
                documentos.add(Document.parse(json));
            }

            if (!documentos.isEmpty()) {
                collection.insertMany(documentos);
            }

            System.out.println("Ventas insertadas en MongoDB: " + documentos.size());
        }
    }

    public static void ejecutarConsultasEntrega() {
        try (MongoClient client = MongoClients.create(URI)) {
            MongoDatabase db = client.getDatabase(DB_NAME);
            MongoCollection<Document> ventas = db.getCollection(COLLECTION_NAME);

            System.out.println("\nConsulta 1 - Cantidad total de ventas");
            System.out.println(ventas.countDocuments());

            System.out.println("\nConsulta 2 - Ventas y monto total por forma de pago");
            ventas.aggregate(List.of(
                    new Document("$group", new Document("_id", "$formaPago")
                            .append("cantidadVentas", new Document("$sum", 1))
                            .append("montoTotal", new Document("$sum", "$total"))),
                    new Document("$sort", new Document("_id", 1))
            )).forEach(document -> System.out.println(document.toJson()));

            System.out.println("\nConsulta 3 - Ventas y monto total por sucursal");
            ventas.aggregate(List.of(
                    new Document("$group", new Document("_id", new Document("idSucursal", "$sucursal.idSucursal")
                            .append("localidad", "$sucursal.domicilio.localidad"))
                            .append("cantidadVentas", new Document("$sum", 1))
                            .append("montoTotal", new Document("$sum", "$total"))),
                    new Document("$sort", new Document("_id.idSucursal", 1))
            )).forEach(document -> System.out.println(document.toJson()));

            System.out.println("\nConsulta 4 - Productos mas vendidos");
            ventas.aggregate(List.of(
                    new Document("$unwind", "$detalles"),
                    new Document("$group", new Document("_id", "$detalles.producto.descripcion")
                            .append("unidadesVendidas", new Document("$sum", "$detalles.cantidad"))
                            .append("facturacion", new Document("$sum", "$detalles.subtotal"))),
                    new Document("$sort", new Document("unidadesVendidas", -1)),
                    new Document("$limit", 5)
            )).forEach(document -> System.out.println(document.toJson()));
        }
    }

    public static void testConexion() {
        try (MongoClient client = MongoClients.create(URI)) {
            MongoDatabase db = client.getDatabase(DB_NAME);
            System.out.println("Conectado a DB: " + db.getName());
        }
    }
}
