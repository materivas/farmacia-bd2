package org.bd2.model;

import java.util.List;

import lombok.Data;

@Data
public class Sucursal {
    private Long idSucursal;
    private Domicilio domicilio;
    private Integer puntoVenta;
    private List<Empleado> empleados;
}


