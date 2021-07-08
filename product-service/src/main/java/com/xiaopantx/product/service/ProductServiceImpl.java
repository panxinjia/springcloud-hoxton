package com.xiaopantx.product.service;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product().setId(1).setProductName("苹果笔记本").setProductPrice(20000.00).setProductNum(1));
        productList.add(new Product().setId(2).setProductName("小米手机").setProductPrice(1000.00).setProductNum(2));
        productList.add(new Product().setId(3).setProductName("华为手机").setProductPrice(4890.00).setProductNum(3));
    }

    @Override
    public List<Product> list() {
        return this.productList;
    }

    @Override
    public Product info(Integer id) {
        return this.productList.stream()
                .filter(product -> product.getId().equals(id))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public boolean save(Product entity) {
        return this.productList.add(entity);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return this.productList.removeIf(product -> product.getId().equals(id));
    }
}
