package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleRepeatedChars;

public class RuleRepeatedCharsTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("AaBbCcDd")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("Aa1B2b3CcDd4")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("abcd1234ABCD")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("!abABCc")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("AaBbCcDd")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("Aa1B2b3CcDd4")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("abcd1234ABCD")));
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("!abABCc")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("a1234a56789")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("AAAAAAAAA")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("AbTp9!foA")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("1239456789A")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("a1234a56789")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("AAAAAAAAA")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("AbTp9!foA")));
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValidTwo(buildPassword("1239456789A")));
	}

}
