package entity;

import java.math.BigDecimal;

public class Ticket {
	private Long id;
	private String passengerNum;
	private String passengerName;
	private Long flightId;
	private String seatNum;
	private BigDecimal cost;
	
	public Ticket(Long id, String passengerNum, String passengerName, Long flightId, String seatNum, BigDecimal cost) {
		this.id = id;
		this.passengerNum = passengerNum;
		this.passengerName = passengerName;
		this.flightId = flightId;
		this.seatNum = seatNum;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(String passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerNum == null) ? 0 : passengerNum.hashCode());
		result = prime * result + ((seatNum == null) ? 0 : seatNum.hashCode());
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
		Ticket other = (Ticket) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerNum == null) {
			if (other.passengerNum != null)
				return false;
		} else if (!passengerNum.equals(other.passengerNum))
			return false;
		if (seatNum == null) {
			if (other.seatNum != null)
				return false;
		} else if (!seatNum.equals(other.seatNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", passengerNum=" + passengerNum + ", passengerName=" + passengerName
				+ ", flightId=" + flightId + ", seatNum=" + seatNum + ", cost=" + cost + "]";
	}
	
}
