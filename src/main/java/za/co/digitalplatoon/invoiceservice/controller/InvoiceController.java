package za.co.digitalplatoon.invoiceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.digitalplatoon.invoiceservice.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.InvoiceService;

@RestController
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(method=RequestMethod.POST,value="/invoices")
	public void addInvoice(@RequestBody Invoice invoice) {
		invoiceService.addInvoice(invoice);
	}
	
	@RequestMapping("/invoices") 
	public List <Invoice> viewAllInvoices(){
		return invoiceService.viewAllInvoices();
	}
	
	@RequestMapping("/invoices/{invoiceId}") 
	public Invoice viewInvoice(@PathVariable String invoiceId) {
		
		return invoiceService.viewInvoice(invoiceId);
	}
}
