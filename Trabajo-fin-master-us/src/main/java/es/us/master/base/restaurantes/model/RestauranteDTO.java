package es.us.master.base.restaurantes.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteDTO {
	@JsonProperty("Id")
	public String id;
	@JsonProperty("description")
	public String description;
	@JsonProperty("avg_rate")
	public BigDecimal avgRate;
	@JsonProperty("hour_open")
	public String hourOpen;
	@JsonProperty("locale")
	public String locale;
	@JsonProperty("freeTables")
	public BigDecimal freeTables;
	@JsonProperty("name")
	public String name;
	@JsonProperty("phone")
	public String phone;
	@JsonProperty("speciality")
	public String speciality;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(BigDecimal avgRate) {
		this.avgRate = avgRate;
	}

	public String getHourOpen() {
		return hourOpen;
	}

	public void setHourOpen(String hourOpen) {
		this.hourOpen = hourOpen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public BigDecimal getFreeTables() {
		return freeTables;
	}

	public void setFreeTables(BigDecimal freeTables) {
		this.freeTables = freeTables;
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
		RestauranteDTO other = (RestauranteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
