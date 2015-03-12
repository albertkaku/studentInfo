package ca.bcit.www.project;

/**
 * <p> StudentObject class is to hold one person info.</p>
 * 
 * @author  Albert GUO
 * @version 1.0
 */
public class StudentObject{
	/** private integer student id. */
    private int id;
	/** private String student first name. */
    private String firstName = "";
	/** private String student last name. */
    private String lastName = "";
	/** private char student grade. */
    private char grade;

    /**
     * <p> constructor of StudentObject. </p>
     * 
     * @param id         student id
     * @param firstName  student firstname
     * @param lastName   student lastname 
     * @param grade      student grade
     */
    public StudentObject(int id, String new_firstName,
    		String new_lastName, char grade){
    	this.id = id;
    	this.firstName = new_firstName;
    	this.lastName  = new_lastName;
    	this.grade = grade;
    }

    /**
     * <p> accessor of id. </p>
     * 
     * @return int student id
     */
    public int getID(){
    	return id;
    }

    /**
     * <p> accessor of last name. </p>
     * 
     * @return String student lastname
     */
    public String getLastName(){
    	return lastName;
    }

    /**
     * <p> accessor of first name. </p>
     * 
     * @return String student first name
     */
    public String getFirstName(){
    	return firstName;
    }

    /**
     * <p> accessor of grade. </p>
     * 
     * @return char student grade
     */
    public char getGrade(){
    	return grade;
    }

    /**
     * <p> mutator of grade. </p>
     * 
     * @param grade char student grade
     */
    public void setGrade(char grade){
    	this.grade = grade;
    }

    /**
     * <p> toString method returns one student info. </p>
     * 
     * @return String student info
     */
    public String toString(){
    	return "id: " + id + " name: " + firstName + " " + lastName 
    			+ " grade: " + grade;
    }
}
