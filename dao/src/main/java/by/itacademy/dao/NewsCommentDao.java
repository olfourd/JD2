package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.NewsComment;

public interface NewsCommentDao extends BaseDao<NewsComment> {
    NewsComment changeText(NewsComment comment, String text);
}
