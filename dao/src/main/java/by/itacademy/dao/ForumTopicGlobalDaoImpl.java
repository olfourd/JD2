package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.entity.QForumTopicSimple;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ForumTopicGlobalDaoImpl extends BaseDaoImpl<ForumTopicGlobal> implements ForumTopicGlobalDao {
    @Override
    public ForumTopicGlobal getByName(String name) {
        return getSessionFactory().
                getCurrentSession()
                .createQuery("from ForumTopicGlobal where name=:topicName", ForumTopicGlobal.class)
                .setParameter("topicName", name)
                .getSingleResult();
    }

    @Override
    public ForumTopicGlobal changeName(ForumTopicGlobal topic, String name) {
        topic.setName(name);
        return update(topic);
    }

    @Override
    public List<ForumTopicSimple> getAllSimpleTopicsById(Long id) {
        QForumTopicSimple topic = new QForumTopicSimple("topic");
        JPAQuery<ForumTopicSimple> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(topic).from(topic).where(topic.theme.id.eq(id)).fetchResults().getResults();
    }
}
