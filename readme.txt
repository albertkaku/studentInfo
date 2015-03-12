# studentInfo 

Author: Albert GUO

I build up a project to test
I designed and executed 32 test cases for 6 APIs(All passed):


#Login
 1. Success to Login With Valid User Name And Matched Password
 2. Success to prevent login with wrong password
 3. Success to prevent login with invalid user name
 4. Success to prevent login with none user name
 5. Success to prevent login with none password
 6. Success to prevent login with no user name nor password

#AddStudent
 7. success to add a student information into the system
 8. success to add a student into the system with different first name
 9. success to add a student into the system with different last name
10. Success to prevent adding with same name
11. Success to prevent adding with no first name
12. Success to prevent adding with no last name
13. Success to prevent adding with no name

#GetStudent(id)
14. get student info by valid id (id == 1)
15. get student info by valid id (id ==biggest valid id)
16. success to prevent getting info by invalid id (id == 0)
17. success to prevent getting info by invalid id (too big id)

#UpdateStudent
18. update student grade (id, first name and last name all match)
19. update student grade and last name(id, first name match)
20. update student grade and first name(id, last name match)
21. success to prevent updating (only id match)
22. success to prevent updating (no match)
23. success to prevent updating with invalid id (id == 0)
24. success to prevent updating with no first name input(firstName == "")
25. success to prevent updating with no last name input (lastName == "")
26. success to prevent updating with no name (name == null)

#DropStudent(id)
27. success to prevent dropping someone with invalid id (too big)
28. success to prevent dropping someone with invalid id (id == 0)
29. success to drop all
30. success to prevent crashing when try to drop with no data in database

#ListStudents
31. success to get all info from database
32. success to prevent crashing when try to list but no data in the database