package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.entity.Category;
import com.jhansi.ecommerce.entity.Product;
import com.jhansi.ecommerce.entity.Review;
import com.jhansi.ecommerce.repository.CategoryRepository;
import com.jhansi.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(Product product) {

        Long categoryId = product.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        product.setCategory(category);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        return productRepository.save(product);
    }
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
    public Page<Product> getProducts(
            int page,
            int size) {

        return productRepository.findAll(
                PageRequest.of(page, size));
    }
    public List<Product> getSortedProducts(
            String field) {

        return productRepository.findAll(
                Sort.by(Sort.Direction.ASC, field));
    }

    public List<Product> getProductsByCategory(
            Long categoryId) {

        return productRepository
                .findByCategoryId(categoryId);
    }

    public List<Product> getLowStockProducts() {

        return productRepository.findByStockLessThan(5);
    }

    public List<Product> filterProductsByPrice(
            Double min,
            Double max) {

        return productRepository
                .findByPriceBetween(min, max);
    }

    public long getProductCountByCategory(
            Long categoryId) {

        return productRepository
                .countByCategoryId(categoryId);
    }
}