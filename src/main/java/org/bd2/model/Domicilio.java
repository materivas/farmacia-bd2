package org.bd2.model;

import lombok.Data;

@Data
public class Domicilio {
    private Long idDomicilio;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
