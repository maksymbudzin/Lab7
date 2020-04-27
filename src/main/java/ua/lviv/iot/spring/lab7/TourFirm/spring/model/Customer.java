package ua.lviv.iot.spring.lab7.TourFirm.spring.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "\"customers\"")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    // many to many
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Tour_Customer", joinColumns = {                      //табличка посередник
            @JoinColumn(name = "customer_id", nullable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "tour_id", nullable = false) })
    @JsonIgnoreProperties("customers")
    private Set<Tour> tours;

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Customer() {

    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTour(Set<Tour> tours) {
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
