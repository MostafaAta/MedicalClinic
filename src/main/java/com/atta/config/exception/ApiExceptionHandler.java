/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atta.config.exception;

import com.atta.common.APIWrapper;
import com.atta.common.ResponseMessages;
import com.atta.dto.ErrorDTO;
import com.atta.dto.ResultDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Set;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(value = { ApiBaseException.class })
	public ResponseEntity<Object> handleException(ApiBaseException ex, WebRequest request)
	{
		ResultDTO result = new ResultDTO(ResponseMessages.CLIENT_ERROR_CODE, ResponseMessages.CLIENT_ERROR_CODE + "Message : 1 " + ex.getMessage());
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public static ResponseEntity<Object> handleEntityExceptionValidation(Set<ConstraintViolation<Object>> constraintViolations)
	{
		ResultDTO result = null;
		ArrayList<ErrorDTO> objErrors = new ArrayList<>();
		for (ConstraintViolation<?> err : constraintViolations)
		{
			ErrorDTO objError = new ErrorDTO(err.getPropertyPath().toString(), err.getMessageTemplate());
			objErrors.add(objError);
		}
		result = new ResultDTO(ResponseMessages.CLIENT_ERROR_CODE, objErrors);
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { CustomValidationException.class })
	public ResponseEntity<Object> handleDtoExceptionValidation(CustomValidationException ex, WebRequest request)
	{
		ResultDTO result = null;
		result = new ResultDTO(ResponseMessages.CLIENT_ERROR_CODE, ex.handleValidation());
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request)
	{
		ResultDTO result = null;
		result = new ResultDTO(ResponseMessages.CLIENT_WRONG_PARAMETER_CODE, ResponseMessages.CLIENT_ERROR_CODE);
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request)
	{
		ResultDTO result = null;
		result = new ResultDTO(ResponseMessages.CLIENT_ERROR_CODE, "Mostafa Atta");
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request)
	{
		ResultDTO result = null;
		result = new ResultDTO(ResponseMessages.SERVER_ERROR_CODE, "Message 4 : " + ex.getMessage());
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

	@ExceptionHandler(value = { AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request)
	{
		ResultDTO result = null;
		result = new ResultDTO(ResponseMessages.CLIENT_ERROR_CODE, ResponseMessages.CLIENT_ERROR_CODE + " Message :6 " + ex.getMessage());
		return new ResponseEntity<>(APIWrapper.responseWrapper(result), HttpStatus.OK);
	}

}
