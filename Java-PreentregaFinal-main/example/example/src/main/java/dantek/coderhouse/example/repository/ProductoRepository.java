package dantek.coderhouse.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import dantek.coderhouse.example.entity.Product;

public interface ProductoRepository extends JpaRepository<Product,Long>{ }
