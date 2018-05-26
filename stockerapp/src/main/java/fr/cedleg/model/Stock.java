package fr.cedleg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Stock")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8111473808567874302L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id", updatable = false, nullable = false)
	@XmlElement
	private Long id;
	
	@Column(name = "stock_amount")
	@XmlElement
	private Double amount;

	@OneToOne
	@XmlElement
	private Unit unit;

	
	public Stock() {
		super();
	}

	public Stock(Double amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", amount=" + amount + ", unit=" + unit + "]";
	}

}
