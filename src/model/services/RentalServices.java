package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {
    private Double pricePerHour;
    private Double pricePerDay;
    // Associação com BrazilTaxService
    private BrazilTaxService taxService;

    public RentalServices(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        // Para achar a diferença em horas, preciso fazer em milisegundos, usando getTime()
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        // fazendo cast, para garantir o resultado em double
        double hours = (double) (t2 - t1) / 1000 / 60 / 60; // forçando a conversão de milisegundos p/ horas

        double basicPayment;
        if (hours <= 12.0) {
            // arredondar p/cima Math.ceil();
            basicPayment = Math.ceil(hours) * pricePerHour;
        }
        else{
            basicPayment = Math.ceil(hours/24) * pricePerDay;
        }

        // Para calcular o imposto
        double tax = taxService.tax(basicPayment);

        // Instanciar um novo objeto CarRental
        // Criei um novo objeto de nota de pagamento e associei ele ao meu objeto de aluguel
        carRental.setInvoice(new Invoice(basicPayment, tax));


    }
}
