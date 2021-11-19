package ru.marketplace.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.marketplace.model.Offer;
import ru.marketplace.util.SearchUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShopService {

    @Autowired
    private OfferService offerService;


    /**Search at the moment by name and category*/

    public List<Offer> search(@Nullable String offerName, @Nullable String categoryName, @Nullable Integer regionId) {

        if (offerName != null && !offerName.isEmpty()) {
            List<Offer> offers = offerService.getByName(offerName);

            return SearchUtil.offersFiltered(offers, categoryName);
        }

        if (categoryName != null && !categoryName.isEmpty()) {
            return offerService.getByCategory(categoryName);
        }

        //If not found. По-хорошему должен месседж или код какой-то выводиться.
        return new ArrayList<>();
    }
}
