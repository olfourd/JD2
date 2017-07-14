package by.itacademy.dao.classes;

import by.itacademy.dao.NewsDao;
import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.util.TestDataImporte;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NewsDaoTest extends BaseDaoTest{

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private TestDataImporte dataImport;

    @Before
    public void init() throws Exception {
        dataImport.importTestData(newsDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName(){
        String name = "This is the first News!";
        News news = newsDao.getByName(name);
        assertEquals(news.getName(), name);
    }

    @Test
    public void changePicture() throws Exception {
        News news = newsDao.getByName("This is the first News!");
        String srcPicture = "D:/";
        News updatedNews = newsDao.changePicture(news, srcPicture);
        assertEquals(updatedNews.getSrcPicture(), srcPicture);
    }

    @Test
    public void changeName() throws Exception {
        News news = newsDao.getByName("This is the first News!");
        String name = "HELLO!";
        News updatedNews = newsDao.changeName(news, name);
        assertEquals(updatedNews.getName(), name);
    }

    @Test
    public void changeText() throws Exception {
        News news = newsDao.getByName("This is the first News!");
        String Text = "Change text";
        News updatedNews = newsDao.changeText(news, Text);
        assertEquals(updatedNews.getText(), Text);
    }

    @Test
    public void getCommentsByNewsId() throws Exception {
        News news = newsDao.getByName("This is the first News!");
        List<NewsComment> comments = newsDao.getCommentsByNewsId(news.getId());
        List<String> textOfComments = comments.stream().map(NewsComment::getText).collect(toList());
        assertThat(textOfComments, hasSize(2));
        assertThat(textOfComments, contains("hello from test", "hi all"));
    }

}