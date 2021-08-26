package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;

public class RuleSizeLTNine extends RulePassword {

	public RuleSizeLTNine(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		if (password.getPassword().length() >= 9) {
			return next.isValid(password);
		}

		return false;
	}

	@Override
	public boolean isValidTwo(Password password) {
		if (!password.getPassword().matches(".{9,}")) {
			return false;
		}

		return next.isValidTwo(password);
	}

}
