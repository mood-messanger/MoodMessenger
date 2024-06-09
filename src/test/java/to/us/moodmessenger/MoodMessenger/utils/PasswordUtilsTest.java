package to.us.moodmessenger.MoodMessenger.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {
    PasswordUtils passwordUtils = new PasswordUtils();
    @Test
    void encryptPassword() {
        String originalPassword = "password";
        String originalPasswordHash = passwordUtils.encryptPassword(originalPassword);
        System.out.println("originalPasswordHash\t:\t"+originalPasswordHash);
        String testPassword = "password1";
        System.out.println("testPassword\t:\t"+passwordUtils.encryptPassword(testPassword));
        assertFalse(passwordUtils.checkPassword(testPassword, originalPasswordHash));
        String testPassword2 = "password2";
        System.out.println("testPassword2\t:\t"+passwordUtils.encryptPassword(testPassword2));
        assertFalse(passwordUtils.checkPassword(testPassword2, originalPasswordHash));
        String testPassword3 = "password3";
        System.out.println("testPassword3\t:\t"+passwordUtils.encryptPassword(testPassword3));
        assertFalse(passwordUtils.checkPassword(testPassword3, originalPasswordHash));
        String testPassword4 = "password";
        System.out.println("testPassword4\t:\t"+passwordUtils.encryptPassword(testPassword4));
        assertTrue(passwordUtils.checkPassword(testPassword4, originalPasswordHash));
    }

}