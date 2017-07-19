package by.itacademy.service;

import by.itacademy.entity.HeroAbility;
import by.itacademy.service.common.BaseService;

public interface HeroAbilityService extends BaseService<HeroAbility> {
    HeroAbility getByName(String name);
}
