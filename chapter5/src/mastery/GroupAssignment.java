/* 

Program: GroupAssignment.java              Date: October 8th 2024

Purpose: Create a GroupAssignment application that prompts the user for his or her name and then displays a group assignment. The group assignment dependso n the first letter of the student's last name. Last names beginning with A through I are assigned to group 1, J through S are assigned to group 2, T through Z are assigned to group 3.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner; import java.lang.String; import java.util.HashMap;

public class GroupAssignment {

	public static void main(String[] args) 
	{
		// here, we store which nameIdentifier (the first letter of the user's last name) is assigned to which group.
		HashMap<String, String> groupList = new HashMap<String, String>();
		groupList.put("a", "group 1");
		groupList.put("b", "group 1");
		groupList.put("c", "group 1");
		groupList.put("d", "group 1");
		groupList.put("e", "group 1");
		groupList.put("f", "group 1");
		groupList.put("g", "group 1");
		groupList.put("h", "group 1");
		groupList.put("i", "group 1");
		groupList.put("j", "group 2");
		groupList.put("k", "group 2");
		groupList.put("l", "group 2");
		groupList.put("m", "group 2");
		groupList.put("n", "group 2");
		groupList.put("o", "group 2");
		groupList.put("p", "group 2");
		groupList.put("q", "group 2");
		groupList.put("r", "group 2");
		groupList.put("s", "group 2");
		groupList.put("t", "group 3");
		groupList.put("u", "group 3");
		groupList.put("v", "group 3");
		groupList.put("w", "group 3");
		groupList.put("x", "group 3");
		groupList.put("y", "group 3");
		groupList.put("z", "group 3");
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		// declaring variables
		System.out.print("Please enter your first name: "); String firstName = userInput.nextLine();
		System.out.print("Please input your last name: "); String lastName = userInput.nextLine();
		String nameIdentifier = lastName.substring(0, 1).toLowerCase(); // can't cast from string to char, otherwise I would be using that.
		String group = groupList.get(nameIdentifier);
		
		
		if (group != null)  // this executes if nameIdentifier is a valid key in the hashmap.
		{
			System.out.println(firstName + " " + lastName + " is part of " + group);
		}
		else 
		{
			System.out.println("Name inputted is not a valid HashMap key. Please try again.");
		}
		
		// close userinput
		userInput.close();
		
		
	}

}
