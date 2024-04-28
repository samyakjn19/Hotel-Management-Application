package com.lcwd.Hotel.service.HotelService.HotelImpl;

import com.lcwd.Hotel.service.HotelService.Entity.Hotel;
import com.lcwd.Hotel.service.HotelService.Exceptions.ResourceNotFoundException;
import com.lcwd.Hotel.service.HotelService.Repository.HotelRepository;
import com.lcwd.Hotel.service.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class HotelImplementation implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel CreateHotelR(Hotel hotel) {
        String Hid = UUID.randomUUID().toString();
        hotel.setId(Hid);
        return  hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> GetAllHotels() {
        List<Hotel> list = hotelRepository.findAll();
        return list;
    }

    @Override
    public Hotel GetHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This hotel is not listed"));
    }
}
