package br.com.companyhoteis.repository.impl;

import br.com.companyhoteis.domain.Endereco;
import br.com.companyhoteis.domain.ListaEnderecoWrapper;
import br.com.companyhoteis.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.hotel.endereco}")
    private String urlCadastro;
    @Value("${services.hotel.listarByIdEnderecos}")
    private String urlListarByIdEnderecos;
    @Value("${services.hotel.getEndereco}")
    private String getEndereco;
    @Value("${services.hotel.updateEndereco}")
    private String editarEndereco;

    @Override
    public void salvarEndereco(Endereco endereco) {

        restTemplate.postForEntity(urlCadastro, endereco, Endereco.class);
    }

    public List<Endereco> listaByIdEndereco(Long id) {
        ListaEnderecoWrapper listaEnderecoWrapper = restTemplate
                .getForEntity(String.format(urlListarByIdEnderecos, id), ListaEnderecoWrapper.class ).getBody();
        return listaEnderecoWrapper.getEnderecos();
    }

    public Endereco getEndereco(Long id) {
        Endereco endereco = restTemplate.getForEntity(String.format(getEndereco, id),
                Endereco.class ).getBody();
        return endereco;
    }

    public void updateEndereco(Endereco endereco) {
        restTemplate.postForEntity(editarEndereco, endereco, Endereco.class);
    }
}
