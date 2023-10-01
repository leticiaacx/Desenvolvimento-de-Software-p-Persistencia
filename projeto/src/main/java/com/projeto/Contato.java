package com.projeto;

public class Contato {
    private String nome;
    private String sobrenome;
    private String numero;
    private String email;
    private String aniversario;

    public Contato() {}
    
    public Contato(String nome, String sobrenome, String numero, String email, String aniversario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        this.email = email;
        this.aniversario = aniversario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAniversario() {
        return aniversario;
    }
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
}
