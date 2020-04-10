package ua.lviv.iot.spring.lab7.TourFirm.manager;


import ua.lviv.iot.spring.lab7.TourFirm.model.Tour;

public class ComparatorByName implements java.util.Comparator<Tour> {


    @Override
    public int compare(Tour o1, Tour o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
