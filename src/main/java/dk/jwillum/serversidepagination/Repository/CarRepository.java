package dk.jwillum.serversidepagination.Repository;

import dk.jwillum.serversidepagination.Entity.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
  List<Car> findCarByBrand(String brand, Pageable pageable);
}
