package com.lcwd.Hotel.service.HotelService.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String thisHotelIsNotListed) {
        super(thisHotelIsNotListed);
    }
}
