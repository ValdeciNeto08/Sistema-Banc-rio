package sistemaBancario;

// Interface Transacao: padroniza operações financeiras em quaisquer tipos de contas
// Define os métodos obrigatórios depositar() e sacar(), garantindo consistência entre as contas

interface Transacao {

    void depositar(double valor);
    void sacar(double valor);
    
}
