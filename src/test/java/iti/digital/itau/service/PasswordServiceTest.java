package iti.digital.itau.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.dto.PasswordDTO;

public class PasswordServiceTest extends AbstractBackendChallengeApplicationTests {

	@Autowired
	private PasswordService passwordService;

	@Test
	public void testValidatePassword() throws Exception {
		List<PasswordDTO> testCases = getTestCases();

		for (PasswordDTO pwDTO : testCases) {
			assertEquals(passwordService.isValid(pwDTO), pwDTO.getValid());
		}
	}

	@Test
	public void testValidatePasswordTwo() throws Exception {
		List<PasswordDTO> testCases = getTestCases();

		for (PasswordDTO pwDTO : testCases) {
			assertEquals(passwordService.isValidTwo(pwDTO), pwDTO.getValid());
		}
	}

	private List<PasswordDTO> getTestCases() throws JsonParseException, JsonMappingException, IOException {
		File json = new File(getClass().getClassLoader().getResource("json/test-cases.json").getFile());
		return mapper.readValue(json, new TypeReference<List<PasswordDTO>>() {
		});
	}

}
