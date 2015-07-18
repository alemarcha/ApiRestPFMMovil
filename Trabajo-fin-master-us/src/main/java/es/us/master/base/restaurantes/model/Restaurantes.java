package es.us.master.base.restaurantes.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANTES", schema = "C##ALEMARCHA")
public class Restaurantes implements java.io.Serializable {


	private static final long serialVersionUID = -3120644555314391308L;
	private BigDecimal id;
	private String description;
	private BigDecimal avgRate;
	private String hourOpen;
	private Double latitud;
	private Double longitud;
	private String name;
	private String phone;
	private String speciality;
	private BigDecimal freetables;
	private String identificador;

	public Restaurantes() {
	}

	public Restaurantes(BigDecimal id) {
		this.id = id;
	}

	public Restaurantes(BigDecimal id, String description, BigDecimal avgRate, String hourOpen, Double latitud,
			Double longitud, String name, String phone, String speciality, BigDecimal freetables,
			String identificador) {
		this.id = id;
		this.description = description;
		this.avgRate = avgRate;
		this.hourOpen = hourOpen;
		this.latitud = latitud;
		this.longitud = longitud;
		this.name = name;
		this.phone = phone;
		this.speciality = speciality;
		this.freetables = freetables;
		this.identificador = identificador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_gen")
	@SequenceGenerator(name = "my_seq_gen", sequenceName = "restaurantes_seq")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "AVG_RATE", precision = 22, scale = 0)
	public BigDecimal getAvgRate() {
		return this.avgRate;
	}

	public void setAvgRate(BigDecimal avgRate) {
		this.avgRate = avgRate;
	}

	@Column(name = "HOUR_OPEN", length = 300)
	public String getHourOpen() {
		return this.hourOpen;
	}

	public void setHourOpen(String hourOpen) {
		this.hourOpen = hourOpen;
	}

	@Column(name = "LATITUD", precision = 126, scale = 0)
	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	@Column(name = "LONGITUD", precision = 126, scale = 0)
	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "SPECIALITY", length = 100)
	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Column(name = "FREETABLES", precision = 22, scale = 0)
	public BigDecimal getFreetables() {
		return this.freetables;
	}

	public void setFreetables(BigDecimal freetables) {
		this.freetables = freetables;
	}
	
	@Column(name = "IDENTIFICADOR", length = 200)
	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
		Restaurantes other = (Restaurantes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}