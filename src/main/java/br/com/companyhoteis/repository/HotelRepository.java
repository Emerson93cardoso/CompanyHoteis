package br.com.companyhoteis.repository;

import br.com.companyhoteis.domain.Hotel;

import java.util.List;

public interface HotelRepository {

    void salvarHotel(Hotel hotel);
    List<Hotel> listarHotel();
    Hotel detalhesHotel(Long id);


}
