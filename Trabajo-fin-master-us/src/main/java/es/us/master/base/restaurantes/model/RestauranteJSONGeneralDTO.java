package es.us.master.base.restaurantes.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteJSONGeneralDTO {

	public RestauranteJSONGeneralDTO() {
	}
	public BigDecimal id;
	@JsonProperty("Total")
	public long total;
	public long max_score;
	@JsonProperty("Hits")
	public List<HitsDTO> hits;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getMax_score() {
		return max_score;
	}
	public void setMax_score(long max_score) {
		this.max_score = max_score;
	}
	public List<HitsDTO> getHits() {
		return hits;
	}
	public void setHits(List<HitsDTO> hits) {
		this.hits = hits;
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
		RestauranteJSONGeneralDTO other = (RestauranteJSONGeneralDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}
