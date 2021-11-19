package ru.marketplace.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marketplace.model.Offer;
import ru.marketplace.service.OfferService;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferUIController {

    @Autowired
    private OfferService service;

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        Offer offer = service.get(id);
        model.addAttribute("offer", offer);
        return "offer";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Offer> getByCategory(@RequestParam ("category") String categoryName) {
        return service.getByCategory(categoryName);
    }

}
