package com.lcwd.Hotel.service.HotelService.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Hotel_Details")
public class Hotel {


    @Id
    @Column(name = "Hotel Id")
    private String id;
    @Column(name = "Hotel Name")
    private String name;
    @Column(name = "Hotel Location")
    private String Location;
    @Column(name = "Hotel description")
    private String about;
}
