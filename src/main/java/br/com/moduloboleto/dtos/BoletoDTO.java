package br.com.moduloboleto.dtos;

import java.time.LocalDate;

import br.com.moduloboleto.entities.Boleto;

public class BoletoDTO {

	private Integer boletoId;	
	private LocalDate createdTime;
	private double  amount;
	private LocalDate dueDate;
	
	
	public BoletoDTO() {
	}

	public BoletoDTO(Boleto obj) {
		this.boletoId      = obj.getBoletoId();
		this.createdTime   = obj.getCreatedTime();
		this.amount        = obj.getAmount();
		this.dueDate       = obj.getDueDate();
	}

	public Integer getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(Integer boletoId) {
		this.boletoId = boletoId;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
