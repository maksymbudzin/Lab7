package ua.lviv.iot.spring.lab7.TourFirm.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.lab7.TourFirm.dataaccess.TourRepository;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.Tour;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public void deleteTour(Integer id) {
        tourRepository.deleteById(id);
    }
    public Tour updateLawyer(Integer id, Tour newTour) {
        Tour tour = tourRepository.getOne(id);
        tour = newTour;
        return tourRepository.save(tour);
    }

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    public boolean tourExists(Integer id) {
        return  tourRepository.existsById(id);
    }
}

