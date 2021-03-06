package dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class FlightDto {
	
	private final Long id;
	private final String description;
	
	/*Конструктор автоматически сгенерирован ломбоком*/
//	public FlightDto(Long id, String description) {
//		this.id = id;
//		this.description = description;
//	}
	/*Геттеры автоматически сгенерированы ломбоком*/
//	public Long getId() {
//		return id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
	/*Эквивалс и хэшкод сгенерированы ломбоком*/
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((description == null) ? 0 : description.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		FlightDto other = (FlightDto) obj;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
	/*Тустринг сгенерирован ломбоком*/
//	@Override
//	public String toString() {
//		return "FlightDto [id=" + id + ", description=" + description + "]";
//	}
	
	
	
	
	
	

}
