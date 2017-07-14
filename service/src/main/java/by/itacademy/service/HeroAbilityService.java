package by.itacademy.service;

import by.itacademy.entity.HeroAbility;
import by.itacademy.service.common.BaseService;

public interface HeroAbilityService extends BaseService<HeroAbility> {
    HeroAbility changeName(HeroAbility ability, String name);

    HeroAbility changePicture(HeroAbility ability, String src);

    HeroAbility changeVideo(HeroAbility ability, String src);

    HeroAbility getByName(String name);
}
