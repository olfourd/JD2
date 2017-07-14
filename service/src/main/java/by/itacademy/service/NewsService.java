package by.itacademy.service;

import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface NewsService extends BaseService<News> {
    News changePicture(News model, String src);

    News changeName(News model, String name);

    News changeText(News model, String text);

    List<NewsComment> getCommentsByNewsId(Long primaryKey);

    News getByName(String name);

    List<News> getNewsFromPage(int page);

    int getCountOfPages();

}
