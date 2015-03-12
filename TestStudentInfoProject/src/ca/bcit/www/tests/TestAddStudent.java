package ca.bcit.www.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.bcit.www.project.Database;

/**
 * <p> TestAddStudent class is for testing the AddStudent API.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class TestAddStudent {

	/** <p> Array of String is used to store valid first names for test.</p> */
    static String[] firstNames = {"Aaron", "Aiden", "Andrew"};

	/** <p> Array of String is used to store valid last names for test.</p> */
    static String[] lastNames = {"Smith", "Meridian", "Trimble"};

    /** <p> count is to keep how many students in the database.</p>*/
    static int count = 0;

    /**
     * <p> confirm the number of students before each test case. </p>
     * 
     */
    @Before
    public void TestBeforeEachTest(){
		String msg = "Before running AddStudent, database size is wrong.";
		assertEquals(msg, count, Database.size());
    }

    /**
     * <p> confirm the number of students after each test case. </p>
     * 
     */
    @After
    public void TestAfterEachTest(){
		String msg = "After running AddStudent, database size is wrong";
		assertEquals(msg, count, Database.size());
    }

    /**
     * <p> Test case: successfully add first student into the system.</p>
     * 
     */
	@Test
	public void TestSuccessAddFirstStudent() {
		int index = 0;
		String msg = "Fail to add the first student";
		assertEquals(msg, ++count, 
				Database.AddStudent(firstNames[index],lastNames[index]));
	}

    /**
     * <p> Test case: successfully add a student 
     *   with same first name and different last name into the system.</p>
     * 
     */
	@Test
	public void TestSuccessAddStudentWithSameFirstName() {
		int index = 0;
		String msg = "Fail to add a student with same first name ";
		assertEquals(msg, ++count, 
				Database.AddStudent(firstNames[index],lastNames[++index]));
	}

    /**
     * <p> Test case: successfully add a student 
     *   with same last name and different first name into the system.</p>
     */
	@Test
	public void TestSuccessAddStudentWithSameLastName() {
		int index = 1;
		String msg = "Fail to add a student with same last name ";
		assertEquals(msg, ++count, 
				Database.AddStudent(firstNames[index],lastNames[--index]));
	}

    /**
     * <p> Test case: fail to add a student 
     *   with same last name and same first name into the system.</p>
     */
	@Test
	public void TestFailAddStudentWithSameFirstNameSameLastName() {
		int index = 0;
		String msg = "Fail to prevent adding a student with same name ";
		assertEquals(msg, 0, 
				Database.AddStudent(firstNames[index],lastNames[index]));
	}

    /**
     * <p> Test case: fail to add a student with no first name.</p>
     */
	@Test
	public void TestFailAddStudentWithNoFirstName() {
		int index = 0;
		String msg = "Seccuss to add a student with no first name ";
		assertEquals(msg, 0, 
				Database.AddStudent("",lastNames[index]));
	}

    /**
     * <p> Test case: fail to add a student with no last name.</p>
     */
	@Test
	public void TestFailAddStudentWithNoLastName() {
		int index = 0;
		String msg = "Seccuss to add a student with no last name ";
		assertEquals(msg, 0, 
				Database.AddStudent(firstNames[index],""));
	}

    /**
     * <p> Test case: fail to add a student with no  name.</p>
     */
	@Test
	public void TestFailAddStudentWithNoName() {
		String msg = "Seccuss to add a student with no name ";
		assertEquals(msg, 0, Database.AddStudent("",""));
	}
}
