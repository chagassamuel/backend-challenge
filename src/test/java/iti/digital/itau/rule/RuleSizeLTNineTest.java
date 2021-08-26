package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleSizeLTNine;

public class RuleSizeLTNineTest extends AbstractBackendChallengeApplicationTests {

	@Test
	void testValidatePasswordOK() {
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("123456789")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("0123456789")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("abcdefghi")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("abcde12345")));
	}

	@Test
	void testValidatePasswordTwoOK() {
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("123456789")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("0123456789")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("abcdefghi")));
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("abcde12345")));
	}

	@Test
	void testValidatePasswordNOK() {
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("12345678")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("abcdefgh")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("1234abcd")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("abc")));
	}

	@Test
	void testValidatePasswordTwoNOK() {
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("12345678")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("abcdefgh")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("1234abcd")));
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValidTwo(buildPassword("abc")));
	}

}
