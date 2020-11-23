package br.com.companyhoteis.domain;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Hotel extends ListaHotelWrapper {

    private Long id;

    @NotEmpty(message = "Favor preencher o nome")
    private String nome;
    @NotEmpty(message = "Favor preencher o email")
    private String email;
    @NotNull(message = "Favor preencher o telefone")
    private String telefone;

    public Long getId() {
        return id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
