package ua.lviv.iot.spring.lab7.TourFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.lab7.TourFirm.business.TourService;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.Tour;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/tours")
@RestController
public class ToursController {

    private Map<Integer, Tour> tours = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private TourService tourService;

    @GetMapping
    public List<Tour> GetAllTours() {
        return new LinkedList<>(tours.values());
    }

    @GetMapping(path = "/{id}")
    public Tour getTour(final @PathVariable("id") Integer tourId) {
        return tours.get(tourId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Tour createTour(final @RequestBody Tour tour) {
        tour.setId(IdCounter.incrementAndGet());
        tours.put(tour.getId(), tour);
        tourService.createTour(tour);
        return tour;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Tour> deleteTour(@PathVariable("id") Integer tourId) {
        HttpStatus status = tours.remove(tourId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        tourService.deleteTour(tourId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tour> updateTour(final @PathVariable("id") Integer tourId,
                                           final @RequestBody Tour tour) {
        HttpStatus status;// = tours.put(tourId, tour) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        if (tours.containsKey(tourId)) {
            status = HttpStatus.OK;
            tours.put(tourId, tour);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        tourService.updateLawyer(tourId, tour);
        return ResponseEntity.status(status).build();
    }

}





