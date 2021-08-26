package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleSpecialChars;

public class RuleSpecialCharsTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("!123456789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("1234@56789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("123456789#")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("$1234%56789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("^123456789&")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("1234*56789(")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword(")1234-56789+")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("!123456789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("1234@56789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("123456789#")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("$1234%56789")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("^123456789&")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("1234*56789(")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword(")1234-56789+")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("123456789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("a123456789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("1234a56789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("123456789a")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("123456789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("a123456789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("1234a56789")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValidTwo(buildPassword("123456789a")));
	}

}
