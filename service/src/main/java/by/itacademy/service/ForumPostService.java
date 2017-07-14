package by.itacademy.service;

import by.itacademy.entity.ForumPost;
import by.itacademy.service.common.BaseService;

public interface ForumPostService extends BaseService<ForumPost> {
    ForumPost changeText(ForumPost post, String text);
}
