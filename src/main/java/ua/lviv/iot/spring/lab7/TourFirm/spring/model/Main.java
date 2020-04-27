package ua.lviv.iot.spring.lab7.TourFirm.spring.model;


import ua.lviv.iot.spring.lab7.TourFirm.spring.manager.TourAgencyManager;
import ua.lviv.iot.spring.lab7.TourFirm.spring.manager.TourWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        TourAgencyManager tourAgencyManager = new TourAgencyManager();
//Date startDate = new Date();
/*startDate.setYear(19);
startDate.setDate(12);
startDate.setMonth(10);
*/
//Date endDate = new Date();
/*endDate.setYear(20);
endDate.setDate(10);
endDate.setMonth(11);
*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        Date startDate = format.parse("2009-12-31");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format1.format(new Date());
        Date endDate = format1.parse("2019-01-12");

        tourAgencyManager.add(new Tour("Journey", "Ryainair", "Operatorname", "GuideParis",
                startDate, endDate, 10000));
        tourAgencyManager.add(new Sports("Abc", "AccordTour", "maksym", "GuideDubai",
                startDate, endDate, 5000,  true, true, false, 30, AccomodationKind.HOTEL));

        tourAgencyManager.add(new Tour("UkraineJourney", "Ryainair", "UkraineTrip",
                "GuideParis", startDate, endDate, 9500));
        tourAgencyManager.add(new Sports("Abc", "AccordTour", "Roman", "GuideDubai",
                startDate, endDate, 4700, false, true, true, 100, AccomodationKind.NATURE));

        tourAgencyManager.add(new Tour("KidsTour", "EuroBas", "KidsTrip", "GuideKids",
                startDate, endDate, 1000));

        tourAgencyManager.add(new Sports("SportTour", "Ryainair", "SportOperator", "GuideParis",
                startDate, endDate, 10000, true, false, true, 50, AccomodationKind.MOUNTAINS));

        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYNAME : ");
        tourAgencyManager.sortByName();
        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYPRICE : ");
        tourAgencyManager.sortByPrice();
        tourAgencyManager.show();

        System.out.println("");

        List<Tour> familys = tourAgencyManager.FamilyTour();
        for (Tour t : familys)
            System.out.println(t);

        System.out.println("");

        System.out.println("SORTBYNAME1 : ");
        tourAgencyManager.sortByName1();
        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYOPERATOR : ");
        tourAgencyManager.sortByOperator();
        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYAGENT : ");
        tourAgencyManager.sortByAgent();
        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYOPERATORLAMBDA : ");
        tourAgencyManager.sortByOperatorLambda();
        tourAgencyManager.show();

        System.out.println("");

        System.out.println("SORTBYBASEPRICELAMBDA : ");
        tourAgencyManager.sortByBasePrise();
        tourAgencyManager.show();

        try {
            tourAgencyManager.writeToSCV(new TourWriter(), "FileName1.csv");
        }catch (Exception ex){System.out.println(ex.getMessage());
    }
    }
}
