package iti.digital.itau.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import iti.digital.itau.dto.PasswordDTO;

@Api(value = "PasswordController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, protocols = "http", tags = "Password Resource Operations")
public interface PasswordController {

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, protocols = "http", value = "POST service to validate passwords", notes = "validate passwords")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Valid Password"),
			@ApiResponse(code = 400, message = "Invalid Password", response = PasswordDTO.class) })
	public ResponseEntity<PasswordDTO> validate(PasswordDTO passwordDTO);

}
