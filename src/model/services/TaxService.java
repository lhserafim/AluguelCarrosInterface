package model.services;

public interface TaxService {
    // Definição de qual será o contrato
    // Vantagem de se usar interface, baixo acoplamento
    double tax (double amount);
}
