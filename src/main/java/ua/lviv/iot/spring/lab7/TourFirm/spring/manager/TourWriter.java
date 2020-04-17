package ua.lviv.iot.spring.lab7.TourFirm.spring.manager;


import ua.lviv.iot.spring.lab7.TourFirm.spring.model.Tour;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TourWriter {
    public void writeToFile(List<Tour> tours, String fileName) throws IOException {


        FileWriter writer = new FileWriter(fileName);
        writer.write(tours.get(0).getHeaders());
        writer.write("\n");


        for (Tour tour:tours) {
            writer.write(tour.toSCV()+ "\n");
            writer.write("\n");
        }
        writer.flush();
    }
}
