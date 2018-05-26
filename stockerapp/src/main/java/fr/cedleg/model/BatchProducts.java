package fr.cedleg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name= BatchProducts.GET_ALL, query="select distinct b from BatchProducts b order by b.name")

@Entity
@Table(name = "BatchProducts")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7746255995407889064L;
	
	public static final String GET_ALL = "getAllBatchProducts";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id", updatable = false, nullable = false)
	@XmlElement
	private Long id;

	@Column(name = "batch_name")
	@XmlElement
	private String name;
	
	@Column(name = "batch_ref")
	@XmlElement
	private String reference;

	@Column(name = "batch_price")
	@XmlElement
	private Double price;

	@Column(name = "batch_desc")
	@XmlElement
	private String description;

	@ManyToMany(fetch=FetchType.EAGER)
	@XmlElement
	private List<Product> products = new ArrayList<Product>();

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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(final List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		BatchProducts other = (BatchProducts) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		return "BatchProducts [id=" + id + ", name=" + name + ", reference=" + reference + ", price=" + price
				+ ", description=" + description + "]";
	}
	
}
