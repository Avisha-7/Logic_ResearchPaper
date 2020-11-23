package Logic_ResearchPaper;

import java.util.*;

//BirthdayBook implementation by Z notation given in the research paper using java class

public class BirthdayBook
{
	// Creating two ArrayList to store names and birthdays of people.
	// Names of people and their corresponding birthday are stored at the same index position of the
	// ArrayList names and ArrayList birthdays.
	
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> dates = new ArrayList<String>();
	
    // creating hwm variable which stores the birthday list length in the current state
	private int hwm; 

	//Constructor
	public BirthdayBook()
	{
		//InitBirthdayBook Schema Implementation 
		hwm = 0;
	}

	public String AddBirthday(String name, String date)
	{
		//AddBirthday1 Schema Implementation
		for (Iterator<String> iter = names.iterator(); iter.hasNext();)
		{
			String string = (String) iter.next();
			if (string.equals(name))
			{
				return "Birthday record already exists!";
			}

		}
		this.names.add(name);
		this.dates.add(date);
		hwm++;
		return "Birthday added successfully";
	}
	
	public String findBirthday(String name)
	{
		//FindBirthday1 Schema Implementation
		for (int i = 0; i < hwm; i++)
		{
			if (names.get(i).equals(name))
				return name + "'s Birthday is " + dates.get(i);
		}

		return "Birthday not found in Birthday Book!!";
	}


	public ArrayList<String> Remind(String date)
	{
		// implementation of RemindBirthdayBook
		ArrayList<String> reminder = new ArrayList<String>();
		for (int i = 0; i < hwm; i++)
		{
			if (dates.get(i).equals(date))
				reminder.add(names.get(i));
		}
		return reminder;
	}

	//Driver Class
	public static void main(String[] args)
	{
		BirthdayBook bdbook = new BirthdayBook();
		System.out.println(bdbook.AddBirthday("Avisha", "07-08-2000"));
		System.out.println(bdbook.AddBirthday("Mansi", "11-01-2001"));
		System.out.println(bdbook.AddBirthday("Geeti", "03-08-2000"));		
		System.out.println(bdbook.AddBirthday("Ashlesha", "12-02-2001"));
		System.out.println(bdbook.Remind("07-08-2000"));
		System.out.println(bdbook.findBirthday("Avisha"));

	}

}
