package za.co.digitalplatoon.invoiceservice.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import za.co.digitalplatoon.invoiceservice.util.BigDecimalUtil;

@Entity
public class LineItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13467L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;
	
	private Long quantity = 0L;
	
	private String description = null;
	
	private BigDecimal unitPrice = null;
	
	private String invoiceId = null;
	
	public LineItem() {}
	
	public LineItem(String description, BigDecimal unitPrice, Long quantity, String invoiceNo) {
		   super();
		   this.description = description;
		   this.unitPrice = unitPrice;
		   this.quantity = quantity;
		   this.invoiceId = invoiceNo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	 @ManyToOne
	 @JoinColumn(name = "invoiceId")
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	@Transient
	public BigDecimal getLineItemTotal () {
		 BigDecimal bigD = new BigDecimal(quantity.longValue());
		 
		 return BigDecimalUtil.amount(bigD.multiply(unitPrice));
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", quantity=" + quantity + ", description=" + description + ", unitPrice="
				+ unitPrice + ", invoiceId=" + invoiceId + "]";
	}
	
	

}
