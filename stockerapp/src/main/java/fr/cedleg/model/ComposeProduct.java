package fr.cedleg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ComposeProduct")

public class ComposeProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "comp_qty", nullable = false)
	private Long quantity;
	
	@OneToOne
	private Matter matter;

	public ComposeProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComposeProduct(Long quantity, Matter matter) {
		super();
		this.quantity = quantity;
		this.matter = matter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matter == null) ? 0 : matter.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		ComposeProduct other = (ComposeProduct) obj;
		if (matter == null) {
			if (other.matter != null)
				return false;
		} else if (!matter.equals(other.matter))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComposeProduct [id=" + id + ", quantity=" + quantity + ", matter=" + matter + "]";
	}
	
	
}
