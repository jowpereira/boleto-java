package br.com.moduloboleto.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "BoletoTracking")
@Table(name = "boleto_tracking")
public class BoletoTracking implements Serializable{
	
	private static final long serialVersionUID = -3384746406580416334L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tracking")
	private Integer ajusteId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="boleto_id")
	private Boleto boleto;
	
	private String status;
	private LocalDate createTime;

	public BoletoTracking() {
	}
	
	public BoletoTracking(Integer ajusteId, String status, LocalDate createTime, Boleto boleto) {
		super();
		this.ajusteId   = ajusteId;
		this.status     = status;
		this.createTime = createTime;
		this.boleto     = boleto;
 	}

	public Integer getAjusteId() {
		return ajusteId;
	}

	public void setAjusteId(Integer ajusteId) {
		this.ajusteId = ajusteId;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ajusteId == null) ? 0 : ajusteId.hashCode());
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
		BoletoTracking other = (BoletoTracking) obj;
		if (ajusteId == null) {
			if (other.ajusteId != null)
				return false;
		} else if (!ajusteId.equals(other.ajusteId))
			return false;
		return true;
	}


}
