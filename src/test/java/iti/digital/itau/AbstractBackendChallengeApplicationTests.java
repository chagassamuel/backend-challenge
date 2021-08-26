package iti.digital.itau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import iti.digital.itau.dto.PasswordDTO;
import iti.digital.itau.model.Password;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractBackendChallengeApplicationTests {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper mapper;

	protected Password buildPassword(String password) {
		return Password.builder().password(password).build();
	}

	protected PasswordDTO buildPasswordDTO(String password) {
		return PasswordDTO.builder().password(password).build();
	}

}
