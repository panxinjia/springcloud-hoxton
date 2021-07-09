package com.xiaopantx.service.adaptor;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;

import java.util.List;

/**
 * adaptor 不是适配器模式， 接口没有默认实现之前， 接口有多个方法的处理方式
 * @author panxj
 */
public abstract class ProductServiceAdaptor implements ProductService {
    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product info(Integer id) {
        return null;
    }

    @Override
    public boolean save(Product entity) {
        return false;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }
}
