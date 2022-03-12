package mypackage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Directory {
	//Creating a File object for directory
	static File main_file;
	static String directory_path;
	String name;
	long size;
	
	public Directory(String path) {
		main_file = new File(path);
		name = main_file.getName();
		size = main_file.getTotalSpace();
		directory_path = main_file.getAbsolutePath();
	}
	

	public static void displayListOfFiles() {
	    //List of all files and directories
		String contents[] = main_file.list();
	    System.out.println("List of files and directories in the specified directory:");
	    if (contents.length > 0) {
		    for(int i=0; i<contents.length; i++) {
		       System.out.println(contents[i]);
		       
		    }
	    } else {
	    	  System.out.println("No Files Found");
	      }
	}
	
	
	
	public void addFile(String file_name) {
		File new_file = new File(directory_path+"\\"+file_name);
		if(new_file.exists()){
			System.out.println("File already exist.");
			
		} else {
			try {
				new_file.createNewFile();
				System.out.println("File successfully added!\n"+new_file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	
	public static void deleteFile(String file_name) {
		
		try {
			File f= new File(directory_path+"\\"+file_name);           //file to be delete  
			if(f.delete())
				System.out.println(f.getName() + " deleted");   //getting and printing the file name  
			else
				System.out.println(file_name+" file doesnt exist");
			
			} catch(Exception e) {
				System.out.println("failed to dlete the file"); 
			    e.printStackTrace();
			    }  
	}
	
	
	
	public static boolean searchFile(String file_name) {
		boolean found = false;
		String contents[] = main_file.list();
	    if (contents.length > 0) {
		    for(int i=0; i<contents.length; i++) {
		       
		       if (file_name.equals(contents[i]))  
		    	   found = true;
		    }
	    } else {
	    	  System.out.println("Current directory is empty.");
	      }
	    
	    if (found) {
	    	System.out.println("file found.");
	    	
	    	if (isDirectory(file_name))
	    		System.out.println("this file is a directory.");
	    	else
	    		System.out.println("this file isn't a directory.");
	    } else
	    	   System.out.println("File doesn't exist.");
	    
	    return isDirectory(file_name);		
	}
	
	private static boolean isDirectory(String file_name) {
		// check if the search file is a directory 
		File file = new File(directory_path+"\\"+file_name);
 	   
		if (file.isDirectory()) {
		   return true;
		   
		}
		else {
 		  return false;
		}	
	}	
}










