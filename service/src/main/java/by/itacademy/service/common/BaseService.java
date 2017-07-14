package by.itacademy.service.common;

import by.itacademy.entity.common.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    T create(T entity);

    T getById(Long primaryKey);

    T update(T entity);

    boolean delete( T entity);

    List<T> getAll();
}
