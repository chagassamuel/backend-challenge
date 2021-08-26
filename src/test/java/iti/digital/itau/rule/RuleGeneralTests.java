package iti.digital.itau.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import iti.digital.itau.AbstractBackendChallengeApplicationTests;
import iti.digital.itau.rule.password.RuleLowercaseLetter;
import iti.digital.itau.rule.password.RuleOkPassword;
import iti.digital.itau.rule.password.RuleOneDigit;
import iti.digital.itau.rule.password.RuleRepeatedChars;
import iti.digital.itau.rule.password.RuleSizeLTNine;
import iti.digital.itau.rule.password.RuleSpecialChars;
import iti.digital.itau.rule.password.RuleUppercaseLetter;
import iti.digital.itau.rule.password.RuleWhitespace;
import iti.digital.itau.service.PasswordService;

public class RuleGeneralTests extends AbstractBackendChallengeApplicationTests {

	@Autowired
	private PasswordService passwordService;

	@Test
	void testIsValid1() {
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("Abcdefg1*")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("Ab[cdefg1*")));
		assertTrue(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("Ab[cdefg$@#")));
	}

	@Test
	void testIsInValid1() {
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword(" ")));
		assertFalse(new RuleSpecialChars(new RuleOkPassword()).isValid(buildPassword("asdaDS ")));
	}

	@Test
	void testIsValid2() {
		assertTrue(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("Abcdefg1*")));
	}

	@Test
	void testIsInValid2() {
		assertFalse(new RuleRepeatedChars(new RuleOkPassword()).isValid(buildPassword("Abcdefg13ff")));
	}

	@Test
	void testIsValid_Valids3() {
		assertTrue(passwordService.isValid(buildPasswordDTO("AbTp9!fok")));

		assertTrue(passwordService.isValid(buildPasswordDTO("Abcdefg1+")));
		assertTrue(passwordService.isValid(buildPasswordDTO("Abcdefg1!")));
		assertTrue(passwordService.isValid(buildPasswordDTO("Abcdefg1*")));
		assertTrue(passwordService.isValid(buildPasswordDTO("Abcdefg1-")));
		assertTrue(passwordService.isValid(buildPasswordDTO("Abcdefg1^")));
		assertTrue(passwordService.isValid(buildPasswordDTO("024156Rn*")));
		assertTrue(passwordService.isValid(buildPasswordDTO("0-(@24156Rn*")));
	}

	@Test
	void testIsValid_Invalids3() {
		assertFalse(passwordService.isValid(buildPasswordDTO("")));
		assertFalse(passwordService.isValid(buildPasswordDTO("aa")));
		assertFalse(passwordService.isValid(buildPasswordDTO("ab")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AAAbbbCc")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AbTp9!foo")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AbTp9!foA")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AbTp9 fok")));

		assertFalse(passwordService.isValid(buildPasswordDTO(" ")));
		assertFalse(passwordService.isValid(buildPasswordDTO("Abcdfg1+"))); // 8chars
		assertFalse(passwordService.isValid(buildPasswordDTO("Abcefg1."))); // 8chars
		assertFalse(passwordService.isValid(buildPasswordDTO("abc efg1-"))); // 8chars
		assertFalse(passwordService.isValid(buildPasswordDTO("0241564RUn*")));
		assertFalse(passwordService.isValid(buildPasswordDTO("0241564RUn* ")));
		assertFalse(passwordService.isValid(buildPasswordDTO(" 0241564RUn* ")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AbTp9!fok ")));
		assertFalse(passwordService.isValid(buildPasswordDTO(" AbTp9!fok ")));
		assertFalse(passwordService.isValid(buildPasswordDTO("AbTp9! fok")));
	}

	@Test
	void testIsValid4() {
		assertTrue(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("AAAbbbCc")));
	}

	@Test
	void testIsInValid4() {
		assertFalse(new RuleWhitespace(new RuleOkPassword()).isValid(buildPassword("AAAOO UE")));
	}

	@Test
	void testIsValid5() {
		assertTrue(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("AAAbbbCc")));
	}

	@Test
	void testIsInValid5() {
		assertFalse(new RuleUppercaseLetter(new RuleOkPassword()).isValid(buildPassword("aaabbbcccooo")));
	}

	@Test
	void testIsValid6() {
		assertTrue(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("AAAbbbCc")));
	}

	@Test
	void testIsInValid6() {
		assertFalse(new RuleLowercaseLetter(new RuleOkPassword()).isValid(buildPassword("AAAOOUUEERR")));
	}

	@Test
	void testIsValid7() {
		assertTrue(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("AAAbbbCcds3")));
	}

	@Test
	void testIsInValid7() {
		assertFalse(new RuleSizeLTNine(new RuleOkPassword()).isValid(buildPassword("AAAOOUUE")));
	}

	@Test
	void testIsValid8() {
		assertTrue(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("AAAb8bbCc")));
	}

	@Test
	void testIsInValid8() {
		assertFalse(new RuleOneDigit(new RuleOkPassword()).isValid(buildPassword("AAAOOUUE")));
	}

}
