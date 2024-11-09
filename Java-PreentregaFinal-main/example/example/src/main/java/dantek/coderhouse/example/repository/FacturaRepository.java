package dantek.coderhouse.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dantek.coderhouse.example.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
