package ua.lviv.iot.spring.lab7.TourFirm.manager;


import ua.lviv.iot.spring.lab7.TourFirm.model.Tour;

import java.util.Comparator;


public class CompareByPrice implements Comparator<Tour> {

    @Override
    public int compare(Tour o1, Tour o2) {


        return o1.getBasePrice() < o2.getBasePrice() ? -1 : o1.getBasePrice() == o2.getBasePrice() ? 0 : 1;
    }


}