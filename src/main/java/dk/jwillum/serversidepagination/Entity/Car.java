package dk.jwillum.serversidepagination.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

  @Id
  private int id;
  private String brand;
  private String model;
  private String color;
  private int kilometers;
  @CreationTimestamp
  private LocalDateTime created;
  @UpdateTimestamp
  private LocalDateTime updated;

  public Car(int id, String brand, String model, String color, int kilometers) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.kilometers = kilometers;
  }
}
