package sistemaBancario;

// Classe principal: demonstra uso de construtores, getters/setters, encapsulamento e interface
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Inicialização de clientes via construtor (usa setters internamente)
        Cliente joao = new Cliente("João da Silva", "12345678901");
        Cliente maria = new Cliente("Maria Oliveira", "10987654321");

        // Adiciona clientes ao banco (validação de null)   
        banco.adicionarCliente(joao);
        banco.adicionarCliente(maria);

        // Criação de contas: ContaCorrente e ContaPoupanca usando construtores específicos
        ContaCorrente contaJoao = new ContaCorrente(joao, 500.0);
        ContaPoupanca contaMaria = new ContaPoupanca(maria, 0.05);

        banco.adicionarConta(contaJoao);
        banco.adicionarConta(contaMaria);

        // Operações padronizadas pela interface Transacao
        contaJoao.depositar(1000.0);
        contaMaria.depositar(500.0);
        contaJoao.sacar(300.0);
        contaJoao.transferir(contaMaria, 200.0);

        // Exibição de informações e cálculo de rendimento
        System.out.println("=== Conta João ===");
        contaJoao.exibirInfo();

        System.out.println("\n=== Conta Maria ===");
        contaMaria.exibirInfo();
        System.out.println("Rendimento previsto: R$" + String.format("%.2f", contaMaria.calcularRendimento()));
    }
}