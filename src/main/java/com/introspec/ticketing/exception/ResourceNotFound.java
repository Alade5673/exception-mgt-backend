package com.introspec.ticketing.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private static final long serialVersionUID = -4444608376354240504L;
    
    public ResourceNotFound(){
        super();
    }

    public ResourceNotFound(String message){
        super(message);
    }

    public ResourceNotFound(String message, Throwable cause){
        super(message, cause);
    }
}