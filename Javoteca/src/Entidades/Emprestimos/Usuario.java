package Entidades.Emprestimos;

import java.time.Instant;

public class Usuario {
    private String nome;
    private String email;
    private Instant dataNascimento;
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
    public Usuario(String nome, String email, Instant dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
}
