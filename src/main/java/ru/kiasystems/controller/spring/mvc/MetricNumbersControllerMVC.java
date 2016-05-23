package ru.kiasystems.controller.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberService;
import ru.kiasystems.model.entity.MetricNumber;

import java.util.List;

@Controller
@RequestMapping("/metricnumbers")
public class MetricNumbersControllerMVC {
    private final Logger logger = LoggerFactory.getLogger(MetricNumbersControllerMVC.class);

    @Autowired
    @Qualifier("jpaMetricNumberService")
    MetricNumberService metricNumberService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMetricNumbers(Model uiModel) {
        logger.info("Listing all metric numbers");
        List<MetricNumber> metricNumbers = metricNumberService.findAll();
        uiModel.addAttribute("metricNumbers", metricNumbers);
        logger.info("No. of metric numbers: " + metricNumbers.size());
        for (MetricNumber metricNumber: metricNumbers) {
            logger.info(metricNumber.toString());
        }
        return "metricnumbers/list";
    }


}
