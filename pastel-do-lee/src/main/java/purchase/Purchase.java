package purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Builder
@AllArgsConstructor
public class Purchase {

    private List<Item> itens;

    public BigDecimal getTotal() {
        return itens.stream()
                .map(Item::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
