package br.com.fiap.gs1.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gs1.dtos.ViagemDto;
import br.com.fiap.gs1.models.Viagem;
import br.com.fiap.gs1.repositories.ViagemRepository;


@Controller
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	
	
	@GetMapping("/viagem")
	public ModelAndView Cadastro(ViagemDto viagem) {
		ModelAndView modelView = new ModelAndView("viagem/index");
		return modelView;
	}
	
	@PostMapping("/viagem")
	public ModelAndView Salvar(@Valid ViagemDto viagem, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Erro na hora de cadastrar produto");
			return new ModelAndView("viagem/index");
		}
		
		Viagem viagemEntity = modelMapper.map(viagem, Viagem.class);
		viagemRepository.save(viagemEntity); 
	
		return new ModelAndView("redirect:/listar");
	}
	

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("viagem/listar");
	
		List<Viagem> listaViagens = viagemRepository.findAll();
		modelView.addObject("listarViagens", listaViagens);
		
		return modelView;
	}
	
	@GetMapping("/viagem/{id}/editar")
	public ModelAndView editar(@PathVariable int id, ViagemDto request) {
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);
		
		if(optionalViagem.isPresent()) {
			Viagem viagem = optionalViagem.get();
			request.fromViagem(viagem);
			ModelAndView modelView = new ModelAndView("viagem/editar");
			modelView.addObject("viagemId", viagem.getId());
			return modelView;
		}
		
		return new ModelAndView("redirect:/listar");
	}
	
	
	
	
	@PostMapping("/viagem/{id}")
	public ModelAndView atualizarViagem(@PathVariable Integer id, @Valid ViagemDto request, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView modelView = new ModelAndView("viagem/editar");
			modelView.addObject("viagemId", id);
			return modelView;
		}
		
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);

		if(optionalViagem.isPresent()) {
			Viagem viagem = modelMapper.map(request, Viagem.class);
			viagem.setId(id);
			viagemRepository.save(viagem);
			return new ModelAndView("redirect:/listar");
		}
		
		return null;
	}
	
	@GetMapping("/viagem/{id}/deletar")
	public ModelAndView delete(@PathVariable Integer id) {
		ModelAndView modelView = new ModelAndView("redirect:/listar");
		this.viagemRepository.deleteById(id);
		return modelView;
	}
	
	
	
}
