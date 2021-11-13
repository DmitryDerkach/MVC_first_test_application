package entity;

import java.time.LocalDateTime;

public class Flight {
	private Long id;
	private String flightNum;
	private LocalDateTime departureDate;
	private String departureAirportCode;
	private LocalDateTime arrivalDate;
	private String arrivalAirpotrCode;
	private Integer aircraftId;
	private FlightStatus status;
	
	public Flight(Long id, String flightNum, LocalDateTime departureDate, String departureAirportCode,
			LocalDateTime arrivalDate, String arrivalAirpotrCode, Integer aircraftId, FlightStatus status) {
		this.id = id;
		this.flightNum = flightNum;
		this.departureDate = departureDate;
		this.departureAirportCode = departureAirportCode;
		this.arrivalDate = arrivalDate;
		this.arrivalAirpotrCode = arrivalAirpotrCode;
		this.aircraftId = aircraftId;
		this.status = status;	
	}
	
	public Flight() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalAirpotrCode() {
		return arrivalAirpotrCode;
	}

	public void setArrivalAirpotrCode(String arrivalAirpotrCode) {
		this.arrivalAirpotrCode = arrivalAirpotrCode;
	}

	public Integer getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(Integer aircraftId) {
		this.aircraftId = aircraftId;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNum=" + flightNum + ", departureDate=" + departureDate
				+ ", departureAirportCode=" + departureAirportCode + ", arrivalDate=" + arrivalDate
				+ ", arrivalAirpotrCode=" + arrivalAirpotrCode + ", aircraftId=" + aircraftId + ", status=" + status
				+ "]";
	}
	
	
	
	
}
 