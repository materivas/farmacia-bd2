package org.bd2.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Venta {
    private Long idVenta;
    private LocalDateTime fecha;
    private String numeroTicket;
    private Double total;
    private String formaPago;

    private Cliente cliente;
    private Sucursal sucursal;
    private Empleado empleadoVendedor;
    private Empleado empleadoCajero;

    private List<DetalleVenta> detalles;
}