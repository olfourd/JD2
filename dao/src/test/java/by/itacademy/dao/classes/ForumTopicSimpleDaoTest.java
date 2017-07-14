package by.itacademy.dao.classes;

import by.itacademy.dao.ForumTopicGlobalDao;
import by.itacademy.dao.ForumTopicSimpleDao;
import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.util.TestDataImporte;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class ForumTopicSimpleDaoTest extends BaseDaoTest {

    @Autowired
    private ForumTopicSimpleDao forumTopicSimpleDao;
    @Autowired
    private TestDataImporte importerToH2;
    @Autowired
    private ForumTopicGlobalDao forumTopicGlobalDao;

    @Before
    public void init() {
        importerToH2.importTestData(forumTopicSimpleDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName() {
        String name = "simple topic";
        ForumTopicSimple topicSimple = forumTopicSimpleDao.getByName(name);
        assertEquals(topicSimple.getName(), name);
    }

    @Test
    public void changeTheme() {
        ForumTopicGlobal topicGlobal = forumTopicGlobalDao.getByName("global topic qwerty");
        ForumTopicSimple topicSimple = forumTopicSimpleDao.getByName("simple topic");
        ForumTopicSimple changetTopicSimple = forumTopicSimpleDao.changeTheme(topicSimple, topicGlobal);
        assertEquals(changetTopicSimple.getTheme(), topicGlobal);

    }

    @Test
    public void getAllForumPosts() {
        ForumTopicSimple topicSimple = forumTopicSimpleDao.getByName("simple topic");
        List<ForumPost> allForumPosts = forumTopicSimpleDao.getAllForumPosts(topicSimple.getId());
        assertThat(allForumPosts, hasSize(2));
        List<String> textForumPost = allForumPosts.stream().map(ForumPost::getText).collect(toList());
        assertTrue(textForumPost.contains("this is comment"));
        assertTrue(textForumPost.contains("qwerty"));
    }

    @Test
    public void changeText(){
        ForumTopicSimple topic = forumTopicSimpleDao.getByName("simple topic");
        String text = "QWERTY";
        ForumTopicSimple changedTopic = forumTopicSimpleDao.changeText(topic, text);
        assertEquals(changedTopic.getText(), text);
    }

}