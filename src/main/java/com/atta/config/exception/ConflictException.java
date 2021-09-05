/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atta.config.exception;

import org.springframework.http.HttpStatus;


public class ConflictException extends ApiBaseException{

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
            return HttpStatus.CONFLICT;
    }
    
}
