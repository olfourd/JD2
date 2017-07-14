package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.ForumPostDaoIml;
import by.itacademy.entity.ForumPost;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Loggable
public class ForumPostServiceImpl extends BaseServiceImpl<ForumPost, ForumPostDaoIml> implements ForumPostService {
    @Override
    public ForumPost changeText(ForumPost post, String text) {
        return getRepository().changeText(post, text);
    }
}
