package org.bd2.model;

import lombok.Data;

@Data
public class Producto {
    private Long idProducto;
    private String descripcion;
    private String tipo;
    private Double precio;
    private String laboratorio;
}
