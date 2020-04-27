package ua.lviv.iot.spring.lab7.TourFirm.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Family extends Tour {

    private int familyNumber;

    private List<String> hotels = new ArrayList<String>();

    private int star;

    private boolean nightCrossings;

    private String nameOfAccommodation;

    public Family(String agent, String operator, String name, String guide, Date startDate, Date endDate, int basePrice,
                  int familyNumber, List<String> hotels, int star, boolean nightCrossings, String nameOfAccommodation) {
        super(agent, operator, name, guide, startDate, endDate, basePrice);
        this.familyNumber = familyNumber;
        this.hotels = hotels;
        this.star = star;
        this.nightCrossings = nightCrossings;
        this.nameOfAccommodation = nameOfAccommodation;

    }

    //public Family(String agent, String operator, String name, String guide, Date startDate, Date endDate) {
    //super(agent, operator, name, guide, startDate, endDate);
    //this.familyNumber = fa
    //}

    public int getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(int familyNumber) {
        this.familyNumber = familyNumber;
    }

    public void addHotel(String hotelName) {
        hotels.add(hotelName);
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public boolean isNightCrossings() {
        return nightCrossings;
    }

    public void setNightCrossings(boolean nightCrossings) {
        this.nightCrossings = nightCrossings;
    }

    public String getNameOfAccommodation() {
        return nameOfAccommodation;
    }

    public void setNameOfAccommodation(String nameOfAccommodation) {
        this.nameOfAccommodation = nameOfAccommodation;
    }


    @Override
    public String toString() {
        return super.toString() +
                "familyNumber = " + familyNumber +
                ", hotels = " + hotels +
                ", star = " + star +
                ", nightCrossings = " + nightCrossings +
                ", nameOfAccommodation = " + nameOfAccommodation + " "
                ;
    }

    public String getHeaders(){
        String s = super.getHeaders() +"familyNumber,";
        for (int i = 0; i < hotels.size(); i++)
            s += "hotels,";
        s += " star, nightCrossings, nameOfAccommodation";
        return s;
    }

    public String toSCV(){
        String s =  super.toSCV()+familyNumber+",";
        for (String l:hotels) {
            s += l + ",";
        }
        s+=star+","+nightCrossings+","+nameOfAccommodation;
        return s;
    }
}


