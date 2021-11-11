package ru.marketplace.model;

import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractBaseEntity {

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;


    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private City cityAccommodation;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Product> products;


    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getSurname(), u.getEmail(), u.getPassword(), u.getRegistered(), u.getPhoneNumber(), u.isEnabled(), u.getRoles());
    }

    public User(Integer id, String name, String surname, String email, String password, String phoneNumber, Role role, Role... roles) {
        this(id, name, surname, email, password, new Date(), phoneNumber, true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String surname, String email, String password, Date registered, String phoneNumber, boolean enabled, Collection<Role> roles) {
        super(id, name);
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        setRoles(roles);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
    public City getCityAccommodation() {
        return cityAccommodation;
    }

    public void setCityAccommodation(City cityAccommodation) {
        this.cityAccommodation = cityAccommodation;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
