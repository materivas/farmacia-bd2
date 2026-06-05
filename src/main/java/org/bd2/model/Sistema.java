package org.bd2.model;

import lombok.Data;
import java.util.List;

@Data
//Clase particularmente hecha para la ayuda en la generación del JSON
public class Sistema {
    private List<Cliente> clientes;
    private List<Sucursal> sucursales;
    private List<Producto> productos;
    private List<Venta> ventas;
}
