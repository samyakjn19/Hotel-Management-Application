package com.lcwd.user.service.UserService.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Rating {

    private String RatingId;
    private String HotelId;
    private String UserId;
    private int ratings;
    private String Remark;
    private Hotel hotel;

}
