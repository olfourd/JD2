package by.itacademy.util;

import by.itacademy.entity.*;
import by.itacademy.entity.other.Address;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.entity.other.KeyAbility;
import by.itacademy.entity.other.UserRole;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class TestDataImporte {

    public void importTestData(Session session) {

        User userQwerty = saveUser(session, "Qwerty", "Qwerty");
        User userOlfourd = saveUser(session, "Olfourd", "Qwerty");
        User userDeGriz = saveUser(session, "DeGriz", "Qwerty");

        Hero alistar = saveHero(session, "Alistar", HeroRole.TANK);
        HeroAbility heroAbility = saveAbility(session, "Triumphant Roar", KeyAbility.PASSIVE, alistar);
        HeroAbility heroAbility1 = saveAbility(session, "Pulverize", KeyAbility.Q, alistar);
        HeroAbility heroAbility2 = saveAbility(session, "Headbutt", KeyAbility.W, alistar);
        HeroAbility heroAbility3 = saveAbility(session, "Trample", KeyAbility.W, alistar);
        HeroAbility heroAbility4 = saveAbility(session, "Unbreakable Will", KeyAbility.R, alistar);

        News news = saveNews(session, "This is the first News!", "hi", userOlfourd);
        saveNewsCommentTest(session, "hello from test", userOlfourd, news);
        saveNewsCommentTest(session, "hi all", userOlfourd, news);

        ForumTopicGlobal topicGlobal = saveGlobalTopic(session, "global topic");
        ForumTopicGlobal forumTopicGlobal = saveGlobalTopic(session, "global topic qwerty");

        ForumTopicSimple topicSimple = saveSimpleTopic(session, "simple topic",
                "what is it?", userDeGriz, topicGlobal);
        saveForumPost(session, "this is comment", userDeGriz, topicSimple);
        saveForumPost(session, "qwerty", userDeGriz, topicSimple);

    }

    private ForumPost saveForumPost(Session session, String text, User user, ForumTopicSimple topic) {
        ForumPost forumPost = new ForumPost(text, user, topic);
        session.save(forumPost);
        return forumPost;
    }

    private ForumTopicSimple saveSimpleTopic(Session session, String name, String text, User user,
                                             ForumTopicGlobal topicGlobal) {
        ForumTopicSimple topicSimple = new ForumTopicSimple(name, text, user, topicGlobal);
        session.save(topicSimple);
        return topicSimple;
    }

    private ForumTopicGlobal saveGlobalTopic(Session session, String name) {
        ForumTopicGlobal topicGlobal = new ForumTopicGlobal(name);
        session.save(topicGlobal);
        return topicGlobal;
    }

    private NewsComment saveNewsCommentTest(Session session, String text, User user, News news) {
        NewsComment comment = new NewsComment(text, user, news);
        session.save(comment);
        return comment;
    }

    private News saveNews(Session session, String name, String text, User user) {
        News news = new News(name, text, user);
        session.save(news);
        return news;
    }

    private User saveUser(Session session, String login, String password) {
        User user = new User(login, password);
        List<RoleOfUser> roles = Arrays.asList(
                new RoleOfUser(UserRole.USER),
                new RoleOfUser(UserRole.ADMIN));
        user.setRoleOfUser(roles);
        user.setAddress(new Address("Belarus", "Minsk"));
        session.save(user);
        return user;
    }

    private Hero saveHero(Session session, String name, HeroRole heroRole) {
        Hero hero = new Hero(name, heroRole);
        session.save(hero);
        return hero;
    }

    private HeroAbility saveAbility(Session session, String name, KeyAbility keyAbility, Hero hero) {
        HeroAbility heroAbility = new HeroAbility(name, keyAbility, hero);
        session.save(heroAbility);
        return heroAbility;
    }
}
