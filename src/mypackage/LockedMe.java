package mypackage;

import java.io.File;
import java.util.*;

public class LockedMe {
	
	public static void displayWelcome(Directory root) {
		System.out.println("Welcome to LockedMe.com");
	    System.out.println("Developed by: Jawaher Al Ghadani\nVersion Date: March 2022");
	    System.out.println("Root Directory : "+root.name);
	    System.out.println("Root Directory Size : "+root.size);
	}
	
	public static void displayUserOptions() {
	      // create hashmap for user options
	       HashMap<Integer, String> options = new HashMap<Integer, String>();
	       
	     options.put(1, "List all files in the current directory.");
	     options.put(2, "Add file to the current directory.");
	     options.put(3, "Delete a file from the current directory.");
	     options.put(4, "Search a file from the current directory.");
	     options.put(5, "Go back to the root directory.");
	     options.put(6, "Exit the program.");
	     
	     System.out.println("\n");
	     System.out.println("Please select what are you looking for:");
	     //.. print user options
	       for (int i : options.keySet()) {
	    	   System.out.println(i+". "+options.get(i));
	       }   
	}
	
	
	
	public static int select() {
		int user_select = 0;

		try {
 		   System.out.println("Please enter a number 1/2/3/4/5/6");
 		   Scanner sc = new Scanner(System.in);
 		   user_select = sc.nextInt();
 		  if (user_select >= 1 && user_select <= 6)
 			  return user_select;
		  else
			  System.out.println("Invalid input!");
		
 	   }
 	   catch(InputMismatchException e) {
 		   System.out.println("Invalid input!");
 	   }
		return select();
		
	}
	
	
	
	
	public static void main(String[] args) {
		boolean is_on = true;
	    Directory directory = new Directory(".\\MyRepository\\");
	    LockedMe.displayWelcome(directory);
	    while (is_on) {
		    LockedMe.displayUserOptions();
		       
		    int user_input = LockedMe.select();
		    Scanner sc = new Scanner(System.in);
		    
		    switch (user_input) {
		    case 1:
		    	directory.displayListOfFiles();
		    	break;
		    case 2:
		    	System.out.println("add file name: ");
		    	String new_file = sc.next();
		    	directory.addFile(new_file);
		    	break;
		    	
		    case 3:
		    	System.out.println("file name to be deleted: ");
		    	String delete_file = sc.next();
		    	directory.deleteFile(delete_file);
		    	break;
		    	
		    case 4:
		    	System.out.println("search file name: ");
		    	String search_file = sc.next();
		    	if (directory.searchFile(search_file)) {
		    		directory = new Directory(directory.directory_path+"\\"+search_file);
		    		System.out.println(directory.directory_path);
		    	}
		    		
		    	break;
		    
		    case 5:
		    	directory = new Directory(".\\MyRepository\\");
		    	System.out.println(directory.directory_path);
		    	break;
		    case 6:
		    	System.out.println("Program terminated ...");
		    	is_on = false;
		    	break;
		    	
		    }
		    
		}
	}


}
