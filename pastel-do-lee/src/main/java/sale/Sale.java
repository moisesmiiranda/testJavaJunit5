package sale;

import client.Client;
import lombok.Builder;
import salesman.Salesman;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
public class Sale {
    private final BigDecimal purchaseValue;
    private final BigDecimal cashback;
    private final Salesman salesman;
    private final Client client;

    @Builder.Default
    private final LocalDate dateOfSale = LocalDate.now();
}
