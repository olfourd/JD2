package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.HeroDaoImpl;
import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Loggable
public class HeroServiceImpl extends BaseServiceImpl<Hero, HeroDaoImpl> implements HeroService{

    @Override
    public List<HeroAbility> getAllAbilities(Long primaryKey) {
        return getRepository().getAllAbilities(primaryKey);
    }



    @Override
    public Hero getByName(String name) {
        return getRepository().getByName(name);
    }
}
