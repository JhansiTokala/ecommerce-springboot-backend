package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.Review;
import com.jhansi.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")

    public Product addProduct(
            @Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product Deleted Successfully";
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")

    public Product updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam String keyword) {

        return productService.searchProducts(keyword);
    }

    @GetMapping("/paged")
    public Page<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size) {

        return productService.getProducts(
                page,
                size);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts(
            @RequestParam String field) {

        return productService.getSortedProducts(field);
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(
            @PathVariable Long categoryId) {

        return productService
                .getProductsByCategory(categoryId);
    }

    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts() {

        return productService.getLowStockProducts();
    }

    @GetMapping("/filter")
    public List<Product> filterProductsByPrice(
            @RequestParam Double min,
            @RequestParam Double max) {

        return productService
                .filterProductsByPrice(min, max);
    }

    @GetMapping("/{id}/product-count")
    public long getProductCount(
            @PathVariable Long id) {

        return productService
                .getProductCountByCategory(id);
    }
}