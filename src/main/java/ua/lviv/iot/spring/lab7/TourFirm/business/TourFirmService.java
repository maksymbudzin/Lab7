package ua.lviv.iot.spring.lab7.TourFirm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.lab7.TourFirm.dataaccess.TourFirmRepository;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.TourFirm;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TourFirmService {
    @Autowired
    private TourFirmRepository tourFirmsRepository;

    public List<TourFirm> getAllFirms() {
        return tourFirmsRepository.findAll();
    }

    public TourFirm getFirmById(Integer firmId) {
        try {
            return tourFirmsRepository.findById(firmId).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public TourFirm createFirm(TourFirm firm) {
        return tourFirmsRepository.save(firm);
    }

    public TourFirm updateFirm(Integer firmId, TourFirm firm) {
        firm.setId(firmId);
        return tourFirmsRepository.save(firm);
    }

    public void deleteFirm(Integer firmId) {
        tourFirmsRepository.deleteById(firmId);
    }

    public boolean firmExists(Integer firmId) {
        return tourFirmsRepository.existsById(firmId);
    }

}
