package ua.lviv.iot.spring.lab7.TourFirm.manager;



import ua.lviv.iot.spring.lab7.TourFirm.model.Family;
import ua.lviv.iot.spring.lab7.TourFirm.model.Tour;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TourAgencyManager {

    public class InnerComparator implements Comparator<Tour>{

        @Override
        public int compare(Tour o1, Tour o2) {

            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class InnerComparatorStatic implements Comparator<Tour>{

        @Override
        public int compare(Tour o1, Tour o2) {

            return o1.getAgent().compareTo(o2.getAgent());
        }
    }

    private List<Tour> tours;

    private Comparator<Tour> comparatorByName = new ComparatorByName();
    private Comparator<Tour> comparatorByPrice = new CompareByPrice();

    public List<Tour> getTours() {
        return tours;
    }

    public TourAgencyManager() {
        tours = new ArrayList<Tour>();
    }

    public void setTours() {
        this.tours = new ArrayList<Tour>();
    }

    public void add(Tour tour) {
        this.tours.add(tour);
    }

    public void remove(Tour tour) {
        this.tours.remove(tour);
    }

    public void sortByName() {
        tours.sort(comparatorByName);
    }

    public void sortByPrice() {
        tours.sort(comparatorByPrice);

    }

    public void show() {
        for (Tour t : tours
        ) {
            System.out.println(t);

        }
    }

    public List<Tour> FamilyTour() {
        List<Tour> result = new ArrayList<Tour>();
        for (Tour t:tours) {
            if(t instanceof Family)
                result.add(t);
        }
        return result;
    }

    public void sortByName1(){
        tours.sort(new InnerComparator());
    }

    public void sortByAgent(){
        tours.sort(new TourAgencyManager.InnerComparatorStatic());
    }

    public void sortByOperator () {

        Collections.sort(tours, new Comparator<Tour>() {
            @Override
            public int compare(Tour t1, Tour t2) {
                return t1.getOperator().compareTo(t2.getOperator());
            }
        });
    }

    public void sortByOperatorLambda () {

        Collections.sort(tours, ( t1, t2 ) -> t1.getOperator().compareTo(t2.getOperator()));
    }

    public void sortByBasePrise() {

        Collections.sort(tours, ( t1, t2 ) -> t1.getBasePrice()<t2.getBasePrice() ? -1:t1.getBasePrice()==t2.getBasePrice() ? 0:1);
        Collections.reverse(tours);
    }


    public void writeToSCV (TourWriter tw, String fileName) throws IOException {
        tw.writeToFile(tours, fileName);
    }


}
