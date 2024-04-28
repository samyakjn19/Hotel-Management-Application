package com.lcwd.user.service.UserService.Service;

import com.lcwd.user.service.UserService.Entities.Rating;

import java.util.List;

public interface RatingService {
     Rating CreateRating();
     Rating GetRating();

     List<Rating> GetAllRating();


}
