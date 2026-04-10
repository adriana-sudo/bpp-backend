package com.bpp.store;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/collection/{name}")
    public List<Product> getByCollection(@PathVariable String name) {
        return repo.findByCollection(name);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repo.save(product);
    }
}