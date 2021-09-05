/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atta.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author HP
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO
{

    private ResponseDataDTO data;
    private ResultDTO result;
    private String token;

    public ResponseDataDTO getData() {
        return data;
    }

    public void setData(ResponseDataDTO data) {
        this.data = data;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
