/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atta.common;

public interface ResponseMessages
{

    String SUCCESS_CODE = "200"; // SUCCESS status
    String SERVER_ERROR_CODE = "500"; // server error
    String CLIENT_ERROR_CODE = "300"; // error in validation the record into database // or single error validation required
    String CLIENT_FORM_ERROR_CODE = "303"; // form required attributes error
    String CLIENT_WRONG_PARAMETER_CODE = "400"; // doesn't send the body objects for NullPointerException
    String UNAUTHORIZED_CODE = "403";
    String UNFOUND_CODE = "404";
    String SERVER_ERROR_MSG[] = {"خطأ في الخادم", "Server Error !!"};

}
