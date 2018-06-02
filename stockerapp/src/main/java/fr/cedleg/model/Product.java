package fr.cedleg.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name= Product.GET_ALL_PRODUCTS, query="select distinct p from Product p order by p.name"),
	@NamedQuery(name= Product.GET_PRODUCTS_BY_CAT_NAME, query="select distinct p from Product p where p.category.name = :cat order by p.name")	
})

@Entity
@Table(name = "Product")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	public static final String GET_PRODUCTS_BY_CAT_NAME = "getProductsByCategoryName";
	/**
	 * 
	 */
	private static final long serialVersionUID = -3138673433237241328L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", updatable = false, nullable = false)
	@XmlElement
	private Long id;

	@Column(name = "product_name")
	@XmlElement
	private String name;

	@Column(name = "product_ref")
	@XmlElement
	private String reference;

	@Column(name = "product_price")
	@XmlElement
	private Double price;
	
	@Column(name = "product_desc")
	@XmlElement
	private String description;

	@OneToOne
	@XmlElement
	private Category category;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@XmlElement
	private Stock stock;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@XmlElement
	private List<ComposeProduct> composes;

	public Product() {
		super();
	}

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public List<ComposeProduct> getComposes() {
		return composes;
	}

	public void setComposes(List<ComposeProduct> composes) {
		this.composes = composes;
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
		Product other = (Product) obj;
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
		String stockStr ="";
		String composStr = "";
		if(stock!= null) stockStr = stock.toString();
		if(composes!= null) composStr = composes.toString();
		
		return "Product [id=" + id + ", name=" + name + ", reference=" + reference + ", price=" + price
				+ ", description=" + description + ", category=" + category + ", stock=" + stockStr + ", compo="+ composStr +"]";
	}
	
}
