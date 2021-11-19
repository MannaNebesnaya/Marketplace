package ru.marketplace.util;

import org.springframework.lang.Nullable;
import ru.marketplace.model.Offer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchUtil {


    public static List<Offer> offersFiltered(List<Offer> offers,@Nullable String categoryName) {
        Stream<Offer> stream = offers.stream();

        if (categoryName != null && !categoryName.isEmpty()) {
            stream = stream.filter(offer -> offer.getCategory().getName().equals(categoryName));
        }

        return stream.collect(Collectors.toList());
    }

}
