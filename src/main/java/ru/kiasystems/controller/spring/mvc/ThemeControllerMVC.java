package ru.kiasystems.controller.spring.mvc;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.logic.utils.Message;
import ru.kiasystems.logic.utils.UrlUtil;
import ru.kiasystems.model.entity.Theme;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Theme theme = themeService.findById(id);
        uiModel.addAttribute("theme", theme);
        return "themes/show";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "form")
    public String update(Theme theme, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("Updating theme");
        if (bindingResult.hasErrors()) {

            uiModel.addAttribute("message", new Message("Ошибка!", "Не удалось сохранить тему"));
            return "themes/update";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("Успех!", "Тема успешно сохранена"));
        themeService.save(theme);
        return "redirect:/themes/"+ UrlUtil.encodeUrlPathSegment(theme.getId().toString(), httpServletRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, params = "form")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("theme", themeService.findById(id));
        return "themes/update";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create (Theme theme, BindingResult bindingResult, Model uiModel,
                          HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("Creating theme");
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message("Ошибка!", "Не удалось создать тему"));
            uiModel.addAttribute("theme", theme);
            return "themes/create";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("Успех!", "Тема создана"));
        logger.info("Theme id: " + theme.getId());
        themeService.save(theme);
        return "redirect:/themes/"+UrlUtil.encodeUrlPathSegment(theme.getId().toString(), httpServletRequest);
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        Theme theme = new Theme();
        uiModel.addAttribute("theme", theme);
        return "themes/create";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id,  Model uiModel) {
        Theme theme = themeService.findById(id);
        themeService.delete(theme);
        uiModel.asMap().clear();
        return "redirect:/themes/";
    }
}
