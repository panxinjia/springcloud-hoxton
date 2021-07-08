package com.xiaopantx.service;

import java.util.List;

public interface BaseService<T> {

    public List<T> list();

    public T info(Integer id);

    public boolean save(T entity);

    public T update(T t);

    public boolean remove(Integer id);

}
