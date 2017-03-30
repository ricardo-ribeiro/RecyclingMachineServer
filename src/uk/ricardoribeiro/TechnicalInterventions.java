package uk.ricardoribeiro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class TechnicalInterventions {
	public static Vector<Vector> techAccess = new Vector();
	public TechnicalInterventions(){
		//load everyrhing from file
		File file = new File(System.getProperty("user.dir")+File.separator+"TechAccess"+".log");
		FileReader read = null;
		 // This will reference one line at a time
		String line=null;
		try {
			read = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(read);
				
	            try {
					while((line = bufferedReader.readLine()) != null) {
					    //System.out.println(line);
						String[] row = line.split(",");
						Vector<String> theRow = new Vector();
						for (String item:row){
							theRow.add(item);
						}
						techAccess.add(theRow);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
	            System.out.println(techAccess);
	            // Always close files.
	            try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}         
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//data-time,username
	public static void addEntry(String user,String action){
		Vector<String> to_add = new Vector<String>();
		to_add.add( new Date().toString());
		to_add.add(user);
		to_add.add(action);
		techAccess.add(to_add);
		updateFile();
		// call the update file method
	}
	
	public static void updateFile(){
		File file = new File(System.getProperty("user.dir")+File.separator+"TechAccess"+".log");
		try {
			FileWriter author = new FileWriter(file,false);
			for(Vector row:techAccess)
			{
				author.write(""+row.get(0)+","+row.get(1)+","+row.get(2)+"\n");
			}
			author.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
