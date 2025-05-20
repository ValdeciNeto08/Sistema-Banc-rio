package sistemaBancario;

// Classe abstrata Conta: serve de base para diferentes tipos de conta
// Aplica encapsulamento em atributos comuns e implementa interface Transacao
abstract class Conta implements Transacao {

    private static int contador = 1000; // gera número de conta automático
    private int numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        setNumeroConta(contador++);  
        setCliente(cliente);         
        this.saldo = 0.0;            // saldo inicia em zero
    }

    
    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        if (numeroConta <= 0) {
            throw new IllegalArgumentException("Número da conta deve ser positivo");
        }
        this.numeroConta = numeroConta;
    }

    
    public double getSaldo() {
        return saldo;
    }
    
    protected void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.cliente = cliente;
    }

    // Implementação padronizada de depositar() pela interface Transacao
    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        setSaldo(this.saldo + valor);
    }

    // Implementação padronizada de sacar() pela interface Transacao
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (this.saldo >= valor) {
            setSaldo(this.saldo - valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    
    public void transferir(Conta destino, double valor) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta de destino inválida");
        }
        this.sacar(valor);      // padronizado pela interface
        destino.depositar(valor);
    }

    
    public void exibirInfo() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$" + String.format("%.2f", saldo));
    }
}
