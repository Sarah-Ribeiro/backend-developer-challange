package com.crud.backend.challange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.backend.challange.domain.DataDetailClickBus;
import com.crud.backend.challange.domain.DataListPlaceClickBus;
import com.crud.backend.challange.domain.DataRegisterClickBus;
import com.crud.backend.challange.domain.DataUpdateClickBus;
import com.crud.backend.challange.entity.ClickBusEntity;
import com.crud.backend.challange.repository.ClickBusRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("click/bus/crud")
public class ClickBusController {

	@Autowired
	private ClickBusRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<?> listById(@PathVariable Long id) {
		var clickBus = repository.getReferenceById(id);

		return ResponseEntity.ok(new DataDetailClickBus(clickBus));
	}

	@PostMapping("/create")
	@Transactional
	public ResponseEntity<?> create(@RequestBody @Valid DataRegisterClickBus data, UriComponentsBuilder uriBuilder) {
		var clickBus = (new ClickBusEntity(data));

		repository.save(clickBus);

		var uri = uriBuilder.path("/click/bus/crud/{id}").buildAndExpand(clickBus.getId()).toUri();

		return ResponseEntity.created(uri).body(new DataDetailClickBus(clickBus));
	}

	@GetMapping("/list")
	public ResponseEntity<Page<DataListPlaceClickBus>> list(
			@PageableDefault(size = 10, sort = { "slug" }) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DataListPlaceClickBus::new);

		return ResponseEntity.ok(page);
	}

	@PutMapping("/edit")
	@Transactional
	public ResponseEntity<?> edit(@RequestBody @Valid DataUpdateClickBus data) {
		var clickBus = repository.getReferenceById(data.id());

		clickBus.updateInfo(data);

		return ResponseEntity.ok(new DataDetailClickBus(clickBus));
	}

}
