package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleWhitespace;

public class RuleWhitespaceTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("1abcdefgh2")));
		assertTrue(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("3AAAbbbCc4")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword("1abcdefgh2")));
		assertTrue(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword("3AAAbbbCc4")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword(" 123456789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("1234 56789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("123456789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword(" 1234 56789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword(" 123456789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("1234 56789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword(" 1234 56789 ")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword(" 123456789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword("1234 56789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword("123456789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword(" 1234 56789")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword(" 123456789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword("1234 56789 ")));
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValidTwo(buildPassword(" 1234 56789 ")));
	}

}
