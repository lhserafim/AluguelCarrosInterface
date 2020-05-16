package model.services;

public class BrazilTaxService {

    // Aqui estou criando com tipo primitivo double, pq é mais rápido e eu sempre terei um valor
    public double tax(double amount) {
        if (amount <= 100.0) {
            return amount * 0.2;
        }
        else{
            return amount * 0.15;
        }

    }
}
