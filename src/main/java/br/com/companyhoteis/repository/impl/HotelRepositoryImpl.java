package br.com.companyhoteis.repository.impl;

import br.com.companyhoteis.domain.Endereco;
import br.com.companyhoteis.domain.Hotel;
import br.com.companyhoteis.domain.ListaEnderecoWrapper;
import br.com.companyhoteis.domain.ListaHotelWrapper;
import br.com.companyhoteis.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.hotel.salvar}")
    private String urlSalvarHotel;

    @Value("${services.hotel.listar}")
    private String urlListarHoteis;

    @Value("${services.hotel.detalhes}")
    private String urlDetalhesHotel;

    @Override
    public void salvarHotel(Hotel hotel) {

        restTemplate.postForEntity(urlSalvarHotel, hotel, String.class);
    }

    @Override
    public List<Hotel> listarHotel() {
    ListaHotelWrapper hotelWrapper = restTemplate.getForEntity(
            urlListarHoteis, ListaHotelWrapper.class).getBody();

    return hotelWrapper.getHoteis();
    }

    @Override
    public Hotel detalhesHotel(Long id) {
       Hotel hotel = restTemplate.getForEntity(String.format(urlDetalhesHotel, id), Hotel.class).getBody();
        return hotel;
    }

}
