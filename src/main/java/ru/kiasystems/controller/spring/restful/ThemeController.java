package ru.kiasystems.controller.spring.restful;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.restful.entities.Themes;

@Controller
@RequestMapping(value = "/theme")
public class ThemeController {
    final Logger logger = org.slf4j.LoggerFactory.getLogger(ThemeController.class);

    @Autowired
    @Qualifier("jpaThemeService")
    private ThemeService themeService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Themes listData() {
        return new Themes(themeService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Theme findThemeById(@PathVariable Long id) {
        return themeService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Theme create(@RequestBody Theme theme) {
        logger.info("Creating theme: " + theme);
        themeService.save(theme);
        logger.info("Theme successfully created with info: " + theme);
        return theme;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Theme theme, @PathVariable Long id) {
        logger.info("Updating theme: " + theme);
        themeService.save(theme);
        logger.info("Theme updated successfully with info: " + theme);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        logger.info("Deleting theme with id: " + id);
        Theme theme = themeService.findById(id);
        themeService.delete(theme);
        logger.info("Theme deleted successfully");
    }
}
