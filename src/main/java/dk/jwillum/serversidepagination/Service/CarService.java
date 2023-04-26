package dk.jwillum.serversidepagination.Service;

import dk.jwillum.serversidepagination.Dto.CarResponse;
import dk.jwillum.serversidepagination.Entity.Car;
import dk.jwillum.serversidepagination.Repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getCars(boolean includeAll, int page, int size, List<String> sort) {
    Page<Car> cars = carRepository.findAll(createPageableObject(page, size, sort));
    return cars.stream().map(c -> new CarResponse(c, includeAll)).toList();
  }

  private Sort buildSortFromList(List<String> sortProperties) {
    Sort finalSort = Sort.unsorted();
    for (String sortProperty : sortProperties) {
      String[] split = sortProperty.split(",");
      if (split.length == 2) {
        Sort newSort = Sort.by(Sort.Direction.fromString(split[1]), split[0]);
        finalSort = finalSort.and(newSort);
      }
    }
    return finalSort;
  }

  public Pageable createPageableObject(int page, int size, List<String> sort) {
    Sort sortObject = buildSortFromList(sort);
    return PageRequest.of(page, size, sortObject);
  }

  public List<CarResponse> getCarsByBrand(String brand, boolean includeAll, int page, int size, List<String> sort) {
    List<Car> cars = carRepository.findCarByBrand(brand, createPageableObject(page, size, sort));
    return cars.stream().map(c -> new CarResponse(c, includeAll)).toList();
  }


  public long getTotalCars() {
    return carRepository.count();
  }
}
