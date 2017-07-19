package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;

import java.util.List;
import java.util.Set;

public interface HeroDao extends BaseDao<Hero> {

    List<HeroAbility> getAllAbilities(Long primaryKey);

    Hero getByName(String name);

    List<Hero> getWithFilter(HeroRole heroRole);
}
