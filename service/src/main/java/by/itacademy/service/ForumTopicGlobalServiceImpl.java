package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.ForumTopicGlobalDaoImpl;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Loggable
public class ForumTopicGlobalServiceImpl
        extends BaseServiceImpl<ForumTopicGlobal, ForumTopicGlobalDaoImpl> implements ForumTopicGlobalService{
    @Override
    public ForumTopicGlobal getByName(String name) {
        return getRepository().getByName(name);
    }

    @Override
    public List<ForumTopicSimple> getAllSimpleTopicsById(Long id) {
        return getRepository().getAllSimpleTopicsById(id);
    }
}
