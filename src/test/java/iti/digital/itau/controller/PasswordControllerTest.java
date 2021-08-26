package iti.digital.itau.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.dto.PasswordDTO;
import iti.digital.itau.service.PasswordService;

public class PasswordControllerTest extends AbstractBackendChallengeApplicationTests {

	private static final String RESOURCE = "/api/password/validate";

	@MockBean
	private PasswordService passwordService;

	@Test
	public void testValidatePasswordOK() throws Exception {
		when(passwordService.isValid(Mockito.any(PasswordDTO.class))).thenReturn(true);

		MvcResult retorno = mockMvc
				.perform(post(RESOURCE).content(mapper.writeValueAsString(buildPasswordDTO("123456789")))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		PasswordDTO response = mapper.readValue(retorno.getResponse().getContentAsString(), PasswordDTO.class);
		assertTrue(response.getValid());
	}

	@Test
	public void testValidatePasswordNOK() throws Exception {
		when(passwordService.isValid(Mockito.any(PasswordDTO.class))).thenReturn(false);

		MvcResult retorno = mockMvc
				.perform(post(RESOURCE).content(mapper.writeValueAsString(buildPasswordDTO("123456789")))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest()).andReturn();

		PasswordDTO response = mapper.readValue(retorno.getResponse().getContentAsString(), PasswordDTO.class);
		assertFalse(response.getValid());
	}

}
