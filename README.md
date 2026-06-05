# Farmacia - Bases de Datos 2

Proyecto Java para modelar una farmacia, generar ventas en formato JSON y cargarlas como documentos en MongoDB.

## Requisitos

- Java 17
- Maven
- MongoDB ejecutandose localmente en `mongodb://localhost:27017`

## Estructura principal

- `src/main/java/org/bd2/data/DataLoader.java`: crea datos de prueba del sistema.
- `src/main/java/org/bd2/model`: contiene las clases del dominio.
- `src/main/java/org/bd2/service/JsonService.java`: serializa el sistema o las ventas a JSON.
- `src/main/java/org/bd2/service/MongoService.java`: inserta ventas en MongoDB y ejecuta consultas.
- `src/main/java/org/bd2/Main.java`: punto de entrada del programa.

## Como ejecutar

1. Levantar MongoDB localmente.
2. Ejecutar el proyecto:

```bash
mvn clean compile exec:java -Dexec.mainClass="org.bd2.Main"
```

Si se ejecuta desde un IDE, correr directamente la clase `org.bd2.Main`.

## Que hace el programa

Al ejecutarse, el programa:

1. Carga datos de prueba de clientes, empleados, sucursales, productos y ventas.
2. Genera un archivo JSON en `src/main/resources/output.json`.
3. Inserta las ventas en la base de datos MongoDB:
   - Base de datos: `farmacia`
   - Coleccion: `ventas`
4. Ejecuta consultas sobre las ventas cargadas.

## Consultas incluidas

El servicio de MongoDB ejecuta estas consultas:

- Cantidad total de ventas.
- Cantidad de ventas y monto total por forma de pago.
- Cantidad de ventas y monto total por sucursal.
- Productos mas vendidos, con unidades y facturacion.

## Notas

La carga de ventas limpia previamente la coleccion `ventas` para evitar duplicados en ejecuciones repetidas.

El proyecto genera mas de 10 ventas, cumpliendo el minimo pedido para la tercera entrega.
