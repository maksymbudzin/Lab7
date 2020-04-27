package ua.lviv.iot.spring.lab7.TourFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.lab7.TourFirm.business.TourFirmService;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.TourFirm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/firms")
@RestController
public class TourFirmController {

    private Map<Integer, TourFirm> firms = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private TourFirmService tourFirmService;

    @GetMapping
    public List<TourFirm> getAllFirms() {
        return tourFirmService.getAllFirms();
    }

    @GetMapping(path = "/{id}")
    public TourFirm getFirm(Integer firmId) {
        return tourFirmService.getFirmById(firmId);
    }
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public TourFirm createCustomer(final @RequestBody TourFirm firm) {
        firm.setId(IdCounter.incrementAndGet());
        firms.put(firm.getId(), firm);
        tourFirmService.createFirm(firm);
        return firm;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TourFirm> deleteFirm(final @PathVariable("id") Integer firmId) {
        if (tourFirmService.firmExists(firmId)) {
            tourFirmService.deleteFirm(firmId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TourFirm> updateFirm(final @PathVariable("id") Integer firmId,
                                                 final @RequestBody TourFirm firm) {
        firm.setId(firmId);
        if (firms.containsKey(firmId)) {
            firms.put(firmId, firm);
            tourFirmService.updateFirm(firmId, firm);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}