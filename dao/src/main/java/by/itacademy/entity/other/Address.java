package by.itacademy.entity.other;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Getter
    @Setter
    @Column(name = "country")
    private String country;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;
}
