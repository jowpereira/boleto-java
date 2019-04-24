package br.com.moduloboleto.dtos;

import java.time.LocalDate;

import br.com.moduloboleto.entities.BoletoTracking;

public class BoletoTrackingDTO {

	private Integer boletoId;
	private Integer ajusteId;
	private String status;
	private LocalDate createTime;
	
	
	public BoletoTrackingDTO() {
	}

	public BoletoTrackingDTO(BoletoTracking obj) {
		this.boletoId   = obj.getBoleto().getBoletoId();
		this.ajusteId   = obj.getAjusteId();
		this.status     = obj.getStatus();
		this.createTime = obj.getCreateTime();
	}



	public Integer getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(Integer boletoId) {
		this.boletoId = boletoId;
	}

	public Integer getAjusteId() {
		return ajusteId;
	}

	public void setAjusteId(Integer ajusteId) {
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
