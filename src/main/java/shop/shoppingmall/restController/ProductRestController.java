package shop.shoppingmall.restController;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import shop.shoppingmall.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.shoppingmall.dto.ProductDto;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Long> addProduct(@RequestBody ProductDto productDto) {
        Long id = productService.addProduct(productDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/allProduct")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        ProductDto product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
