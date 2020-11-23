package br.com.companyhoteis.controllers;

import br.com.companyhoteis.domain.Endereco;
import br.com.companyhoteis.domain.Hotel;
import br.com.companyhoteis.services.EnderecoService;
import br.com.companyhoteis.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/cadastrar")
    public String cadastrarHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "views/cadastro-hotel";
    }

    @PostMapping("/cadastrar")
    public String salvarHotel(@Valid Hotel hotel, BindingResult result) {
        if (result.hasErrors()) {
            return "views/cadastro-hotel";
        }
        hotelService.salvarHotel(hotel);
        return "views/sucesso";
    }

    @GetMapping("/listar")
    public String listarHoteis(Model model) {
        List<Hotel> listaHoteis = hotelService.listarHoteis();
        model.addAttribute("listaHoteis", listaHoteis);
        return "views/lista-hoteis";
    }

    @GetMapping("/{id}/detalhes")
    public String detalhesHotel(@PathVariable("id") Long id, Model model) {
        Hotel hotel = hotelService.detalhes(id);
        List<Endereco> endereco = enderecoService.listaByIdEndereco(id);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listaEnderecos", endereco);
        return "views/detalhes";
    }

    @GetMapping("/cadastrar/{id}/endereco")
    public String cadastroEndereco(@PathVariable("id") Long id, Model model) {
        model.addAttribute("endereco", new Endereco());
        model.addAttribute("id_hotel", id);
        return "views/cadastro-endereco";
    }

    @PostMapping("/cadastrar/endereco")
    public String cadastroEndereco(@Valid Endereco endereco, BindingResult rs) {
        if (rs.hasErrors()) {
            return "views/cadastro-endereco";
        }
        enderecoService.salvarEndereco(endereco);
        return "views/sucesso";
    }

    @GetMapping("/{id}/get-endereco/{idEnd}")
    public String getEndereco(@PathVariable("idEnd") Long id, Model model) {
        Endereco endereco = enderecoService.getEndereco(id);
        model.addAttribute("postEndereco", endereco);
        return "views/editar-endereco";
    }

    @PostMapping("/get-endereco")
    public String updateEndereco(Endereco endereco) {
        enderecoService.updateEndereco(endereco);
        return "views/redirect-detalhes3";
    }
}
