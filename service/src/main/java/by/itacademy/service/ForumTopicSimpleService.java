package by.itacademy.service;

import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface ForumTopicSimpleService extends BaseService<ForumTopicSimple> {

    ForumTopicSimple getByName(String name);

    ForumTopicSimple changeTheme(ForumTopicSimple topicSimple, ForumTopicGlobal topicGlobal);

    List<ForumPost> getAllForumPosts(Long primaryKey);

    ForumTopicSimple changeText(ForumTopicSimple topicSimple, String text);
}
