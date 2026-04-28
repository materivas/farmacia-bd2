package org.bd2.model;

import lombok.Data;

@Data
public class DetalleVenta {
    private Long idDetalleVenta;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private Producto producto;

}