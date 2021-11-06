package ru.marketplace.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "shop")
public class Shop extends AbstractBaseEntity{


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    protected List<RootCategory> categories;


    public Shop() {
    }

    public List<RootCategory> getCategories() {
        return categories;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", categories=" + categories +
                '}';
    }
}
