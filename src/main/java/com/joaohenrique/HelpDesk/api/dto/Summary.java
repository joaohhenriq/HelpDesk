package com.joaohenrique.HelpDesk.api.dto;

import java.io.Serializable;

public class Summary implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer amountNew;
	private Integer amountResolved;
	private Integer amountApproved;
	private Integer amountDisapproved;
	private Integer amountAssigned;
	private Integer amountClosed;
	
	public Integer getAmountNew() {
		return amountNew;
	}
	public Integer getAmountResolved() {
		return amountResolved;
	}
	public Integer getAmountApproved() {
		return amountApproved;
	}
	public Integer getAmountDisapproved() {
		return amountDisapproved;
	}
	public Integer getAmountAssingned() {
		return amountAssigned;
	}
	public Integer getAmountClosed() {
		return amountClosed;
	}
	public void setAmountNew(Integer amountNew) {
		this.amountNew = amountNew;
	}
	public void setAmountResolved(Integer amountResolved) {
		this.amountResolved = amountResolved;
	}
	public void setAmountApproved(Integer amountApproved) {
		this.amountApproved = amountApproved;
	}
	public void setAmountDisapproved(Integer amountDisapproved) {
		this.amountDisapproved = amountDisapproved;
	}
	public void setAmountAssingned(Integer amountAssingned) {
		this.amountAssigned = amountAssingned;
	}
	public void setAmountClosed(Integer amountClosed) {
		this.amountClosed = amountClosed;
	}
}
