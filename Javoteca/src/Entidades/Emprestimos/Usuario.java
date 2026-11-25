package Entidades.Emprestimos;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Usuario {
    // Dados pessoais usados para identificar o usuário no sistema.
    private String nome;
    private String email;
    private Instant dataNascimento;
    
    // Dados utilizados no controle de empréstimos e devoluções.
    private Boolean inventario; // Indica se o usuário possui um empréstimo ativo.
    private Boolean multa; // Indica se existe uma multa pendente.
    private Double valor_multa; // Armazena o valor da multa pendente.


    

    // Inicializa os dados pessoais e o estado inicial do usuário no sistema.
    public Usuario(String nome, String email, Instant dataNascimento, Boolean inventario, Boolean multa,
            Double valor_multa) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.inventario = inventario;
        this.multa = multa;
        this.valor_multa = valor_multa;
    }

    // Retorna o nome do usuário.
    public String getNome() {
        return nome;
    }

    // Atualiza o nome do usuário.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o email usado para identificar o usuário.
    public String getEmail() {
        return email;
    }

    // Atualiza o email do usuário.
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna a data de nascimento do usuário.
    public Instant getDataNascimento() {
        return dataNascimento;
    }

    // Atualiza a data de nascimento do usuário.
    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Indica se o usuário está com um empréstimo em andamento.
    public Boolean getInventario() {
        return inventario;
    }

    // Atualiza o estado de empréstimo ativo do usuário.
    public void setInventario(Boolean inventario) {
        this.inventario = inventario;
    }

    // Indica se o usuário possui uma multa a pagar.
    public Boolean getMulta() {
        return multa;
    }

    // Atualiza a situação da multa do usuário.
    public void setMulta(Boolean multa) {
        this.multa = multa;
    }

    // Retorna o valor atual da multa.
    public Double getValor_multa() {
        return valor_multa;
    }

    // Atualiza o valor da multa.
    public void setValor_multa(Double valor_multa) {
        this.valor_multa = valor_multa;
    }

    // Atualiza juntos o estado do empréstimo, a situação da multa e seu valor.
    public void atualizarStatusEmprestimo(Boolean inventario, Boolean multa, Double valor_multa){
        this.inventario = inventario;
        this.multa = multa;
        this.valor_multa = valor_multa;
    }

    @Override
    public String toString() {
        // Converte a data de nascimento para o padrão brasileiro.
        DateTimeFormatter formato =  DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("America/Sao_Paulo"));

        return "Usuario: " + nome + " || Email: " + email + " || data de nascimento: " + formato.format(dataNascimento) + "\n";
    }
    
}
