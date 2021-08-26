package iti.digital.itau.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import iti.digital.itau.controller.PasswordController;
import iti.digital.itau.dto.PasswordDTO;
import iti.digital.itau.rule.view.Views;
import iti.digital.itau.service.PasswordService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/password")
public class PasswordControllerImpl implements PasswordController {

	@Autowired
	private PasswordService passwordService;

	@Override
	@PostMapping(path = "/validate")
	@JsonView(value = Views.PasswordValidation.class)
	public ResponseEntity<PasswordDTO> validate(@Valid @RequestBody PasswordDTO passwordDTO) {
		log.info("validate({})", passwordDTO.getPassword());

		boolean isValid = passwordService.isValid(passwordDTO);
		return (isValid ? ResponseEntity.ok(PasswordDTO.builder().valid(Boolean.TRUE).build())
				: ResponseEntity.badRequest().body(PasswordDTO.builder().valid(Boolean.FALSE).build()));
	}

}
