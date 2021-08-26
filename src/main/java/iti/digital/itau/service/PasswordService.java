package iti.digital.itau.service;

import iti.digital.itau.dto.PasswordDTO;

public interface PasswordService {

	public boolean isValid(PasswordDTO passwordDTO);

	public boolean isValidTwo(PasswordDTO passwordDTO);

}
