package za.co.digitalplatoon.invoiceservice.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import za.co.digitalplatoon.invoiceservice.util.BigDecimalUtil;

@Entity
public class Invoice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;
	
	private String client = null;
	
	private Double vatRate = 0.0;
	
	private Date vatDate = null;
	
	@OneToMany(targetEntity = za.co.digitalplatoon.invoiceservice.invoice.LineItem.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<LineItem> listItems;
	
	private String invoiceId = null;
	
	
	public Invoice() {}
	
	public Invoice(String client, List<LineItem> listItems, Double vatRate, Date vatDate, String invoiceId) {
		super();
		this.client = client;
		this.listItems = listItems;
		this.vatRate = vatRate;
		this.vatDate = vatDate;
		this.invoiceId = invoiceId;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public Date getVatDate() {
		return vatDate;
	}

	public void setVatDate(Date vatDate) {
		this.vatDate = vatDate;
	}
	
	public List<LineItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<LineItem> listItems) {
		this.listItems = listItems;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	@Transient
	public BigDecimal getSubTotal() {
		
		BigDecimal subTotal = new BigDecimal(0);
		for (LineItem item : listItems) {
			 subTotal.add(item.getLineItemTotal());
		}
		
		return BigDecimalUtil.amount(subTotal);
	}
	
	@Transient
	public BigDecimal getVat() {
		BigDecimal bigD = new BigDecimal(vatRate.doubleValue());
		
		return BigDecimalUtil.amount(bigD.multiply(getSubTotal()));
	}
	
	@Transient
	public BigDecimal getTotal() {
		return BigDecimalUtil.amount(getSubTotal().add(getVat()));
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", client=" + client + ", vatRate=" + vatRate + ", vatDate=" + vatDate
				+ ", listItems=" + listItems + ", invoiceId=" + invoiceId + "]";
	}

	

}
