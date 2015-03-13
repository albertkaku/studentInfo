package ca.bcit.www.project;

import java.util.ArrayList;

/**
 * <p> Database class is used to holding students information 
 *    and to offer the services(APIs). </p>
 * 
 * @author  Albert GUO
 * @version 1.2
 *
 */
public class Database {
	/** <p> Arraylist of StudentObject to store students' information. </p>*/

    static private ArrayList<StudentObject> system = 
    		new ArrayList<StudentObject>();

    /** <p> Clear previous database. </p> */
    static public void clear(){
    	system.clear();
    }

    /**
     * <p> AddStudent method is for adding new student to the database. </p>
     * 
     * @param firstName for student to be added
     * @param lastName  for student to be added
     * @return integer  1 ~ n: student ID
     *                  0    : student not found or invalid name
     */
    public static int AddStudent(String firstName, String lastName){
    	if(0 == firstName.length() || 0 == lastName.length())
    		return 0;
        if(0 != system.size())
            for(StudentObject someOne:system)
                if(0 == someOne.getFirstName().compareTo(firstName) &&
                   0 == someOne.getLastName().compareTo(lastName))
                	return 0;
        int newID = system.size() + 1;
        system.add(new StudentObject(newID, firstName, lastName, '-'));
        return newID;
    }

    /**
     * <p> GetStudent method is to find a Student by id. </p>
     * 
     * @param id integer student id
     * @return StudentObject : if found
     *         null          : if not found
     */
    public static StudentObject GetStudent(int id){
    	if(0 == system.size() || id > system.size())
    		return null;

        int low = 0;
        int high = system.size() - 1;
        int middle;
        int currentID;
        StudentObject result = null;
        StudentObject someOne = null;

        while(low <= high){
        	middle = (low + high) / 2;
        	someOne = system.get(middle);
        	currentID = someOne.getID();
        	if(currentID == id) {
                result = new StudentObject(id, someOne.getFirstName(), 
                                               someOne.getLastName(),
                                               someOne.getGrade());
        	    break;
        	}
        	else if(currentID < id)
        	    low = middle + 1;
        	else // currentID > id
        	    high = middle - 1;
        }
        return result;
    }

    /**
     * <p> UpdateStudent method is to update one student grade and/or name.</p>
     * 
     * @param s new information of that student
     * @return boolean true: if found and updated (update name and/or grade)
     *                 false: not found or invalid id(too big or not match)
     */
    public static boolean UpdateStudent(StudentObject s){
    	int systemSize = system.size();

        if(0 == systemSize || s.getID() > systemSize) 
        	return false;

        if(null == s.getFirstName() || null == s.getLastName())
        	return false;
        
        if("" == s.getFirstName() || "" == s.getLastName())
        	return false;

        for(StudentObject someOne:system){
        	if(s.getID() == someOne.getID()){
        		if((0 == someOne.getFirstName().compareTo(s.getFirstName())) ||
                   (0 == someOne.getLastName().compareTo(s.getLastName()))){
        	        system.remove(system.indexOf(someOne));
        	        system.add(s);
        	        return true;
        		}	
        	}
        }
        return false;

    }

    /**
     * <p> DropStudent method is to remove one student. </p>
     * 
     * @param id integer student id
     * @return boolean true: found and removed
     *                 false: not found or invalid id value
     */
    public static boolean DropStudent(int id){
        if(0 == system.size()) return false;
        for(StudentObject someOne:system)
            if(id == someOne.getID()){
            	system.remove(system.indexOf(someOne));
            	return true;
            }
        return false;
    }

    /**
     * <p> ListStudents method returns all the student info in the system.</p>
     * 
     * @return ArrayList<StudentObject> all students' info
     */
    public static ArrayList<StudentObject> ListStudents(){
    	return system;
    }

    /**
     * <p> ListStudents method returns all the student info in the system.</p>
     * 
     * @return ArrayList<StudentObject> all students' info
     */
    public static int size(){
    	return system.size() ;
    }

}
