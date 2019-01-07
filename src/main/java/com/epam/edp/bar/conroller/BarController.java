package com.epam.edp.bar.conroller;

import com.epam.edp.bar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for bar service.
 *
 * @author Roman_Martseniuk
 */
@RestController
public class BarController {

    private BarService barService;

    @Autowired
    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping(value = "/api/setting")
    public String getSetting() {
        return barService.getMessage();
    }
}
