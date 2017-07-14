package by.itacademy.dao.classes;

import by.itacademy.dao.NewsCommentDao;
import by.itacademy.entity.NewsComment;
import by.itacademy.util.TestDataImporte;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class NewsCommentTest extends BaseDaoTest {

    @Autowired
    private NewsCommentDao newsCommentDao;

    @Autowired
    private TestDataImporte importerToH2;

    @Before
    public void itit(){
        importerToH2.importTestData(newsCommentDao.getSessionFactory().getCurrentSession());
    }
    @Test
    public void changeText() throws Exception {
        NewsComment newsComment = newsCommentDao.getAll().get(0);
        String text = "hello from newsCommentDaoTest!";
        NewsComment changedComment = newsCommentDao.changeText(newsComment, text);
        assertEquals(changedComment.getText(), text);
    }

}