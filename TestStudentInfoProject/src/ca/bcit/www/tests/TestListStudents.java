package ca.bcit.www.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ca.bcit.www.project.Database;
import ca.bcit.www.project.StudentObject;

/**
 * <p> TestListStudents class is for testing the ListStudents API.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class TestListStudents {
	
	/**
	 * <p> Test case: get student list, when the database is empty. </p>
	 * 
	 * <p> Expect result: empty collection (size == 0)</p>
	 */
	@Test
	public void TestListStudentsWithNoData(){
		String msg = "Fail to get an empty collection of StudentObjects";
		Database.clear();
		assertNotNull(msg, Database.ListStudents());
		assertEquals(msg, 0 , Database.ListStudents().size());
	}

	/**
	 * <p> Test case: get student list, when the database has data. </p>
	 * 
	 * <p> Expect result: collection of StudentObject</p>
	 */
	@Test
	public void TestListStudentsWithData(){

		TestFramework.TestInitializationTest();
		String msg = "Fail to get a collection of StudentObjects";
		ArrayList<StudentObject> data = Database.ListStudents();
		assertNotNull(msg, data);
		assertEquals(msg + "Wrong size", 3 , data.size());
		for(StudentObject someOne:data){
			assertEquals(msg + " wrong first name ", 
					     TestFramework.studentNames[someOne.getID()][0],
					     someOne.getFirstName());
			assertEquals(msg + " wrong last name ", 
					     TestFramework.studentNames[someOne.getID()][1], 
					     someOne.getLastName());
		}
	}

}
