package org.bd2.model;

import lombok.Data;

@Data
public class Empleado {
    private Long idEmpleado;
    private String nombre;
    private String apellido;
    private Long dni;
    private Long cuil;
    private Domicilio domicilio;
    private ObraSocial obraSocial;
    private String numeroAfiliado;
    private Boolean esEncargado;
}