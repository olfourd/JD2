package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;

import java.util.List;

public interface ForumTopicSimpleDao extends BaseDao<ForumTopicSimple> {

    ForumTopicSimple getByName(String name);

    ForumTopicSimple changeTheme(ForumTopicSimple topicSimple, ForumTopicGlobal topicGlobal);

    List<ForumPost> getAllForumPosts(Long primaryKey);

    ForumTopicSimple changeText(ForumTopicSimple topicSimple, String text);
}
