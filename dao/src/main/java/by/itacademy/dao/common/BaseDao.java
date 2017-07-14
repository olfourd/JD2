package by.itacademy.dao.common;

import by.itacademy.entity.common.BaseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    T save(T model);
    T getById(Long primaryKey);
    T update(T model);
    boolean delete(T model);
    List<T> getAll();
    SessionFactory getSessionFactory();
}
