package com.encuentro.matrimonial.controller;

import com.encuentro.matrimonial.constants.ResourceMapping;
import com.encuentro.matrimonial.modelo.Lote;
import com.encuentro.matrimonial.service.ILoteService;
import com.encuentro.matrimonial.util.ErrorMessage;
import com.encuentro.matrimonial.util.ErrorMessage2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourceMapping.LOTE)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class LoteController {

	@Autowired
	private ILoteService loteService;

	// servicio que trae el listado de Lotes
	@GetMapping("/getLotes")
	public ResponseEntity<ErrorMessage<List<Lote>>> getLote() {
		List<Lote> listado = loteService.getLotes();
		ErrorMessage<List<Lote>> error = listado.isEmpty()
				? new ErrorMessage<>(1, "No se ha encontrado información", null)
				: new ErrorMessage<>(0, "Lista de Lotes", listado);
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	// servicio que consulta el total de las vacunas
	@GetMapping("/getTotalVacunas")
	public ResponseEntity<ErrorMessage<List<Lote>>> getTotal() {
		List<Lote> listado = loteService.getLotes();
		int total = 0;
		if (!listado.isEmpty()) {
			for (int i = 0; i < listado.size(); i++) {
				System.out.println(listado.get(i).getCantidad());
				total += listado.get(i).getCantidad();
			}
		}
		return new ResponseEntity(new ErrorMessage(0, "Total de vacunas", total), HttpStatus.OK);
	}

	// servicio para crear un Lote
	@RequestMapping(value = "/createLote", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createLote(@RequestBody Lote lote) {
		Lote lote2 = loteService.findByLote(lote.getId());
		if (lote2 != null) {
			return new ResponseEntity(new ErrorMessage2(1, "El Lote ya se encuentra registrado"), HttpStatus.OK);
		}

		if (lote.getNumero() <= 0 || lote.getCantidad() <= 0 || lote.getCosto() <= 0) {
			return new ResponseEntity(new ErrorMessage2(2, "información incorrecta"), HttpStatus.OK);
		}
		loteService.createLote(lote);
		return new ResponseEntity(new ErrorMessage2(0, "Lote creado con exito!"), HttpStatus.OK);
	}

	// servicio para actualizar un Lote
	@RequestMapping(value = "/updateLote", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> updateLote(@RequestBody Lote lote) {
		Optional<Lote> us = loteService.findByIdLote(lote.getId());
		if (!us.isPresent()) {
			return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado el Lote"), HttpStatus.OK);
		}
		loteService.updateLote(lote);
		return new ResponseEntity(new ErrorMessage2(0, "Lote actualizado con exito!"), HttpStatus.OK);
	}

	// servicio para eliminar un Lote
	@RequestMapping(value = "/deleteLote", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> deleteLote(@RequestBody Lote lote) {
		Optional<Lote> us = loteService.findByIdLote(lote.getId());
		if (!us.isPresent()) {
			return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado el Lote"), HttpStatus.OK);
		}
		loteService.deleteLote(lote.getId());
		return new ResponseEntity(new ErrorMessage2(0, "Lote eliminado con exito!"), HttpStatus.OK);
	}

}
