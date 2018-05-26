package fr.cedleg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name= Unit.GET_ALL_UNITS, query="select distinct u from Unit u order by u.type")

@Entity
@Table(name = "Unit")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit implements Serializable {

	public static final String GET_ALL_UNITS = "getAllUnits";
	/**
	 * 
	 */
	private static final long serialVersionUID = -2622049842026794073L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id", updatable = false, nullable = false)
	@XmlElement
	private Long id;

	@Column(name = "unit_type", nullable = false)
	@XmlElement
	private String type;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Unit other = (Unit) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (type != null && !type.trim().isEmpty())
			result += "type: " + type;
		return result;
	}
}