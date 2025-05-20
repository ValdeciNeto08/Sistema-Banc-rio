package sistemaBancario;

// ContaPoupanca: herda de Conta, adiciona taxaJuros com getters/setters
class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(Cliente cliente, double taxaJuros) {
        super(cliente);
        setTaxaJuros(taxaJuros);
    }

    
    public double getTaxaJuros() {
        return taxaJuros;
    }
    
    public void setTaxaJuros(double taxaJuros) {
        if (taxaJuros < 0) {
            throw new IllegalArgumentException("Taxa de juros deve ser positiva");
        }
        this.taxaJuros = taxaJuros;
    }

    // Calcula rendimento sobre o saldo atual
    public double calcularRendimento() {
        return getSaldo() * taxaJuros;
    }
}