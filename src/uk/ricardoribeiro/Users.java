package uk.ricardoribeiro;

import java.util.Vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Users {
	Vector<Vector<String>> users = new Vector<Vector<String>>();
	
	public Users()
	{
		String fileName = "Logins.config";
		
		//read file into stream, try-with-resources
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int x = 1 ; x <list.size();x++)
		{
						
			addUser(list.get(x).split(",")[0],list.get(x).split(",")[1]);
		}
	

	}
	public void addUser(String uname,String pword)
	{
		Vector<String> temp = new Vector<String>();
		temp.add(uname);
		temp.add(pword);
		users.add(temp);
	}
	public Boolean verifyUser(String uname,String pword)
	{
		
		for(int i = 0; i< users.size(); i++)
		{
			if(users.get(i).get(0).equals(uname))//username,
			{
				if( users.get(i).get(1).equals(pword))//password
				{
					return true;	
				}else{return false;}
			}
		}
		return false;
	}

}
