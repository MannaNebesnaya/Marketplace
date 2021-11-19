package ru.marketplace.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.marketplace.model.Offer;
import ru.marketplace.service.OfferService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "rest/offers", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfferCommonRestController {

    @Autowired
    private OfferService service;


    @GetMapping
    public List<Offer> getAll() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Offer get(@PathVariable int id) {
        return service.get(id);
    }


    @GetMapping("/filter")
    public List<Offer> getByParameters(/*Тут будут какие-то параметры для фильтрации, например, price*/) {
        return new ArrayList<>();
    }










    /*@GetMapping("/search")
    public List<Offer> getByParam(
            @RequestParam @Nullable String name,
            @RequestParam @Nullable Integer categoryId,
            @RequestParam @Nullable Integer regionId) {

        return null;
    }*/
}
