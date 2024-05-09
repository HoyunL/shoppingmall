package shop.shoppingmall.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shoppingmall.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
