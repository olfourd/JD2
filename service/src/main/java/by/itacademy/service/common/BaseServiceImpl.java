package by.itacademy.service.common;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.common.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Loggable
public abstract class BaseServiceImpl<T extends BaseEntity, K extends BaseDao<T>> implements BaseService<T> {

    private K repository;

    protected K getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(K repository) {
        this.repository = repository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T create(T entity) {
        return (T) repository.save(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(Long primaryKey) {
        return (T) repository.getById(primaryKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T update(T entity) {
        return (T) repository.update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean delete(T entity) {
        return repository.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return repository.getAll();
    }
}
