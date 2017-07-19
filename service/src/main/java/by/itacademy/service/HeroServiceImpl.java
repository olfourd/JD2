package by.itacademy.service;

import by.itacademy.aspect.Loggable;
import by.itacademy.dao.HeroDaoImpl;
import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Loggable
public class HeroServiceImpl extends BaseServiceImpl<Hero, HeroDaoImpl> implements HeroService {

    @Override
    public List<HeroAbility> getAllAbilities(Long primaryKey) {
        return getRepository().getAllAbilities(primaryKey);
    }

    @Override
    public Hero getByName(String name) {
        return getRepository().getByName(name);
    }

    @Override
    public List<Hero> getAllWithFilter(HeroRole heroRole) {
        return getRepository().getWithFilter(heroRole);
    }

    @Override
    public List<Hero> getAllWithManyFilters(String... roles) {
        List<Hero> result = new ArrayList<>(200);
        for (String role : roles) {
            if (role != null) {
                result.addAll(getAllWithFilter(HeroRole.valueOf(role)));
            }
        }
        result.sort(Comparator.comparing(Hero::getName));
        return result;
    }

    @Override
    public List<Hero> getAll() {
        List<Hero> all = super.getAll();
        all.sort(Comparator.comparing(Hero::getName));
        return all;
    }
}
