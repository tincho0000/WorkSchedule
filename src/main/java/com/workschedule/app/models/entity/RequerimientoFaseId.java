package com.workschedule.app.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequerimientoFaseId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "requerimiento_id")
	private Long requerimientoId;

	@Column(name = "fase_id")
	private Long faseId;

	public RequerimientoFaseId() {
	}

	public RequerimientoFaseId(Long requerimientoId, Long faseId) {
		this.requerimientoId = requerimientoId;
		this.faseId = faseId;
	}

	public Long getRequerimientoId() {
		return requerimientoId;
	}

	public void setRequerimientoId(Long requerimientoId) {
		this.requerimientoId = requerimientoId;
	}

	public Long getFaseId() {
		return faseId;
	}

	public void setFaseId(Long faseId) {
		this.faseId = faseId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faseId, requerimientoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimientoFaseId other = (RequerimientoFaseId) obj;
		return Objects.equals(faseId, other.faseId) && Objects.equals(requerimientoId, other.requerimientoId);
	}

	@Override
	public String toString() {
		return "RequerimientoFaseId [requerimientoId=" + requerimientoId + ", faseId=" + faseId + "]";
	}

}
