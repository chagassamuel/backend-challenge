package iti.digital.itau.rule.password;

import org.springframework.util.StringUtils;

import iti.digital.itau.model.Password;

public class RuleWhitespace extends RulePassword {

	public RuleWhitespace(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		if (!StringUtils.containsWhitespace(password.getPassword())) {
			return next.isValid(password);
		}

		return false;
	}

	@Override
	public boolean isValidTwo(Password password) {
		if (password.getPassword().replaceFirst("\\s", "").length() != password.getPassword().length()) {
			return false;
		}

		return next.isValidTwo(password);
	}

}
