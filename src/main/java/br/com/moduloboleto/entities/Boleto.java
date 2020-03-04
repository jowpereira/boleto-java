package br.com.moduloboleto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Boleto")
@Table(name = "boleto")
//@SequenceGenerator(name = "seqBoleto", sequenceName = "seq_boleto", initialValue = 1, allocationSize = 1)
public class Boleto implements Serializable{

	private static final long serialVersionUID = -5072743548555835031L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="boleto_id")
	private Integer boletoId;
	
	private LocalDate createdTime;    
	private double  amount;
	private LocalDate dueDate;
	
	@OneToMany(mappedBy="boleto", fetch=FetchType.LAZY)
	private List<BoletoTracking> boletoTrackings = new ArrayList<BoletoTracking>();

	public Boleto() {
	}

	public Boleto(Integer boletoId, LocalDate createdTime, double amount, LocalDate localDate) {
		super();
		this.boletoId = boletoId;
		this.createdTime = createdTime;
		this.setAmount(amount);
		this.setDueDate(localDate);
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boletoId == null) ? 0 : boletoId.hashCode());
		return result;
	}

	public List<BoletoTracking> getBoletoTrackings() {
		return boletoTrackings;
	}

	public void setBoletoTrackings(List<BoletoTracking> boletoTrackings) {
		this.boletoTrackings = boletoTrackings;
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
