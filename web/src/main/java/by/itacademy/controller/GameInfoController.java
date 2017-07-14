package by.itacademy.controller;

import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameInfoController {

    private final HeroService heroService;

    @Autowired
    public GameInfoController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(path = "/heroes")
    public String getGameInfoPage(Model model){
        List<Hero> heroes = heroService.getAll();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }

    @GetMapping(path = "/hero", params = "id")
    public String getHeroInfo(@RequestParam("id") Long id, Model model){
        Hero hero = heroService.getById(id);
        List<HeroAbility> abilities = heroService.getAllAbilities(id);
        model.addAttribute("hero", hero);
        model.addAttribute("abilities", abilities);
        return "hero-simple";
    }
}
