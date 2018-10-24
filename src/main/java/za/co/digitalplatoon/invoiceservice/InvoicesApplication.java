package za.co.digitalplatoon.invoiceservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;

import za.co.digitalplatoon.invoiceservice.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.InvoiceService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InvoicesApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(InvoicesApplication.class);
	
	@Autowired
	InvoiceService invoiceService;

	public static void main(String[] args) {
		
		 SpringApplication app = new SpringApplication(InvoicesApplication.class);
	     app.setBannerMode(Banner.Mode.OFF);
	     app.run(args);
	}
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {

        log.info("------------TEST DATA----------------- ");
      
        LineItem line1 = new LineItem("Coffee", new BigDecimal(500),1L,"DIG001" );
        LineItem line2 = new LineItem("Sugar", new BigDecimal(200), 2L,"DIG002");
        LineItem line3 = new LineItem("Rama", new BigDecimal(100), 2L,"DIG002");
        LineItem line4 = new LineItem("Coffee", new BigDecimal(500),1L,"DIG003" );
        LineItem line5 = new LineItem("Sugar", new BigDecimal(200), 2L,"DIG003");
        LineItem line6 = new LineItem("Rama", new BigDecimal(100), 2L,"DIG003");
        LineItem line7 = new LineItem("Coffee", new BigDecimal(500),1L,"DIG004" );
        LineItem line8 = new LineItem("Sugar", new BigDecimal(200), 2L,"DIG004");
        LineItem line9 = new LineItem("Rama", new BigDecimal(100), 2L,"DIG004");
        LineItem line10 = new LineItem("Buscuit", new BigDecimal(100), 3L,"DIG004");
       
        
        log.info("------------CREATE LINE ITEMS----------------- ");
        
        invoiceService.addLineItem(line1);
        invoiceService.addLineItem(line2);
        invoiceService.addLineItem(line3);
        invoiceService.addLineItem(line4);
        
        List<LineItem> listItems = new ArrayList<LineItem>();
        listItems.add(line1);
               
        List<LineItem> listItems2 = new ArrayList<LineItem>();
        listItems2.add(line2);
        listItems2.add(line3);
        
        List<LineItem> listItems3 = new ArrayList<LineItem>();
        listItems3.add(line4);
        listItems3.add(line5);
        listItems3.add(line6);
                
        List<LineItem> listItems4 = new ArrayList<LineItem>();
        listItems4.add(line7);
        listItems4.add(line8);
        listItems4.add(line9);
        listItems4.add(line10);
        
        log.info("------------CREATE INVOICES----------------- ");
        
        Invoice invoice1 = new Invoice("Ephraim Makana", listItems, new Double(0.15),new java.util.Date(), "DIG001");
        Invoice invoice2 = new Invoice("Siyabonga Nkosi", listItems2, new Double(0.15),new java.util.Date(), "DIG002");
        Invoice invoice3 = new Invoice("Jonga Kaloku", listItems3, new Double(0.15),new java.util.Date(), "DIG003");
        Invoice invoice4 = new Invoice("Molo Tyhini", listItems4, new Double(0.15),new java.util.Date(), "DIG004");
      
        invoiceService.addInvoice(invoice1);
        invoiceService.addInvoice(invoice2);
        invoiceService.addInvoice(invoice3);
        invoiceService.addInvoice(invoice4);
        
        log.info("\n "+ "---------------- Invoices------------------------");
        for (Invoice invoice : invoiceService.viewAllInvoices()) {
        	log.info("----------------------------------------------------");
            log.info("\n" + invoice.toString());
        }

        log.info("\n "+ "---------------- Line Items------------------------");

        for (LineItem item : invoiceService.viewAllLineItems()) {
        	log.info("----------------------------------------------------");
            log.info("\n"+item.toString());
        }
     
    
    }
}
