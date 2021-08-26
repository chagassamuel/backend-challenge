package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleUppercaseLetter;

public class RuleUppercaseLetterTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("A123456789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234A56789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("A1234A56789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("A123456789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234A56789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("A1234A56789A")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("A123456789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234A56789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("A1234A56789")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("A123456789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234A56789A")));
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("A1234A56789A")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("a123456789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234a56789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789a")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("a123456789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234a56789")));
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789a")));
	}

}
