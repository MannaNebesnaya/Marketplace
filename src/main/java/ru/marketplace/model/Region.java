package ru.marketplace.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private List<City> cities;


    public Region() {
    }

    public Region(Integer id, String name) {
        super(id, name);
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
