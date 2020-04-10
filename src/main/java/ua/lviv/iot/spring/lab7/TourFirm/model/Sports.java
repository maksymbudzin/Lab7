package ua.lviv.iot.spring.lab7.TourFirm.model;

import ua.lviv.iot.spring.lab7.TourFirm.model.Tour;

import java.util.Date;

 enum AccomodationKind {
    HOTEL,
    NATURE,
    CAMP,
    MOUNTAINS,
}

public class Sports extends Tour {

    private boolean instructor;

    private boolean inventory;

    private boolean protection;

    private int numberOfPeople;

    private  AccomodationKind accomodationKind;

    public Sports(String agent, String operator, String name, String guide, Date startDate, Date endDate,
                  int basePrice, boolean instructor, boolean inven, boolean protection, int numberOfPeople,
                  AccomodationKind accomodationKind) {
        super(agent, operator, name, guide, startDate, endDate, basePrice);
        resetValues(instructor, inventory, protection, numberOfPeople, accomodationKind);

    }

    public void resetValues(boolean instructor, boolean inventory, boolean protection, int numberOfPeople,
                            AccomodationKind accomodationKind) {
        this.instructor = instructor;
        this.inventory = inventory;
        this.numberOfPeople = numberOfPeople;
        this.protection = protection;
        this.accomodationKind = accomodationKind;
    }



    ;

    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    public boolean isInventory() {
        return inventory;
    }

    public void setInventory(boolean inventory) {
        this.inventory = inventory;
    }

    public boolean isProtection() {
        return protection;
    }

    public void setProtection(boolean protection) {
        this.protection = protection;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }



    @Override
    public String getHeaders () {

        return super.getHeaders() + "instructor, inventory, protection, numberOfPeople";
    }



    @Override
    public String toSCV(){
        return super.toSCV()+ instructor + ","+inventory+","+protection+","+numberOfPeople;
    }



}
