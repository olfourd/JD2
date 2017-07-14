package by.itacademy.service;

import by.itacademy.entity.NewsComment;
import by.itacademy.service.common.BaseService;

public interface NewsCommentService extends BaseService<NewsComment> {
    NewsComment changeText(NewsComment comment, String text);
}
