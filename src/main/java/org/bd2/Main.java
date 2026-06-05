package org.bd2;


import org.bd2.data.DataLoader;
import org.bd2.model.Sistema;
import org.bd2.service.JsonService;
import org.bd2.service.MongoService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Cargando datos...");
        Sistema sistema = DataLoader.cargarDatos();

        System.out.println("Clientes: " + sistema.getClientes().size());
        System.out.println("Empleados por sucursal: " + sistema.getSucursales().get(0).getEmpleados().size());
        System.out.println("Productos: " + sistema.getProductos().size());
        System.out.println("Ventas totales: " + sistema.getVentas().size());

        System.out.println("Generando JSON...");
        JsonService.generarJsonVentas(sistema.getVentas());

        System.out.println("Cargando ventas en MongoDB...");
        try {
            MongoService.insertarVentas(sistema.getVentas(), true);
            MongoService.ejecutarConsultasEntrega();
        } catch (RuntimeException e) {
            System.out.println("No se pudo cargar MongoDB. Verifica que MongoDB este ejecutandose en mongodb://localhost:27017");
            System.out.println("Detalle: " + e.getMessage());
        }

        System.out.println("Listo!");
    }
}
