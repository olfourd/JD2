package by.itacademy.service;

import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.service.common.BaseService;

import java.util.List;
import java.util.Set;

public interface HeroService extends BaseService<Hero> {

    List<HeroAbility> getAllAbilities(Long primaryKey);

    Hero getByName(String name);

    List<Hero> getAllWithFilter(HeroRole heroRole);

    List<Hero> getAllWithManyFilters(String ... roles);
    }
