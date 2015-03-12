package ca.bcit.www.project;

/**
 * <p> StudentInfo class is used for login.</p>
 * 
 * @author Albert GUO
 * @version 1.0
 *
 */
public class StudentInfo {
	static String[] userList = {"admin","instructorTom","instructorJerry"};
	static String[] pswdList = {"ad123","instructor123","instructor67890"};

    public static boolean Login(String username, String password){
        boolean result = false;
        if(0 == username.length() || 0 == password.length())
        	return result;
        for(int i = 0; i < userList.length; i++)
            if((0 == userList[i].compareToIgnoreCase(username))
                && (0 == pswdList[i].compareTo(password)))
                result = true;

        return result;
    }
}
