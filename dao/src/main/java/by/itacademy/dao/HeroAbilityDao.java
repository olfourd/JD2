package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.HeroAbility;

public interface HeroAbilityDao extends BaseDao<HeroAbility> {
    HeroAbility getByName(String name);
}
