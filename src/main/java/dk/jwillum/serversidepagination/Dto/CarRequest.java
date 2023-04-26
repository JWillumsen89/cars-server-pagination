package dk.jwillum.serversidepagination.Dto;

import dk.jwillum.serversidepagination.Entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {

  private int id;
  private String brand;
  private String model;
  private String color;
  private int kilometers;

  public static Car getCarEntity(CarRequest c) {
    return new Car(c.id, c.brand, c.model, c.color, c.kilometers);
  }

  public CarRequest(String brand, String model, String color, int kilometers) {
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.kilometers = kilometers;
  }

  public CarRequest(Car c) {
    this.id = c.getId();
    this.brand = c.getBrand();
    this.model = c.getModel();
    this.color = c.getColor();
    this.kilometers = c.getKilometers();
  }

}
