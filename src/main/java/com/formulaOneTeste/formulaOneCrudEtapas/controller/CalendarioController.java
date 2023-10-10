package com.formulaOneTeste.formulaOneCrudEtapas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formulaOneTeste.formulaOneCrudEtapas.model.entities.Calendario;
import com.formulaOneTeste.formulaOneCrudEtapas.model.repositories.CalendarioRespository;

@RestController()
@RequestMapping("/calendario")
public class CalendarioController {
	@Autowired
	CalendarioRespository calendarioRespository;
	
	@GetMapping()
	public Iterable<Calendario> getCalendario() {
		return calendarioRespository.findAll();
	}
	
	@PostMapping
	public @ResponseBody Calendario postCalendario(
			@RequestParam String nome,
			@RequestParam String urlCircuito,
			@RequestParam String urlBandeiraPais,
			@RequestParam String data) {
		Calendario calendario = new Calendario(nome, urlCircuito, urlBandeiraPais, data);
		calendarioRespository.save(calendario);
		return calendario;
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Calendario> getCalendarioById(@PathVariable int id) {
		return calendarioRespository.findById(Integer.valueOf(id));
	}
	
	@PutMapping(path = "/{id}")
	public @ResponseBody Optional<Calendario> alterCalendario(
			@PathVariable int id,
			@RequestParam String nome,
			@RequestParam String urlCircuito,
			@RequestParam String urlBandeiraPais,
			@RequestParam String data) {
		Calendario calendario = new Calendario(id, nome, urlCircuito, urlBandeiraPais, data);
		calendarioRespository.save(calendario);
		return calendarioRespository.findById(Integer.valueOf(id));
	}
	
	@DeleteMapping(path = "/{id}")
	public Iterable<Calendario> deleteById(@PathVariable int id) {
		calendarioRespository.deleteById(Integer.valueOf(id));
		
		return calendarioRespository.findAll();
	}
}
