package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.entity.QNewsComment;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

    @Override
    public News changePicture(News model, String src) {
        model.setSrcPicture(src);
        return update(model);
    }

    @Override
    public News changeName(News model, String name) {
        model.setName(name);
        return update(model);
    }

    @Override
    public News changeText(News model, String text) {
        model.setText(text);
        return update(model);
    }

    @Override
    public List<NewsComment> getCommentsByNewsId(Long primaryKey) {
        QNewsComment comment = new QNewsComment("comment");
        JPAQuery<NewsComment> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(comment)
                .from(comment)
                .where(comment.news.id.eq(primaryKey))
                .fetchResults()
                .getResults();
    }

    @Override
    public News getByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("select n from News n where n.name=:newsName", News.class)
                .setParameter("newsName", name)
                .getResultList()
                .get(0);
    }

    @Override
    public List<News> getNewsFromPage(int page) {
        Session session = getSessionFactory().getCurrentSession();
        int maxResult = 3;
        int firstResult = (page - 1) * maxResult;
        return session.createQuery("from News", News.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();
    }
}
