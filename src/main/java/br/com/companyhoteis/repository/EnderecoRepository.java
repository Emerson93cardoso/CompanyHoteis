package br.com.companyhoteis.repository;

import br.com.companyhoteis.domain.Endereco;

import java.util.List;

public interface EnderecoRepository {

    void salvarEndereco(Endereco endereco);
    List<Endereco> listaByIdEndereco(Long id);
    Endereco getEndereco(Long id);
    void updateEndereco(Endereco endereco);
}
