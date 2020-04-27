package ua.lviv.iot.spring.lab7.TourFirm.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "\"firms\"")
public class TourFirm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer yearOfFoundation;
    private Integer amountOfTours;

    // one to many
    @OneToMany(mappedBy = "tourFirm", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tourFirm")
    private Set<Tour> tours;

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public Integer getId() {
        return id;
    }

    public TourFirm() {

    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLawyers(Set<Tour> tours) {
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public Integer getAmountOfTours() {
        return amountOfTours;
    }

    public void setAmountOfTours(Integer amountOfTours) {
        this.amountOfTours = amountOfTours;
    }
}
