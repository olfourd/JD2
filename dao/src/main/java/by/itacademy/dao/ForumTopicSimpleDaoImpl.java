package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.entity.QForumPost;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ForumTopicSimpleDaoImpl extends BaseDaoImpl<ForumTopicSimple> implements ForumTopicSimpleDao {
    @Override
    public ForumTopicSimple getByName(String name) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("from ForumTopicSimple where name=:nameTopic", ForumTopicSimple.class)
                .setParameter("nameTopic", name)
                .getSingleResult();
    }

    @Override
    public ForumTopicSimple changeTheme(ForumTopicSimple topicSimple, ForumTopicGlobal topicGlobal) {
        topicSimple.setTheme(topicGlobal);
        return update(topicSimple);
    }

    @Override
    public List<ForumPost> getAllForumPosts(Long primaryKey) {
        QForumPost post = new QForumPost("post");
        JPAQuery<ForumPost> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(post)
                .from(post)
                .where(post.forumTopic.id.eq(primaryKey))
                .fetchResults()
                .getResults();
    }

    @Override
    public ForumTopicSimple changeText(ForumTopicSimple topicSimple, String text) {
        topicSimple.setText(text);
        return update(topicSimple);
    }
}
