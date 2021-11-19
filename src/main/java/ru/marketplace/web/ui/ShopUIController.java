package ru.marketplace.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.marketplace.model.Offer;
import ru.marketplace.service.ShopService;

import java.util.List;

@Controller
public class ShopUIController {

    @Autowired
    private ShopService service;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") @Nullable String offerName,
                         @RequestParam("category") @Nullable String categoryName,
                         @RequestParam("region") @Nullable Integer regionId,
                         Model model) {
        List<Offer> search = service.search(offerName, categoryName, regionId);
        model.addAttribute("offers", search);
        return "resultSearch";

    }


/*    @GetMapping(value = "/search1", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Offer> search1(@RequestParam("name") @Nullable String offerName,
            @RequestParam("category") @Nullable String categoryName,
            @RequestParam("region") @Nullable Integer regionId,
            Model model) {
        return service.search(offerName, categoryName, regionId);
    }*/
}
