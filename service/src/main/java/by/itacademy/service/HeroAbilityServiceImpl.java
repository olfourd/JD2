package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.HeroAbilityDaoImpl;
import by.itacademy.entity.HeroAbility;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Loggable
public class HeroAbilityServiceImpl
        extends BaseServiceImpl<HeroAbility, HeroAbilityDaoImpl> implements HeroAbilityService{

    @Override
    public HeroAbility getByName(String name) {
        return getRepository().getByName(name);
    }
}
