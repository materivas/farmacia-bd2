package org.bd2.data;

import org.bd2.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {

    public static Sistema cargarDatos() {

        // ==================== OBRAS SOCIALES ====================
        ObraSocial osde = new ObraSocial();
        osde.setIdObraSocial(1L);
        osde.setNombre("OSDE");

        ObraSocial swiss = new ObraSocial();
        swiss.setIdObraSocial(2L);
        swiss.setNombre("Swiss Medical");

        ObraSocial pami = new ObraSocial();
        pami.setIdObraSocial(3L);
        pami.setNombre("PAMI");

        // ==================== DOMICILIOS ====================
        Domicilio d1 = dom(1L, "Av. Rivadavia", 1234, "Buenos Aires", "Buenos Aires");
        Domicilio d2 = dom(2L, "San Martín", 456, "Lanús", "Buenos Aires");
        Domicilio d3 = dom(3L, "Belgrano", 789, "Avellaneda", "Buenos Aires");
        Domicilio d4 = dom(4L, "Mitre", 321, "Quilmes", "Buenos Aires");
        Domicilio d5 = dom(5L, "Corrientes", 654, "Buenos Aires", "Buenos Aires");
        Domicilio d6 = dom(6L, "Sarmiento", 987, "Lanús", "Buenos Aires");
        Domicilio d7 = dom(7L, "Perón", 111, "Avellaneda", "Buenos Aires");
        Domicilio d8 = dom(8L, "Roca", 222, "Quilmes", "Buenos Aires");
        Domicilio d9 = dom(9L, "Urquiza", 333, "Buenos Aires", "Buenos Aires");
        Domicilio d10 = dom(10L, "Lavalle", 444, "Lanús", "Buenos Aires");
        Domicilio d11 = dom(11L, "Tucumán", 555, "Avellaneda", "Buenos Aires");
        Domicilio d12 = dom(12L, "Santa Fe", 666, "Quilmes", "Buenos Aires");
        Domicilio d13 = dom(13L, "Callao", 777, "Buenos Aires", "Buenos Aires");
        Domicilio d14 = dom(14L, "Florida", 888, "Lanús", "Buenos Aires");
        Domicilio d15 = dom(15L, "Maipú", 999, "Avellaneda", "Buenos Aires");
        Domicilio d16 = dom(16L, "Suipacha", 100, "Quilmes", "Buenos Aires");
        Domicilio d17 = dom(17L, "Esmeralda", 200, "Buenos Aires", "Buenos Aires");
        Domicilio d18 = dom(18L, "Reconquista", 300, "Lanús", "Buenos Aires");
        Domicilio d19 = dom(19L, "25 de Mayo", 400, "Avellaneda", "Buenos Aires");
        Domicilio d20 = dom(20L, "Leandro N. Alem", 500, "Quilmes", "Buenos Aires");
        Domicilio dSuc1 = dom(21L, "Av. Hipólito Yrigoyen", 1000, "Lanús", "Buenos Aires");
        Domicilio dSuc2 = dom(22L, "Av. Mitre", 2000, "Avellaneda", "Buenos Aires");
        Domicilio dSuc3 = dom(23L, "Av. Calchaquí", 3000, "Quilmes", "Buenos Aires");

        // ==================== EMPLEADOS ====================
        // Sucursal 1 — 3 empleados (1 encargado)
        Empleado e1 = emp(1L, "García", "Lucas", 30111222L, 20301112221L, d4, osde, "A001", true);
        Empleado e2 = emp(2L, "López", "María", 31222333L, 27312223331L, d5, swiss, "B002", false);
        Empleado e3 = emp(3L, "Martínez", "Juan", 32333444L, 20323334441L, d6, pami, "C003", false);

        // Sucursal 2 — 3 empleados (1 encargado)
        Empleado e4 = emp(4L, "Rodríguez", "Ana", 33444555L, 27334445551L, d7, osde, "A004", true);
        Empleado e5 = emp(5L, "Fernández", "Carlos", 34555666L, 20345556661L, d8, swiss, "B005", false);
        Empleado e6 = emp(6L, "Gómez", "Laura", 35666777L, 27356667771L, d9, pami, "C006", false);

        // Sucursal 3 — 3 empleados (1 encargado)
        Empleado e7 = emp(7L, "Díaz", "Pedro", 36777888L, 20367778881L, d10, osde, "A007", true);
        Empleado e8 = emp(8L, "Torres", "Sofía", 37888999L, 27378889991L, d11, swiss, "B008", false);
        Empleado e9 = emp(9L, "Ruiz", "Diego", 38999000L, 20389990001L, d12, pami, "C009", false);

        // ==================== SUCURSALES ====================
        Sucursal suc1 = new Sucursal();
        suc1.setIdSucursal(1L);
        suc1.setDomicilio(dSuc1);
        suc1.setPuntoVenta(1);
        suc1.setEmpleados(Arrays.asList(e1, e2, e3));

        Sucursal suc2 = new Sucursal();
        suc2.setIdSucursal(2L);
        suc2.setDomicilio(dSuc2);
        suc2.setPuntoVenta(2);
        suc2.setEmpleados(Arrays.asList(e4, e5, e6));

        Sucursal suc3 = new Sucursal();
        suc3.setIdSucursal(3L);
        suc3.setDomicilio(dSuc3);
        suc3.setPuntoVenta(3);
        suc3.setEmpleados(Arrays.asList(e7, e8, e9));

        // ==================== CLIENTES ====================
        Cliente c1  = cli(1L,  "Pérez",    "Juan",    40111222L, d1,  osde,  "X001");
        Cliente c2  = cli(2L,  "González", "María",   41222333L, d2,  swiss, "X002");
        Cliente c3  = cli(3L,  "Sánchez",  "Carlos",  42333444L, d3,  null,  null);
        Cliente c4  = cli(4L,  "Ramírez",  "Laura",   43444555L, d4,  pami,  "X004");
        Cliente c5  = cli(5L,  "Flores",   "Pedro",   44555666L, d5,  null,  null);
        Cliente c6  = cli(6L,  "Moreno",   "Sofía",   45666777L, d6,  osde,  "X006");
        Cliente c7  = cli(7L,  "Jiménez",  "Diego",   46777888L, d7,  swiss, "X007");
        Cliente c8  = cli(8L,  "Herrera",  "Ana",     47888999L, d8,  null,  null);
        Cliente c9  = cli(9L,  "Medina",   "Roberto", 48999000L, d9,  pami,  "X009");
        Cliente c10 = cli(10L, "Castro",   "Valeria", 49000111L, d10, null,  null);

        List<Cliente> clientes = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);

        // ==================== PRODUCTOS ====================
        // 7 medicamentos
        Producto p1  = prod(1L,  "Ibuprofeno 400mg",    "medicamento", 850.0,  "Bayer");
        Producto p2  = prod(2L,  "Amoxicilina 500mg",   "medicamento", 1200.0, "Pfizer");
        Producto p3  = prod(3L,  "Paracetamol 500mg",   "medicamento", 650.0,  "Genfar");
        Producto p4  = prod(4L,  "Omeprazol 20mg",      "medicamento", 980.0,  "Roemmers");
        Producto p5  = prod(5L,  "Atorvastatina 20mg",  "medicamento", 1500.0, "Pfizer");
        Producto p6  = prod(6L,  "Losartán 50mg",       "medicamento", 1100.0, "Bayer");
        Producto p7  = prod(7L,  "Metformina 850mg",    "medicamento", 760.0,  "Genfar");
        // 3 perfumería
        Producto p8  = prod(8L,  "Shampoo Sedal",       "perfumeria",  450.0,  "Unilever");
        Producto p9  = prod(9L,  "Crema Nivea",         "perfumeria",  620.0,  "Beiersdorf");
        Producto p10 = prod(10L, "Desodorante Rexona",  "perfumeria",  380.0,  "Unilever");

        List<Producto> productos = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);

        // ==================== VENTAS ====================
        List<Venta> ventas = new ArrayList<>();
        long idVenta = 1L;
        long idDetalle = 1L;

        // — Sucursal 1: 30 ventas —
        String[] formas = {"efectivo", "tarjeta", "debito"};
        Cliente[] clisArr = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
        Producto[] prodsArr = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};

        for (int i = 0; i < 30; i++) {
            List<DetalleVenta> detalles = new ArrayList<>();
            int nProductos = (i % 3 == 0) ? 2 : 1;
            double total = 0;
            for (int j = 0; j < nProductos; j++) {
                Producto prod = prodsArr[(i + j) % 10];
                int cant = (j == 0) ? 2 : 1;
                double subtotal = prod.getPrecio() * cant;
                total += subtotal;
                DetalleVenta dv = new DetalleVenta();
                dv.setIdDetalleVenta(idDetalle++);
                dv.setCantidad(cant);
                dv.setPrecioUnitario(prod.getPrecio());
                dv.setSubtotal(subtotal);
                dv.setProducto(prod);
                detalles.add(dv);
            }
            Venta v = new Venta();
            v.setIdVenta(idVenta);
            v.setFecha(LocalDateTime.of(2025, (i % 12) + 1, (i % 28) + 1, 10, i));
            v.setNumeroTicket(String.format("0001-%08d", idVenta));
            v.setTotal(total);
            v.setFormaPago(formas[i % 3]);
            v.setCliente(clisArr[i % 10]);
            v.setSucursal(suc1);
            v.setEmpleadoVendedor(i % 2 == 0 ? e2 : e3);
            v.setEmpleadoCajero(e1);
            v.setDetalles(detalles);
            ventas.add(v);
            idVenta++;
        }

        // — Sucursal 2: 28 ventas —
        for (int i = 0; i < 28; i++) {
            List<DetalleVenta> detalles = new ArrayList<>();
            int nProductos = (i % 4 == 0) ? 2 : 1;
            double total = 0;
            for (int j = 0; j < nProductos; j++) {
                Producto prod = prodsArr[(i + j + 2) % 10];
                int cant = (j == 0) ? 1 : 2;
                double subtotal = prod.getPrecio() * cant;
                total += subtotal;
                DetalleVenta dv = new DetalleVenta();
                dv.setIdDetalleVenta(idDetalle++);
                dv.setCantidad(cant);
                dv.setPrecioUnitario(prod.getPrecio());
                dv.setSubtotal(subtotal);
                dv.setProducto(prod);
                detalles.add(dv);
            }
            Venta v = new Venta();
            v.setIdVenta(idVenta);
            v.setFecha(LocalDateTime.of(2025, (i % 12) + 1, (i % 28) + 1, 14, i % 60));
            v.setNumeroTicket(String.format("0002-%08d", idVenta));
            v.setTotal(total);
            v.setFormaPago(formas[i % 3]);
            v.setCliente(clisArr[i % 10]);
            v.setSucursal(suc2);
            v.setEmpleadoVendedor(i % 2 == 0 ? e5 : e6);
            v.setEmpleadoCajero(e4);
            v.setDetalles(detalles);
            ventas.add(v);
            idVenta++;
        }

        // — Sucursal 3: 34 ventas —
        for (int i = 0; i < 34; i++) {
            List<DetalleVenta> detalles = new ArrayList<>();
            int nProductos = (i % 3 == 0) ? 3 : 1;
            double total = 0;
            for (int j = 0; j < nProductos; j++) {
                Producto prod = prodsArr[(i + j + 5) % 10];
                int cant = 1;
                double subtotal = prod.getPrecio() * cant;
                total += subtotal;
                DetalleVenta dv = new DetalleVenta();
                dv.setIdDetalleVenta(idDetalle++);
                dv.setCantidad(cant);
                dv.setPrecioUnitario(prod.getPrecio());
                dv.setSubtotal(subtotal);
                dv.setProducto(prod);
                detalles.add(dv);
            }
            Venta v = new Venta();
            v.setIdVenta(idVenta);
            v.setFecha(LocalDateTime.of(2025, (i % 12) + 1, (i % 28) + 1, 16, i % 60));
            v.setNumeroTicket(String.format("0003-%08d", idVenta));
            v.setTotal(total);
            v.setFormaPago(formas[i % 3]);
            v.setCliente(clisArr[i % 10]);
            v.setSucursal(suc3);
            v.setEmpleadoVendedor(i % 2 == 0 ? e8 : e9);
            v.setEmpleadoCajero(e7);
            v.setDetalles(detalles);
            ventas.add(v);
            idVenta++;
        }

        // ==================== SISTEMA ====================
        Sistema sistema = new Sistema();
        sistema.setClientes(clientes);
        sistema.setSucursales(Arrays.asList(suc1, suc2, suc3));
        sistema.setProductos(productos);
        sistema.setVentas(ventas);

        return sistema;
    }

    // ==================== HELPERS ====================
    private static Domicilio dom(Long id, String calle, Integer numero, String localidad, String provincia) {
        Domicilio d = new Domicilio();
        d.setIdDomicilio(id);
        d.setCalle(calle);
        d.setNumero(numero);
        d.setLocalidad(localidad);
        d.setProvincia(provincia);
        return d;
    }

    private static Empleado emp(Long id, String apellido, String nombre, Long dni, Long cuil,
                                Domicilio dom, ObraSocial os, String nroAfil, Boolean encargado) {
        Empleado e = new Empleado();
        e.setIdEmpleado(id);
        e.setApellido(apellido);
        e.setNombre(nombre);
        e.setDni(dni);
        e.setCuil(cuil);
        e.setDomicilio(dom);
        e.setObraSocial(os);
        e.setNumeroAfiliado(nroAfil);
        e.setEsEncargado(encargado);
        return e;
    }

    private static Cliente cli(Long id, String apellido, String nombre, Long dni,
                               Domicilio dom, ObraSocial os, String nroAfil) {
        Cliente c = new Cliente();
        c.setIdCliente(id);
        c.setApellido(apellido);
        c.setNombre(nombre);
        c.setDni(dni);
        c.setDomicilio(dom);
        c.setObraSocial(os);
        c.setNumeroAfiliado(nroAfil);
        return c;
    }

    private static Producto prod(Long id, String descripcion, String tipo, Double precio, String laboratorio) {
        Producto p = new Producto();
        p.setIdProducto(id);
        p.setDescripcion(descripcion);
        p.setTipo(tipo);
        p.setPrecio(precio);
        p.setLaboratorio(laboratorio);
        return p;
    }
}