package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;

public class RuleSpecialChars extends RulePassword {

	private static final String SPECIAL_CHARS = "!@#$%^&*()+-";

	public RuleSpecialChars(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		for (String specialChar : SPECIAL_CHARS.split("")) {
			if (password.getPassword().contains(specialChar)) {
				return next.isValid(password);
			}
		}

		return false;

	}

	@Override
	public boolean isValidTwo(Password password) {
		if (!password.getPassword().matches("^(?=.*[" + SPECIAL_CHARS + "]).+$")) {
			return false;
		}

		return next.isValidTwo(password);
	}

}
