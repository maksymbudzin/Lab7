package ua.lviv.iot.spring.lab7.TourFirm.model;
import ua.lviv.iot.spring.lab7.TourFirm.model.Tour;

import java.util.Date;


enum Accommodation{
    HOTEL,
    CAMPING,
    TENTSTOWN,

};

public class Kids extends Tour {



    private int numberOfKids;

    private int numberOfAdults;

    private Accommodation accommodation;



    public Kids(String agent, String operator, String name, String guide, Date startDate, Date endDate, int basePrice,
                int numberOfKids, int numberOfAdults, Accommodation accommodation) {
        super(agent, operator, name, guide, startDate, endDate, basePrice);
        this.numberOfKids = numberOfKids;
        this.numberOfAdults = numberOfAdults;
        this.accommodation = accommodation;

    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public String getHeaders(){
        return super.getHeaders() + "numberOfKids, numberOfAdults, accommodation";
    }

    public String toSCV(){
        return super.toSCV()+numberOfKids+","+numberOfAdults+","+accommodation;
    }
}
