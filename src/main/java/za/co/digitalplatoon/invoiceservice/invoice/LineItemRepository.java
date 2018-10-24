package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.data.repository.CrudRepository;

public interface LineItemRepository extends CrudRepository<LineItem, Long> {

}
