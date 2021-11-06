package ru.marketplace.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "root_categories")
public class RootCategory extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;



    public RootCategory() {
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "RootCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
