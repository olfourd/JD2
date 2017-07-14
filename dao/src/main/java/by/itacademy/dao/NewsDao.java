package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;

import java.util.List;

public interface NewsDao extends BaseDao<News> {
    News changePicture(News model, String src);

    News changeName(News model, String name);

    News changeText(News model, String text);

    List<NewsComment> getCommentsByNewsId(Long primaryKey);

    News getByName(String name);

    List<News> getNewsFromPage(int page);
}
