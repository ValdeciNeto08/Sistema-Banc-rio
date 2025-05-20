package sistemaBancario;

import java.util.ArrayList;
import java.util.List;

// Classe Banco: gerencia listas de Clientes e Contas, mostrando encapsulamento em coleções
class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    // Getters retornam cópias das listas para evitar modificação direta
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
    public void setClientes(List<Cliente> clientes) {
        if (clientes == null) {
            throw new IllegalArgumentException("Lista de clientes não pode ser nula");
        }
        this.clientes = clientes;
    }

    public List<Conta> getContas() {
        return new ArrayList<>(contas);
    }
    public void setContas(List<Conta> contas) {
        if (contas == null) {
            throw new IllegalArgumentException("Lista de contas não pode ser nula");
        }
        this.contas = contas;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido");
        }
        clientes.add(cliente);
    }
    public void adicionarConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta inválida");
        }
        contas.add(conta);
    }

    // Busca conta pelo número, retornando null se não encontrada
    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }
}