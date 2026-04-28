package org.bd2.model;

import lombok.Data;

@Data
public class Cliente {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private Long dni;
    private Domicilio domicilio;
    private ObraSocial obraSocial; // nullable
    private String numeroAfiliado; // nullable
}





