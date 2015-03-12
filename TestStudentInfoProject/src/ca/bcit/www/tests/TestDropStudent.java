package ca.bcit.www.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.bcit.www.project.*;

/**
 * <p> TestAddStudent class is for testing the AddStudent API.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class TestDropStudent {
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
	 * <p> Test case: fail to drop someone with invalid id (too big). </p>
	 * 
	 * <p> Expect result: fail to drop (return value: false)</p>
	 */
	@Test
	public void TestFailToDropStudentWithInvalidID(){
		String msg = "Fail to prevent dropping student by invalid id";
		assertFalse(msg + "return value wrong", Database.DropStudent(count + 10));
		assertEquals(msg + "drop NG", count, Database.size());
	}
	
	/**
	 * <p> Test case: fail to drop someone with invalid id ( id == 0). </p>
	 * 
	 * <p> Expect result: fail to drop (return value: false)</p>
	 */
	@Test
	public void TestFailToDropStudentWithZeroID(){
		String msg = "Fail to prevent dropping student by invalid id(0)";
		assertFalse(msg + "return value wrong", Database.DropStudent(0));
		assertEquals(msg + "drop NG", count, Database.size());
	}

	/**
	 * <p> Test case: success to drop all. </p>
	 * 
	 * <p> Expect result: success to drop multiple times 
	 *                    (return value: true)</p>
	 */
	@Test
	public void TestSuccessToDropAllStudents(){
		String msg = "Fail to prevent dropping student by invalid id";
		while(count > 0){
		    assertTrue(msg + "return value", Database.DropStudent(count--));
		}
	}
	
	/**
	 * <p> Test case: fail to drop with no one in database. </p>
	 * 
	 * <p> Expect result: fail to drop (return value: false)</p>
	 */
	@Test
	public void TestFailToDropStudentWithNoOneInDatabase(){
		TestSuccessToDropAllStudents();
		String msg = "Fail to prevent dropping student with empty database ";
		assertFalse(msg + "return value wrong", Database.DropStudent(count));
		assertEquals(msg + "drop NG", count, Database.size());
	}
}
