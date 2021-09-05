/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atta.common;

import com.atta.dto.ResponseDTO;
import com.atta.dto.ResponseDataDTO;
import com.atta.dto.ResultDTO;

public class APIWrapper
{

	private static ResponseDataDTO data = new ResponseDataDTO();

	public static ResponseDTO responseWrapper(ResultDTO result)
	{
		ResponseDTO response = new ResponseDTO();
		response.setData(getData());
		response.setResult(result);
		return response;
	}

	public static ResponseDTO responseWrapper(ResponseDataDTO data, ResultDTO result)
	{
		ResponseDTO response = new ResponseDTO();
		response.setData(data);
		response.setResult(result);
		return response;
	}

	public static ResponseDataDTO getData()
	{
		return data;
	}

	public static void setData(ResponseDataDTO data)
	{
		APIWrapper.data = data;
	}

}
