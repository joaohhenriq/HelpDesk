package com.joaohenrique.HelpDesk.api.response;

import java.util.ArrayList;
import java.util.List;

//<T> representa o Generics, para receber qualquer tipo
public class Response<T> {

	private T data; //pode ser User, Ticket, ChangeStatus, etc...

	private List<String> errors;

	public T getData() {
		return data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();// apenas para não ter problema de nullpointerexception
		}
		return errors;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
