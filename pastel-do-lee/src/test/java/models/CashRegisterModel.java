package models;


import cashRegister.CashRegister;
import client.Client;
import salesman.Salesman;

public class CashRegisterModel {
    public static CashRegister.CashRegisterBuilder buildScenario() {
        return CashRegister.builder()
                .salesman(new Salesman(1, "Jet Li"))
                .client(new Client("Bruce Lee"));
    }
}
