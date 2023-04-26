package dk.jwillum.serversidepagination.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dk.jwillum.serversidepagination.Entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
  private int id;
  private String brand;
  private String model;
  private String color;
  private int kilometers;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime created;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime updated;

  public CarResponse(Car c, boolean includeAll) {
    this.id = c.getId();
    this.brand = c.getBrand();
    this.model = c.getModel();
    this.color = c.getColor();
    this.kilometers = c.getKilometers();
    if (includeAll) {
      this.created = c.getCreated();
      this.updated = c.getUpdated();
    }
  }
}
