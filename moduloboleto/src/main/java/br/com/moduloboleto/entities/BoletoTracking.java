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

@Entity(name = "BoletoTracking")
@Table(name = "boleto_tracking")
@SequenceGenerator(name = "seqBoletoTracking", sequenceName = "seq_boleto_tracking", initialValue = 1, allocationSize = 1)
public class BoletoTracking implements Serializable{
	
	private static final long serialVersionUID = -3384746406580416334L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBoletoTracking")
	@Column(name = "idTracking")
	Long ajusteId;
	String status;
	LocalDate createTime;

	public BoletoTracking() {
	}
	
	

	public BoletoTracking(Integer boletoId
			             ,LocalDate createdTime
			             ,BigDecimal amount
			             ,LocalDate localDate
			             ,Long ajustId
			             ,String status
			             ,LocalDate createTime) {
		this.ajusteId = ajustId;
		this.status = status;
		this.createTime = createTime;
		
	}

	public Long getAjusteId() {
		return ajusteId;
	}

	public void setAjusteId(Long ajusteId) {
		this.ajusteId = ajusteId;
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

	
}
