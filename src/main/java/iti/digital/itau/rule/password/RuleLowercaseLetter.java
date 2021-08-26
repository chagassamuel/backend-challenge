package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;

public class RuleLowercaseLetter extends RulePassword {

	public RuleLowercaseLetter(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		for (int i = 0; i < password.getPassword().length(); i++) {
			char current = password.getPassword().charAt(i);
			if (current >= 'a' && current <= 'z') {
				return next.isValid(password);
			}
		}

		return false;
	}

	@Override
	public boolean isValidTwo(Password password) {
		if (!password.getPassword().matches("^(?=.*[a-z]).+$")) {
			return false;
		}

		return next.isValidTwo(password);
	}

}
