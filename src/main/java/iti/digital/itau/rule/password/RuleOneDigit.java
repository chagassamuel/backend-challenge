package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;

public class RuleOneDigit extends RulePassword {

	public RuleOneDigit(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		for (int i = 0; i < password.getPassword().length(); i++) {
			char current = password.getPassword().charAt(i);
			if (current >= '0' && current <= '9') {
				return next.isValid(password);
			}
		}

		return false;
	}

	@Override
	public boolean isValidTwo(Password password) {
		if (!password.getPassword().matches("^(?=.*[0-9]).+$")) {
			return false;
		}

		return next.isValidTwo(password);
	}

}
