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
    public HeroAbility changeName(HeroAbility ability, String name) {
        return getRepository().changeName(ability, name);
    }

    @Override
    public HeroAbility changePicture(HeroAbility ability, String src) {
        return getRepository().changePicture(ability, src);
    }

    @Override
    public HeroAbility changeVideo(HeroAbility ability, String src) {
        return getRepository().changeVideo(ability, src);
    }

    @Override
    public HeroAbility getByName(String name) {
        return getRepository().getByName(name);
    }
}
