package iti.digital.itau.rule.password;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import iti.digital.itau.model.Password;

public class RuleRepeatedChars extends RulePassword {

	public RuleRepeatedChars(RulePassword next) {
		super(next);
	}

	@Override
	public boolean isValid(Password password) {
		List<String> lettersList = Arrays.asList(password.getPassword().split(""));
		HashSet<String> lettersSet = new HashSet<String>(lettersList);
		if (lettersList.size() == lettersSet.size()) {
			return next.isValid(password);
		}

		return false;
	}

	@Override
	public boolean isValidTwo(Password password) {
		for (int i = 0; i < password.getPassword().length(); i++) {
			for (int j = i + 1; j < password.getPassword().length(); j++) {
				if (password.getPassword().charAt(i) == password.getPassword().charAt(j)) {
					return false;
				}
			}
		}

		return next.isValidTwo(password);
	}

}
