package iti.digital.itau.service.impl;

import org.springframework.stereotype.Service;

import iti.digital.itau.dto.PasswordDTO;
import iti.digital.itau.model.Password;
import iti.digital.itau.rule.password.RuleLowercaseLetter;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleOneDigit;
import iti.digital.itau.rule.password.RulePassword;
import iti.digital.itau.rule.password.RuleRepeatedChars;
import iti.digital.itau.rule.password.RuleSizeLTNine;
import iti.digital.itau.rule.password.RuleSpecialChars;
import iti.digital.itau.rule.password.RuleUppercaseLetter;
import iti.digital.itau.rule.password.RuleWhitespace;
import iti.digital.itau.service.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Override
	public boolean isValid(PasswordDTO passwordDTO) {
		Password password = Password.builder().password(passwordDTO.getPassword()).build();

		RulePassword rules = new RuleWhitespace(new RuleSizeLTNine(new RuleOneDigit(new RuleLowercaseLetter(
				new RuleUppercaseLetter(new RuleSpecialChars(new RuleRepeatedChars(new RuleOkPassword())))))));
		return rules.isValid(password);
	}

	@Override
	public boolean isValidTwo(PasswordDTO passwordDTO) {
		Password password = Password.builder().password(passwordDTO.getPassword()).build();

		RulePassword rules = new RuleWhitespace(new RuleSizeLTNine(new RuleOneDigit(new RuleLowercaseLetter(
				new RuleUppercaseLetter(new RuleSpecialChars(new RuleRepeatedChars(new RuleOkPassword())))))));
		return rules.isValidTwo(password);
	}

}
