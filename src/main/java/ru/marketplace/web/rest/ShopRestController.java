package ru.marketplace.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.marketplace.model.Offer;
import ru.marketplace.service.ShopService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopRestController {

    @Autowired
    private ShopService service;


    @GetMapping("/search")
    public List<Offer> search(@RequestParam("name") @Nullable String offerName,
                              @RequestParam("category") @Nullable String categoryName,
                              @RequestParam("region") @Nullable Integer regionId) {
        return service.search(offerName, categoryName, regionId);
    }

}
