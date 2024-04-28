package com.lcwd.user.service.UserService.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="micro_users")
public class User {

    @Id
    @Column(name = "USERID")

    private String userId;
    @Column(name = "NAME",length = 20)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DESCRIPTION")
    private String about;


    @Transient
    private List<Rating> Ratings = new ArrayList<>();





}
