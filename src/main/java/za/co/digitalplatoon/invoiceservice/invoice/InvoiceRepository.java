package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	Invoice findInvoiceByInvoiceId(String invoiceId);
}
