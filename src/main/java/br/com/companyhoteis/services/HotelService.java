package br.com.companyhoteis.services;

import br.com.companyhoteis.domain.Hotel;
import br.com.companyhoteis.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public void salvarHotel(Hotel hotel) {
        hotelRepository.salvarHotel(hotel);
    }

    public List<Hotel> listarHoteis() {

        return hotelRepository.listarHotel();
    }

    public Hotel detalhes(Long id) {
        return hotelRepository.detalhesHotel(id);
    }



}

