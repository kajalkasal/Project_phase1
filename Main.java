package javaproject1;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;


public class Main {
	

	public static void addFile()throws IOException
	{
		try
		{
		Scanner reader = new Scanner(System.in); 
		boolean success = false;

		System.out.println("Enter file name to be created "); 
		String filename = reader.nextLine(); 
		File f = new File(filename); 
		if (f.exists()) {
			System.out.println("File already exists"); }
		else { 
			System.out.println("No such file exists, creating now"); 
			success = f.createNewFile(); 
			if (success) 
			{ 
				System.out.printf("Successfully created new file: %s%n", f); 
			} else {
				System.out.printf("Failed to create new file: %s%n", f); 
			} 
		} // close Scanner to prevent resource leak 
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
	public static void delFile(String filename)
	{
		
		
		
		File f = new File(filename); 
		
		if (f.exists()) {
			if(f.delete())                      //returns Boolean value  
			{  
			System.out.println(f.getName() + " deleted");   //getting and printing the file name  
			}  
			else  
			{  
			System.out.println("failed");  
			}  
		} 
		else
		{
			System.out.println("File not found , can not delete");
		}
		
		
	
	}
	
	public static void addFileIntoDir()
	{
		File file = new File("C:\\Directory1");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
	}
	
	
	public static void searchFile(String name)
	{
		int flag=0;
		
		 File dir = new File("C:\\Users\\SONU\\Downloads");
	      String[] children = dir.list();
	      
	      if (children == null) {
	         System.out.println("does not exist or is not a directory");
	      } else {
	         for (int i = 0; i < children.length; i++) {
	        	 flag=0;
	            String filename = children[i];
	            if(name.equals(filename))
	            {
	            	//System.out.println("File found");
	            	flag=1;
	            	break;
	            }
	         }
	      }
	      
	      if(flag==1)
	    	  System.out.println("File found");
	      else
	    	  System.out.println("File not found");
		
	}
	public static void ascendFile()
	{
		File dir = new File("C:\\Users\\akash\\Desktop");
	    if(dir.isDirectory())
	    {
	      // Fetching the list from the directory
	      File[] files = dir.listFiles();

	      System.out.println("All the files including folders");
	      System.out.println("--------------------------------");
	      
	      //Lists only files since we have applied file filter
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	   
	   // Creating a filter to return only files.
	      FileFilter fileFilter = new FileFilter()
	      {
	        @Override
	        public boolean accept(File file) {
	          return !file.isDirectory();
	        }
	      };
	   
	   files = dir.listFiles(fileFilter);
	   
	      System.out.println("\nAfter filtering the folders");
	      System.out.println("--------------------------------");

	      // Sort files by name
	      Arrays.sort(files, new Comparator()
	      {
	        @Override
	        public int compare(Object f1, Object f2) {
	          return ((File) f1).getName().compareTo(((File) f2).getName());
	        }
	      });

	      //Prints the files in file name ascending order
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	      System.out.println("\nAfter sorting by name");
	      System.out.println("----------------------------------");

	      // Sort files by size.
	      Arrays.sort(files, new Comparator()
	      {
	        @Override
	        public int compare(Object f1, Object f2)
	        {
	          if (((File) f1).length() < ((File) f2).length())
	          {
	            return -1;
	          }
	          else if (((File) f1).length() > ((File) f2).length())
	          {
	            return 1;
	          }
	          else
	          {
	            return 0;
	          }
	        }
	      });

	      //Prints files in order by file size
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	      System.out.println("\nAfter sorting by length");
	      System.out.println("-------------------------------");

	      // Sort files by date.
 Arrays.sort(files, new Comparator()
{
@Override
public int compare(Object f1, Object f2)
{
         if (((File) f1).lastModified() < ((File) f2).lastModified())
{
        return -1;
 }
	          else if (((File) f1).lastModified() > ((File) f2).lastModified())
	          {
	            return 1;
	          }
	          else
	          {
	            return 0;
	          }
	        }
	      });

	      //Prints files in order by last modified date
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	      System.out.println("-------------------------");
	    }
	}

	public static void main(String[] args)  throws IOException
	{
		// TODO Auto-generated method stub

		  Scanner s=new Scanner(System.in);
		  
		 String fname="";
		 String fsearch="";
		   int ch=0;
		  do
		  {
			  System.out.println("\n*****************\n"); 
			  System.out.println("Wecome To Deckstop");
			  System.out.println("\n*****************\n");
			  
		  System.out.println("1.Show Files in assending order");
		  System.out.println("2.Add a new File to a directory");
		  System.out.println("3.Delete a  File");
		  System.out.println("4.Search a  File");
		  System.out.println("5.Close the application\n\n");
		  ch=s.nextInt();
		  
		  switch(ch)
		  {
		  case 1:
			  ascendFile();
			  break;
			  
		  case 2:
			  addFile();
			  break;
			  
		  
		  case 3:
			  
			  System.out.println("Enter file name to be Deleted "); 
			  fname=s.next();
			  delFile(fname);
			  break;
			  
		  case 4:
			  System.out.println("Enter file name to be searched "); 
			  fsearch=s.next();
			  searchFile(fsearch);
			  break;
			  
		  case 5:
			  System.out.println("Application is closed");
			  System.exit(0);
			  break;
			  
			  
			  default:
				  System.out.println("Please enter valid choice");
				  break;
			  
		  }
		  }while(ch!=0);
		  
		  
		 
		  
		  
		  
	  

	}

}
