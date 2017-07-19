package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;

import java.util.List;

public interface ForumTopicSimpleDao extends BaseDao<ForumTopicSimple> {

    ForumTopicSimple getByName(String name);

    List<ForumPost> getAllForumPosts(Long primaryKey);

}
