package dantek.coderhouse.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dantek.coderhouse.example.exception.InsufficientStockException;
import dantek.coderhouse.example.model.Factura;
import dantek.coderhouse.example.entity.Product;
import dantek.coderhouse.example.model.FacturaRequest;
import dantek.coderhouse.example.model.FacturaService;
import dantek.coderhouse.example.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productoService;

    @Autowired
    private FacturaService facturaService;

    @PostMapping ("/facturas")
    public ResponseEntity<Factura> crearFactura (@RequestBody FacturaRequest facturaRequest) {
        Factura factura = new Factura();
        factura = facturaService.crearNuevaFactura(factura, facturaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<String> handleInsufficientStockException(InsufficientStockException
            ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }
}

