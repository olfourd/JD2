package by.itacademy.dao.classes;

import by.itacademy.dao.ForumPostDao;
import by.itacademy.entity.ForumPost;
import by.itacademy.util.TestDataImporte;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ForumPostDaoTest extends BaseDaoTest {

    @Autowired
    private ForumPostDao forumPostDao;
    @Autowired
    private TestDataImporte importerToH2;

    @Before
    public void init() {
        importerToH2.importTestData(forumPostDao.getSessionFactory().getCurrentSession());
    }


}