package com.lcwd.user.service.UserService.UserImp;

import com.lcwd.user.service.UserService.Entities.Hotel;
import com.lcwd.user.service.UserService.Entities.Rating;
import com.lcwd.user.service.UserService.Entities.User;
import com.lcwd.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.Respository.UserRepository;
import com.lcwd.user.service.UserService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class UserImplementationj implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    public Logger logger = LoggerFactory.getLogger(UserImplementationj.class);
    @Override
    public User saveUser(User user) {
        String randomuserid = UUID.randomUUID().toString();
        user.setUserId(randomuserid);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        User user1 = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found in table"));
        Rating[] fetchingratingsOfUsers = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user1.getUserId(), Rating[].class);
        List<Rating> Ratings = Arrays.stream(fetchingratingsOfUsers).toList();
        logger.info("{}",Ratings);


        List<Rating> ratingList = Ratings.stream().map(rating -> {

            ResponseEntity<Hotel> forhotel = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forhotel.getBody();

            logger.info("{}", forhotel.getStatusCode());
            rating.setHotel(hotel);
            return rating;



        }).collect(Collectors.toList());
        user1.setRatings(ratingList);

        return user1;
    }

    @Override
    public void deleteUser(String userId) {

        userRepository.deleteById(userId);
    };

    @Override
    public User UpadateUser(User user) {

        return userRepository.save(user);
    }
}
