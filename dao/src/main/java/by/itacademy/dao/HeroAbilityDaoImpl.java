package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.HeroAbility;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HeroAbilityDaoImpl extends BaseDaoImpl<HeroAbility> implements HeroAbilityDao {

    @Override
    public HeroAbility getByName(String name) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select a from HeroAbility a where a.name=:abilityName", HeroAbility.class)
                .setParameter("abilityName", name)
                .getSingleResult();
    }
}
