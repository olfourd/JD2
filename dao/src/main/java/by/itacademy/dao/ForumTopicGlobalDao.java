package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;

import java.util.List;

public interface ForumTopicGlobalDao extends BaseDao<ForumTopicGlobal> {
    ForumTopicGlobal getByName(String name);

    ForumTopicGlobal changeName(ForumTopicGlobal topic, String name);

    List<ForumTopicSimple> getAllSimpleTopicsById(Long id);
}
