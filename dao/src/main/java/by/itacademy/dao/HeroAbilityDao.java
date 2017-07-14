package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.HeroAbility;

public interface HeroAbilityDao extends BaseDao<HeroAbility> {
    HeroAbility changeName(HeroAbility ability, String name);

    HeroAbility changePicture(HeroAbility ability, String src);

    HeroAbility changeVideo(HeroAbility ability, String src);

    HeroAbility getByName(String name);
}
