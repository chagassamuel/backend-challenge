package iti.digital.itau.rule.password;

import iti.digital.itau.model.Password;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RulePassword {

	protected RulePassword next;

	public abstract boolean isValid(Password password);

	public abstract boolean isValidTwo(Password password);

}
