package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.NewsDaoImpl;
import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.entity.User;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Loggable
public class NewsServiceImpl extends BaseServiceImpl<News, NewsDaoImpl> implements NewsService{
    @Override
    public News changePicture(News model, String src) {
        return getRepository().changePicture(model, src);
    }

    @Override
    public News changeName(News model, String name) {
        return getRepository().changeName(model, name);
    }

    @Override
    public News changeText(News model, String text) {
        return getRepository().changeText(model, text);
    }

    @Override
    public List<NewsComment> getCommentsByNewsId(Long primaryKey) {
        List<NewsComment> comments = getRepository().getCommentsByNewsId(primaryKey);
        Collections.reverse(comments);
        return comments;
    }

    @Override
    public News getByName(String name) {
        return getRepository().getByName(name);
    }

    @Override
    public List<News> getNewsFromPage(int page) {
        List<News> newsFromPage = getRepository().getNewsFromPage(page);
        Collections.reverse(newsFromPage);
        return newsFromPage;
    }

    @Override
    public int getCountOfPages() {
        int size = getAll().size();
        int pages = size / 3;
        if (size % 3 > 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public News getById(Long primaryKey) {
        News news = super.getById(primaryKey);
        User user = news.getUser();
        return news;
    }

    @Override
    public List<News> getAll() {
        List<News> allNews = super.getAll();
        Collections.reverse(allNews);
        return allNews;
    }
}
