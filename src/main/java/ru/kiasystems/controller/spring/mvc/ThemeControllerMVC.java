package ru.kiasystems.controller.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Theme;

import java.util.List;

/**
 * Created by Musin on 19.05.2016.
 */
@RequestMapping("/themes")
@Qualifier("themeControllerMVC")
@Controller
public class ThemeControllerMVC {
    private final Logger logger = LoggerFactory.getLogger(ThemeControllerMVC.class);
    @Autowired
    @Qualifier("jpaThemeService")
    private ThemeService themeService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing themes");
        List<Theme> themes = themeService.findAll();
        uiModel.addAttribute("themes", themes);
        logger.info("No. of themes: " + themes.size());
        return "themes/list";
    }
}
