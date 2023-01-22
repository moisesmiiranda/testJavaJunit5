package dataBase;

import sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Sale> sales = new ArrayList<>();
    public static void addSale (Sale sale) {
        sales.add(sale);
    }
}
