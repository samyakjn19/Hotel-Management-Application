package com.lcwd.Hotel.service.HotelService.Repository;

import com.lcwd.Hotel.service.HotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
