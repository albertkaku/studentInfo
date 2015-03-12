package ca.bcit.www.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.bcit.www.project.Database;
import ca.bcit.www.project.StudentObject;

/**
 * <p> TestGetStudent class is for testing the GetStudent API.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class TestGetStudent {

	/**
	 * <p> Test case: Before initialization, fail to get student.</p>
	 */
	@BeforeClass
	static public void TestFailGetStudentBeforeInitialzation(){
		int index = 0;
		String msg = "Invalid return value "
				+ "with GetStudent before initialization";
		Database.clear();
		assertNull(msg, Database.GetStudent(index));
		assertNull(msg, Database.GetStudent(++index));
		TestFramework.TestInitializationTest();
	}

    /**
     * <p> Test case: Successfully get the student 
     *   having the smallest valid id.</p>
     */
	@Test
	public void TestGetStudentSuccessBySmallestValidID(){
		int id = 1;
		String msg = "Fail to get correct student info by valid id.";
		StudentObject s = Database.GetStudent(id);
		assertEquals(msg, id, s.getID());
		assertEquals(msg, "aaa", s.getFirstName());
		assertEquals(msg, "xxx", s.getLastName());
		assertEquals(msg, '-', s.getGrade());
	}

    /**
     * <p> Test case: Successfully get the student 
     *   having the biggest valid id.</p>
     */
	@Test
	public void TestGetStudentSuccessByBiggestValidID(){
		int id = Database.size();
		String msg = "Fail to get correct student info by valid id.";
		StudentObject s = Database.GetStudent(id);
		assertEquals(msg, id, s.getID());
		assertEquals(msg, "ccc", s.getFirstName());
		assertEquals(msg, "zzz", s.getLastName());
		assertEquals(msg, '-', s.getGrade());
	}

    /**
     * <p> Test case: Fail to get student by non-exist id.</p>
     */
	@Test
	public void TestGetStudentFailByInvalidID(){
		int id = 0;
		String msg = "Fail to refuse the get by invalid id.";
		assertNull(msg, Database.GetStudent(id));
	}
    /**
     * <p> Test case: Fail to get student by too big id.</p>
     */
	@Test
	public void TestGetStudentFailByTooBigID(){
		int id = Database.size() + 1;
		String msg = "Fail to refuse the get by too big id.";
		assertNull(msg, Database.GetStudent(id));
	}
}
