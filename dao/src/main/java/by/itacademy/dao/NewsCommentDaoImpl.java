package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.NewsComment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NewsCommentDaoImpl extends BaseDaoImpl<NewsComment> implements NewsCommentDao {
}
