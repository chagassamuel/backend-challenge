package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;

public class RuleOkPassword extends RulePassword {

	public RuleOkPassword() {
		super(null);
	}

	@Override
	public boolean isValid(Password password) {
		return true;
	}

	@Override
	public boolean isValidTwo(Password password) {
		return true;
	}

}
