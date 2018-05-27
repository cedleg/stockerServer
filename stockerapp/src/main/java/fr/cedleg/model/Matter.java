package fr.cedleg.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name= Matter.GET_ALL_MATTERS, query="select distinct m from Matter m order by m.name")

@Entity
@Table(name = "Matter")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Matter implements Serializable {
	
	public static final String GET_ALL_MATTERS = "getAllMatters";

	/**
	 * 
	 */
	private static final long serialVersionUID = -3560455531020021376L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matter_id", updatable = false, nullable = false)
	@XmlElement
	private Long id;

	@Column(name = "matter_name", nullable = false)
	@XmlElement
	private String name;
	
	@Column(name = "matter_ref")
	@XmlElement
	private String reference;

	@Column(name = "matter_desc")
	@XmlElement
	private String description;

	@Column(name = "matter_price")
	@XmlElement
	private Double price;

	@ManyToOne(cascade=CascadeType.ALL)
	@XmlElement
	private Stock stock;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Matter other = (Matter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matter [id=" + id + ", name=" + name + ", reference=" + reference + ", description=" + description
				+ ", price=" + price + ", stock=" + stock.toString() + "]";
	}

}
