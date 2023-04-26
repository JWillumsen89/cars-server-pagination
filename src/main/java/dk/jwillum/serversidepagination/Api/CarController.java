package dk.jwillum.serversidepagination.Api;

import dk.jwillum.serversidepagination.Dto.CarResponse;
import dk.jwillum.serversidepagination.Service.CarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

  CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  List<CarResponse> getCars(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "4") int size,
      @RequestParam(defaultValue = "brand,asc") List<String> sort
  ) {
    //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
    return carService.getCars(false, page, size, sort);
  }

  @GetMapping("/brand/{brand}")
  List<CarResponse> getCarsByBrand(@PathVariable String brand,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "4") int size,
      @RequestParam(defaultValue = "brand,asc") List<String> sort
  ) {
    //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
    return carService.getCarsByBrand(brand, false, page, size, sort);
  }

  @GetMapping("/total")
  public long getTotalCars() {
    return carService.getTotalCars();
  }


}
