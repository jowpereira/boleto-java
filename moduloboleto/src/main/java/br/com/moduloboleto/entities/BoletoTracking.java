package br.com.moduloboleto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Long ajusteId;

	@ManyToOne
	@JoinColumn(name="boletoId")
	private Boleto boletoId;
	
	private String status;
	private LocalDate createTime;

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
