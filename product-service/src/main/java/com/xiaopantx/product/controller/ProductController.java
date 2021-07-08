package com.xiaopantx.product.controller;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "list")
    public List<Product> list() {
        return productService.list();
    }

    @GetMapping(value = "{id}")
    public Product info(@PathVariable(value = "id") Integer id) {
        return productService.info(id);
    }

    @PostMapping
    public boolean save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping(value = "{id}")
    public boolean remove(@PathVariable(value = "id") Integer id) {
        return productService.remove(id);
    }

}
