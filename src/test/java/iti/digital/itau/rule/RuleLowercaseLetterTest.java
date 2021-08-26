package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleLowercaseLetter;
import iti.digital.itau.rule.password.RuleOkPassword;

public class RuleLowercaseLetterTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("a123456789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234a56789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("a1234a56789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("a123456789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234a56789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("a1234a56789a")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("a123456789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234a56789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("a1234a56789")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("a123456789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234a56789a")));
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("a1234a56789a")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("A123456789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("1234A56789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("123456789A")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("A123456789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("1234A56789")));
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValidTwo(buildPassword("123456789A")));
	}

}
