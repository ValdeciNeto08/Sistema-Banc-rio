package sistemaBancario;

// Classe Cliente: demonstra encapsulamento por meio de atributos privados
// e uso de getters/setters com validações para manter dados sempre válidos

class Cliente {

    private String nome;
    private String cpf;

    
    public Cliente(String nome, String cpf) {
        setNome(nome);     
        setCpf(cpf);       
    }

    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos");
        }
        this.cpf = cpf;
    }
}