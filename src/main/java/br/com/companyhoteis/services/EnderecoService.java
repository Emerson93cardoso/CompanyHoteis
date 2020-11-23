package br.com.companyhoteis.services;

import br.com.companyhoteis.domain.Endereco;
import br.com.companyhoteis.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.salvarEndereco(endereco);
    }


    public List<Endereco> listaByIdEndereco(Long id) {
        return enderecoRepository.listaByIdEndereco(id);
    }

    public Endereco getEndereco(Long id) {
        return enderecoRepository.getEndereco(id);
    }

    public void updateEndereco(Endereco endereco) {
        enderecoRepository.updateEndereco(endereco);
    }
}