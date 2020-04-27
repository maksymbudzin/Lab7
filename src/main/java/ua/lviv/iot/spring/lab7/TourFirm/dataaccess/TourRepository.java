package ua.lviv.iot.spring.lab7.TourFirm.dataaccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

}

