package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public List<Topic> getCreatedTopicsById(Long primaryKey) {
        QTopic topic = new QTopic("myTopic");
        JPAQuery<Topic> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        List<Topic> results = query.select(topic)
                .from(topic)
                .where(topic.user.id.eq(primaryKey))
                .fetchResults()
                .getResults();
        return results;
    }

    @Override
    public List<RoleOfUser> getAllRolles(Long primaryKey) {
        Session session = getSessionFactory().getCurrentSession();
        User user = session.find(User.class, primaryKey);
        return user.getRoleOfUser();
    }

    @Override
    public User getByName(String login) {
        QUser user = new QUser("user");
        SessionFactory sessionFactory = getSessionFactory();
        JPAQuery<User> query = new JPAQuery<>(sessionFactory.getCurrentSession());
        return query.select(user).from(user).where(user.name.eq(login)).fetchOne();

    }
}
