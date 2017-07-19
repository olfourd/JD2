package by.itacademy.service;


import by.itacademy.aspect.Loggable;
import by.itacademy.dao.NewsCommentDaoImpl;
import by.itacademy.entity.NewsComment;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Loggable
public class NewsCommentServiceImpl
        extends BaseServiceImpl<NewsComment, NewsCommentDaoImpl> implements NewsCommentService{

}
