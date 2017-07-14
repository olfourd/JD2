package by.itacademy.service;

import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface ForumTopicGlobalService extends BaseService<ForumTopicGlobal> {
    ForumTopicGlobal getByName(String name);

    ForumTopicGlobal changeName(ForumTopicGlobal topic, String name);

    List<ForumTopicSimple> getAllSimpleTopicsById(Long id);
}
