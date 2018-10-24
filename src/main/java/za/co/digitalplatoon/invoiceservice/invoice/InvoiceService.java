package za.co.digitalplatoon.invoiceservice.invoice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	LineItemRepository lineItemRepository;
	
	public List <Invoice> viewAllInvoices(){
		List<Invoice> list = new ArrayList<Invoice>();
		
		invoiceRepository.findAll().forEach(list::add);
		
		return list;
	}
	
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	

	public Invoice viewInvoice(String invoiceId) {
		return invoiceRepository.findInvoiceByInvoiceId(invoiceId);
	}
	
	public List <LineItem> viewAllLineItems(){
		List<LineItem> listItems = new ArrayList<LineItem>();
		
		lineItemRepository.findAll().forEach(listItems::add);
		
		return listItems;
	}
	
	public void addLineItem(LineItem lineItem) {
		lineItemRepository.save(lineItem);
	}
	
	
	public LineItem viewLineItem(Long id) {
		return lineItemRepository.findOne(id);
	}
}
