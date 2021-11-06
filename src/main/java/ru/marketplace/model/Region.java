package ru.marketplace.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private Set<City> cities;
}
