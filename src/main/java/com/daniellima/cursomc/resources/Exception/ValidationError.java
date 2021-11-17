package com.daniellima.cursomc.resources.Exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	
	private List<FieldMessage> errors = new ArrayList<>(); 
	
	public ValidationError(Integer status, String msg, Long timeStamo) {
		super(status, msg, timeStamo);
		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void AddError (String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

	

}
