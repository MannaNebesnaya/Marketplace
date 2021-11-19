package ru.marketplace.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "root_categories")
public class RootCategory extends AbstractBaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Offer> offers;


    public RootCategory() {
    }

    public RootCategory(Integer id, String name) {
        super(id, name);
    }

    public List<Offer> getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        return "RootCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
