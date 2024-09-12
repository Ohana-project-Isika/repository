package fr.isika.cda11.ohana.project.membership.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.MemberShipManage;

public class MembershipDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4979763868804195542L;
	private Long idMbs;
	private String nameMbs;		
	private BigDecimal priceOfFee;

	// relations
	private MemberShipManageDto memberShipManage;
	private List<MemberDto> members = new ArrayList<MemberDto>();


	public MembershipDto() {}


	public Long getIdMbs() {
		return idMbs;
	}


	public void setIdMbs(Long idMbs) {
		this.idMbs = idMbs;
	}


	public String getNameMbs() {
		return nameMbs;
	}


	public void setNameMbs(String nameMbs) {
		this.nameMbs = nameMbs;
	}



	public BigDecimal getPriceOfFee() {
		return priceOfFee;
	}


	public void setPriceOfFee(BigDecimal priceOfFee) {
		this.priceOfFee = priceOfFee;
	}


	public MemberShipManageDto getMemberShipManage() {
		return memberShipManage;
	}


	public void setMemberShipManage(MemberShipManageDto memberShipManage) {
		this.memberShipManage = memberShipManage;
	}


	public List<MemberDto> getMembers() {
		return members;
	}


	public void setMembers(List<MemberDto> members) {
		this.members = members;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMbs == null) ? 0 : idMbs.hashCode());
		result = prime * result + ((memberShipManage == null) ? 0 : memberShipManage.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((nameMbs == null) ? 0 : nameMbs.hashCode());
		result = prime * result + ((priceOfFee == null) ? 0 : priceOfFee.hashCode());
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
		MembershipDto other = (MembershipDto) obj;
		if (idMbs == null) {
			if (other.idMbs != null)
				return false;
		} else if (!idMbs.equals(other.idMbs))
			return false;
		if (memberShipManage == null) {
			if (other.memberShipManage != null)
				return false;
		} else if (!memberShipManage.equals(other.memberShipManage))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (nameMbs == null) {
			if (other.nameMbs != null)
				return false;
		} else if (!nameMbs.equals(other.nameMbs))
			return false;
		if (priceOfFee == null) {
			if (other.priceOfFee != null)
				return false;
		} else if (!priceOfFee.equals(other.priceOfFee))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MembershipDto [idMbs=" + idMbs + ", nameMbs=" + nameMbs + ", priceOfFee=" + priceOfFee
				+ ", memberShipManage=" + memberShipManage + ", members=" + members + "]";
	}


	
	

}
