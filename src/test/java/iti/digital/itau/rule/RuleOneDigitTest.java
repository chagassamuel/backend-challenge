package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleOneDigit;

public class RuleOneDigitTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("1abcdefgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("abcd1efgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("abcdefgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("1abcd1efgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("1abcdefgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("abcd1efgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("1abcd1efgh1")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("1abcdefgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("abcd1efgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("abcdefgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("1abcd1efgh")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("1abcdefgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("abcd1efgh1")));
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("1abcd1efgh1")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("abcdefgh")));
		assertFalse(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("AAAbbbCc")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("abcdefgh")));
		assertFalse(new RuleOneDigit(new RuleOkPassword()).isValidTwo(buildPassword("AAAbbbCc")));
	}

}
