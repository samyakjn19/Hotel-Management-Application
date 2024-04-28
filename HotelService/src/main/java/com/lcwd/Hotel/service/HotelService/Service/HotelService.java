package com.lcwd.Hotel.service.HotelService.Service;

import com.lcwd.Hotel.service.HotelService.Entity.Hotel;
import lombok.Getter;

import java.util.List;


public interface HotelService {

    Hotel CreateHotelR(Hotel hotel);

    List<Hotel> GetAllHotels();

    Hotel GetHotel(String Hid);


}
