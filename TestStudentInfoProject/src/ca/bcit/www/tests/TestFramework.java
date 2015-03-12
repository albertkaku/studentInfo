package ca.bcit.www.tests;

import static org.junit.Assert.*;

import ca.bcit.www.project.Database;
/**
 * <p> TestInitialization class is for initialization for APIs testing.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class TestFramework {

    /** <p> two-dimension array of String for test data (Student names).
     *     index 1 - 3 will be put into database as initial value.</p>*/
    static String[][] studentNames = {{"",""},
    		{"aaa","xxx"},{"bbb","yyy"},{"ccc","zzz"},{"eee","uuu"}};
    
    /**
     * <p> Initialize the database.</p>
     * 
     */

	static public int TestInitializationTest() {
    	Database.clear();
    	int count = 0;

		String msg = "Fail to initialize on step #";
		assertEquals(msg + "1", count, Database.size());
		assertEquals(msg + "2", ++count, 
				Database.AddStudent(studentNames[count][0],studentNames[count][1]));
		assertEquals(msg + "3", ++count,
				Database.AddStudent(studentNames[count][0],studentNames[count][1]));
		assertEquals(msg + "4", ++count,
				Database.AddStudent(studentNames[count][0],studentNames[count][1]));
		assertEquals(msg + "5", count, Database.size());
		return count;
	}
}
