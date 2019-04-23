package br.com.moduloboleto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Boleto")
@Table(name = "boleto")
@SequenceGenerator(name = "seqBoleto", sequenceName = "seq_boleto", initialValue = 1, allocationSize = 1)
public class Boleto implements Serializable{

	private static final long serialVersionUID = -5072743548555835031L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBoleto")
	@Column(name = "idBoleto")
	Long boletoId;
	LocalDate createdTime;    
	BigDecimal amount;
	LocalDate localDate;
	
	public Boleto() {
	}

	public Boleto(Long boletoId, LocalDate createdTime, BigDecimal amount, LocalDate localDate) {
		super();
		this.boletoId = boletoId;
		this.createdTime = createdTime;
		this.amount = amount;
		this.localDate = localDate;
	}

	public Long getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(Long boletoId) {
		this.boletoId = boletoId;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boletoId == null) ? 0 : boletoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		if (boletoId == null) {
			if (other.boletoId != null)
				return false;
		} else if (!boletoId.equals(other.boletoId))
			return false;
		return true;
	}

}
