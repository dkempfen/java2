package dantek.coderhouse.example.model;

import lombok.Data;

@Data
public class LineaFactura {
    private Long productoId;
    private Integer cantidad;
    private Double precioUnitario;
}
