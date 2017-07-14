package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.ForumPost;


public interface ForumPostDao extends BaseDao<ForumPost> {
    ForumPost changeText(ForumPost post, String text);
}
