package ca.bcit.www.tests;

import static org.junit.Assert.*;

import ca.bcit.www.project.StudentInfo;

import org.junit.Test;

/**
 * <p> TeastLogin class is for testing the Login API.</p>
 * 
 * <p> Assume we have three valid users:</br>
 *      (1)user name: admin            password: ad123</br>
 *      (2)user name: instructorTom    password: instructor123</br>
 *      (3)user name: instructorJerry  password: instructor67890</br>
 *    Passwords are case sensitive, but user names are not.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 */
public class TestLogin{
    /** <p> Array of String is for storing valid user names for test.</p> */
    String[] validUserNames = {"admin","instructorTom","instructorJerry"};

    /** <p> Array of String is for storing valid passwords for test.</p> */
	String[] validPasswords = {"ad123","instructor123","instructor67890"};

    /**
     * <p> Test case: successfully login scenario with user named admin.</p>
     * 
     */
	@Test
	public void TestLoginSuccessWithValidUserNameAndMatchedPassword() {
		String msg = "Fail to prevent login with valid username and password";
		String validUserName = validUserNames[0];
		String validPassword = validPasswords[0];
		assertTrue(msg, StudentInfo.Login(validUserName, validPassword));
	}

    /**
     * <p> Test case: Success to prevent login with wrong password. </p>
     */
	@Test
	public void TestLoginFailWithValidUserNameAndWrongPassword() {
		String msg = "Fail to prevent login with invalid password";
		String validUserName = validUserNames[0];
		String wrongPassword = validPasswords[0].substring(1);
		assertFalse(msg, StudentInfo.Login(validUserName, wrongPassword));
	}

    /**
     * <p> Test case: Success to prevent login with invalid user name. </p>
     */
	@Test
	public void TestLoginFailWithInvalidUserName() {
		String msg = "Fail to prevent login with invalid user name ";
		String invalidUserName = validUserNames[0].substring(1);
		String anyPassword = validPasswords[0];
		assertFalse(msg, StudentInfo.Login(invalidUserName, anyPassword));
	}


    /**
     * <p> Test case: Success to prevent login with none user name. </p>
     */
	@Test
	public void TestLoginFailWithNoUserName() {
		String msg = "Fail to prevent login with no user name input";
		String noneUserName = "";
		String anyPassword = validPasswords[0];
		assertFalse(msg, StudentInfo.Login(noneUserName, anyPassword));
	}

    /**
     * <p> Test case: Success to prevent login with none password. </p>
     */
	@Test
	public void TestLoginFailWithValidUserNameAndNonePassword() {
		String msg = "Fail to prevent login with no password input";
		String validUserName = validUserNames[0];
		String nonePassword = "";
		assertFalse(msg, StudentInfo.Login(validUserName, nonePassword));
	}

    /**
     * <p> Test case: Success to prevent login
     *    with no user name nor password. </p>
     */
	@Test
	public void TestLoginFailWithNoUserNameAndNonePassword() {
		String msg = "Fail to prevent login with no user nor password input";
		String noneUserName = "";
		String nonePassword = "";
		assertFalse(msg, StudentInfo.Login(noneUserName, nonePassword));
	}
}
