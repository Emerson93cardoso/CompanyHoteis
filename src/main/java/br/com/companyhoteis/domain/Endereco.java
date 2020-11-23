package br.com.companyhoteis.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Endereco {

    private Long id;
    private Long idHotel;
    @NotEmpty(message = "Favor preencher logradouro")
    private String logradouro;
    @NotNull(message = "Favor preencher numero")
    private Integer numero;
    @NotEmpty(message = "Favor preencher complemento")
    private String complemento;
    @NotEmpty(message = "Favor preencher estado")
    private String estado;
    @NotEmpty(message = "Favor preencher uf")
    private String uf;
    @NotEmpty(message = "Favor preencher cep")
    private String cep;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
