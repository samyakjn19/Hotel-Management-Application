package com.lcwd.Hotel.service.HotelService.HController;


import com.lcwd.Hotel.service.HotelService.Entity.Hotel;
import com.lcwd.Hotel.service.HotelService.HotelImpl.HotelImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelImplementation hotelImplementation;


   @PostMapping
   public ResponseEntity<Hotel> CreatHotel(@RequestBody Hotel hotel){
        Hotel hotel2 = hotelImplementation.CreateHotelR(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
    }

    @GetMapping("/{Hid}")
    public  ResponseEntity<Hotel> GetHotel(@PathVariable String Hid){
       Hotel hotel1 = hotelImplementation.GetHotel(Hid);
       return ResponseEntity.ok().body(hotel1);

    }


    @GetMapping
    public ResponseEntity<List<Hotel>> GetAllHotels(){
       List<Hotel> hl = hotelImplementation.GetAllHotels();
       return ResponseEntity.ok().body(hl);
    }



}
