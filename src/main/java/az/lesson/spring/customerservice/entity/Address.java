package az.lesson.spring.customerservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  Integer cityId;
    private  String zipCode;
    private  Integer regionId;
    private  Integer districtId;
    private  Integer groupId;
    private  Integer streetId;
    private  Integer subStreetId;
    private  Integer buildingId;
    private  Integer homeId;
}
