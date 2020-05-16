package model.services;

// Informando que o serviço BrazilTaxService implementa a interface TaxService
public class BrazilTaxService implements TaxService{

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
