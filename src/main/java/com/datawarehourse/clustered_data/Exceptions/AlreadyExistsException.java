package com.datawarehourse.clustered_data.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
