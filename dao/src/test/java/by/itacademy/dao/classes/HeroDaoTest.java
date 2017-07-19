package by.itacademy.dao.classes;

import by.itacademy.dao.HeroDao;
import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;
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

public class HeroDaoTest extends BaseDaoTest {

    @Autowired
    private HeroDao heroDao;
    @Autowired
    private TestDataImporte importerToH2;

    @Before
    public void init() throws Exception {
        importerToH2.importTestData(heroDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName(){
        String name = "Alistar";
        Hero hero = heroDao.getByName(name);
        assertEquals(hero.getName(), name);
    }
    @Test
    public void getAllAbilities() {
        Hero hero = heroDao.getByName("Alistar");
        List<HeroAbility> abilities = heroDao.getAllAbilities(hero.getId());
        assertThat(abilities, hasSize(5));
        List<String> namesOfAbilities = abilities.stream().map(HeroAbility::getName).collect(toList());
        assertTrue(namesOfAbilities.contains("Headbutt"));
    }


}