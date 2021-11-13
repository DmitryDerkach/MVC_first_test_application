package dto;

public class TicketDto {

	private final Long id;
	private final Long flightId;
	private final String seatNum;
	
	public TicketDto(Long id, Long flightId, String seatNum) {
		this.id = id;
		this.flightId = flightId;
		this.seatNum = seatNum;
	}

	public Long getId() {
		return id;
	}

	public Long getFlightId() {
		return flightId;
	}

	public String getSeatNum() {
		return seatNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TicketDto other = (TicketDto) obj;
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
		if (seatNum == null) {
			if (other.seatNum != null)
				return false;
		} else if (!seatNum.equals(other.seatNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", flightId=" + flightId + ", seatNum=" + seatNum + "]";
	}
	
}
