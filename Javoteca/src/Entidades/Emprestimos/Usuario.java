package Entidades.Emprestimos;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Usuario {
    private String nome;
    private String email;
    private Instant dataNascimento;
    
    // Para gestão de emprestimo e devolução
    private Boolean inventario; // Guarda se o usuário já está com um emprestimo (true) ou não (false).
    private Boolean multa; // Guarda se o usuário tem multa a ser paga (true) ou não (false).
    private Double valor_multa; // Guarda o valor da multa.


    

    public Usuario(String nome, String email, Instant dataNascimento, Boolean inventario, Boolean multa,
            Double valor_multa) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.inventario = inventario;
        this.multa = multa;
        this.valor_multa = valor_multa;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Instant getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Boolean getInventario() {
        return inventario;
    }
    public void setInventario(Boolean inventario) {
        this.inventario = inventario;
    }
    public Boolean getMulta() {
        return multa;
    }
    public void setMulta(Boolean multa) {
        this.multa = multa;
    }
    public Double getValor_multa() {
        return valor_multa;
    }
    public void setValor_multa(Double valor_multa) {
        this.valor_multa = valor_multa;
    }

    public void atualizarStatusEmprestimo(Boolean inventario, Boolean multa, Double valor_multa){ // método para atualizar variaveis do usuario em relação a empréstimos e devoluções.
        this.inventario = inventario;
        this.multa = multa;
        this.valor_multa = valor_multa;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato =  DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("America/Sao_Paulo"));

        return "Usuario: " + nome + " || Email: " + email + " || data de nascimento: " + formato.format(dataNascimento) + "\n";
    }
    
}
