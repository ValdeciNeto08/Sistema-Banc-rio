package sistemaBancario;

// ContaCorrente: herda de Conta, adiciona atributo limite com getters/setters
class ContaCorrente extends Conta {
    private double limite;

    
    public ContaCorrente(Cliente cliente, double limite) {
        super(cliente);    // encaminha inicialização de cliente e saldo
        setLimite(limite); 
    }

    // Getter de limite
    public double getLimite() {
        return limite;
    }
    
    public void setLimite(double limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
        this.limite = limite;
    }

    // Sobrescrita de sacar(): permite usar o limite extra além do saldo
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        // permite usar saldo + limite
        if (getSaldo() + limite >= valor) {
            super.setSaldo(getSaldo() - valor);
        } else {
            throw new IllegalArgumentException("Saldo + limite insuficiente");
        }
    }
}
