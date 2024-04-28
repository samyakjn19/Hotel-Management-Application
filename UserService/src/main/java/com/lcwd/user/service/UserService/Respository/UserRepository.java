package com.lcwd.user.service.UserService.Respository;

import com.lcwd.user.service.UserService.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,String> {
    // String is @id type in table && user is Entity name
}
