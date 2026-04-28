package org.bd2.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bd2.model.Venta;
import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


public class MongoService {

    private static final String URI = "mongodb://localhost:27017";
    private static final String DB_NAME = "farmacia";
    private static final String COLLECTION_NAME = "ventas";

    private static MongoDatabase getDatabase() {
        MongoClient client = MongoClients.create(URI);
        return client.getDatabase(DB_NAME);
    }

    public static void insertarVentas(List<Venta> ventas) {

        MongoDatabase db = getDatabase();
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);

        Gson gson = new GsonBuilder().create();

        for (Venta venta : ventas) {
            String json = gson.toJson(venta);
            Document doc = Document.parse(json);
            collection.insertOne(doc);
        }

        System.out.println("Ventas insertadas en MongoDB");
    }

    public static void testConexion() {
        try (MongoClient client = MongoClients.create(URI)) {
            MongoDatabase db = client.getDatabase(DB_NAME);
            System.out.println("Conectado a DB: " + db.getName());
        }
    }
}