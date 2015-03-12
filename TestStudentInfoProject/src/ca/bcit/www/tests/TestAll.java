package ca.bcit.www.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p> SuiteClasses is for test all of test cases. </p> 
 * @author  Albert GUO
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({TestLogin.class,
               TestDropStudent.class,
	           TestAddStudent.class,
	           TestGetStudent.class,
	           TestUpdateStudent.class,
	           TestListStudents.class})
public class TestAll{

}
