package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@Value(value="${data.exception.msg}")
	private String msg;
	
	@ExceptionHandler(value = CouponAlreadyExistsException.class)
	public ResponseEntity<String> DealsAlreadyExistsException(CouponAlreadyExistsException dap){
	        return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
	   }
		
	@Value(value="${data.exception.nameNotFound}")
	private String nameNotFound;
	
	@ExceptionHandler(value=NameNotFoundException.class)
	public ResponseEntity<String> NameNotFound(NameNotFoundException e)
	{
		return new ResponseEntity<String>(nameNotFound,HttpStatus.CONFLICT);
	}
	  
		@Value(value="${data.exception.dataNotFound}")
		private String dataNotFound;
		
		@ExceptionHandler(value=CouponIdNotFound.class)
		public ResponseEntity<String> CouponIdNotFound(CouponIdNotFound pin)
		{
			return new ResponseEntity<String>(dataNotFound,HttpStatus.CONFLICT);
		}


}