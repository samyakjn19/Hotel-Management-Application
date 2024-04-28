package com.lcwd.user.service.UserService.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("This User is not available");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
