package ca.bcit.www.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.bcit.www.project.Database;
import ca.bcit.www.project.StudentObject;

/**
 * <p> TestUpdateStudent class is for testing UpdateStudent API.</p>
 * 
 * @author  Albert GUO
 * @version 1.0
 */
public class TestUpdateStudent {
    /** <p> count is to keep how many students in the database.</p>*/
    static int count = 0;    

    /**
     * <p>BeforeClass: Initialize the database before tests begin.</p>
     * 
     */
	@BeforeClass
	static public void Initialization() {
		count = TestFramework.TestInitializationTest();
	}

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
     * <p> After each test case:
     *     confirm the number of students after each test case. </p>
     * 
     */
    @After
    public void TestAfterEachTest(){
		String msg = "After running AddStudent, database size is wrong";
		assertEquals(msg, count, Database.size());
    }
	/**
	 * <p> Test Case: Successfully update someone's grade.</p>
	 * <p>  id, first name and last name 
	 *    all match to the input PersonObject. 	
	 *    Expect: update success (return value: true) </p>
	 */
	@Test
	public void TestSuccessToUpdateStudentWithIDAndNameMatched() {
		int index = 1;
		String msg = "Fail to update the student with id and name matched";
		StudentObject s = new StudentObject(index,
				                            TestFramework.studentNames[index][0],
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertTrue(msg, Database.UpdateStudent(s));		
	}

	/**
	 * <p> Test Case: Success to update someone's grade with last name updating.</p>
	 * <p>  id and first name of input match to the database,
	 *      but last name does not match. 
	 *      Expect: update success (return value: true) </p>
	 */
	@Test
	public void TestSuccessToUpdateStudentWithLastNameUpdating() {
		int index = 1;
		String msg = "Fail to update the student with last name updating";
		StudentObject s = new StudentObject(index,
				                            TestFramework.studentNames[index][0],
				                            TestFramework.studentNames[index][1].replace('x', 'q'),
				                            'A');
		assertTrue(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Success to update someone's grade with first name updating.</p>
	 * <p>  id and last name of input match to the database,
	 *      but first name does not match.
	 *      Expect: update success (return value: true) </p>
	 */
	@Test
	public void TestSuccessToUpdateStudentWithFirstNameUpdating() {
		int index = 2;
		String msg = "Fail to update the student with first name updating";
		StudentObject s = new StudentObject(index,
				                            TestFramework.studentNames[index][0].replace('b', 'd'),
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertTrue(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Fail to update someone's info with only id match.</p>
	 * <p>  id of input student matches to the database,
	 *      but first name and last name do not match. 
	 *      Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentWithOnlyIDMatch() {
		int index = 3;
		String msg = "Fail to prevent updating with only id match";
		StudentObject s = new StudentObject(index--,
				                            TestFramework.studentNames[index][0],
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Fail to update someone's info not in the system.</p>
	 * <p> Neither of id, first name or last name 
	 *      of input matches to database. 
	 *      Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentNotInSystem() {
		int index = 4;
		String msg = "Fail to prevent updating of student not in the system";
		StudentObject s = new StudentObject(index,
				                            TestFramework.studentNames[index][0],
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Fail to update with invalid id.</p>
	 * <p> input StudentObject has 0 as id
	 *     Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentWithInvalidID() {
		int index = 0;
		String msg = "Fail to prevent updating with invalid id";
		StudentObject s = new StudentObject(index++,
				                            TestFramework.studentNames[index][0],
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}


	/**
	 * <p> Test Case: Fail to update info with no first name input.</p>
	 * <p> Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentWithNoFirstName() {
		int index = 3;
		String msg = "Fail to prevent updating of student with no first name";
		StudentObject s = new StudentObject(index,
				                            "",
				                            TestFramework.studentNames[index][1],
				                            'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Fail to update info with no last name input.</p>
	 * <p> Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentWithNoLastName() {
		int index = 3;
		String msg = "Fail to prevent updating of student with no last name";
		StudentObject s = new StudentObject(index,
				                            TestFramework.studentNames[index][0],
				                            "",
				                            'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}

	/**
	 * <p> Test Case: Fail to update with no name input.</p>
	 * <p> Expect: update fail (return value: false)</p>
	 */
	@Test
	public void TestFailToUpdateStudentWithoutInput() {
		String msg = "Fail to prevent updating of student with no info";
		StudentObject s = new StudentObject(1,null,null,'A');
		assertFalse(msg, Database.UpdateStudent(s));
	}
}
