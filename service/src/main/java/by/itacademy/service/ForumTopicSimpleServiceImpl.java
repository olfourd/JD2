package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.ForumTopicSimpleDaoImpl;
import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Loggable
public class ForumTopicSimpleServiceImpl
        extends BaseServiceImpl<ForumTopicSimple, ForumTopicSimpleDaoImpl> implements ForumTopicSimpleService {
    @Override
    public ForumTopicSimple getByName(String name) {
        return getRepository().getByName(name);
    }

    @Override
    public ForumTopicSimple changeTheme(ForumTopicSimple topicSimple, ForumTopicGlobal topicGlobal) {
        return getRepository().changeTheme(topicSimple, topicGlobal);
    }

    @Override
    public List<ForumPost> getAllForumPosts(Long primaryKey) {
        return getRepository().getAllForumPosts(primaryKey);
    }

    @Override
    public ForumTopicSimple changeText(ForumTopicSimple topicSimple, String text) {
        return getRepository().changeText(topicSimple, text);
    }
}
