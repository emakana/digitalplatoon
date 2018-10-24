package za.co.digitalplatoon.invoiceservice.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
	
	public static BigDecimal amount(BigDecimal bigDecimal) {
		if (bigDecimal == null ) {
			return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}

}
