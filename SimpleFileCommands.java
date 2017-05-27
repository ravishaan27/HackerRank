import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleFileCommands {

	static ArrayList<String> fileList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
		String[] output = new String[q];
		
        // Process each command
        for(int a0 = 0; a0 < q; a0++){
            // Read the first string denoting the command type
            String command = in.next();
			String initFileName = in.next();
			String finalFileName;
			
			if(command.equals("crt")){
				finalFileName = getFileName(initFileName);
				createFile(finalFileName);
				output[a0] = "+ " + finalFileName;
			}
			
			if(command.equals("del")){
				deleteFile(initFileName);
				output[a0] = "- " + initFileName;
			}
			
			if(command.equals("rnm")){
				String destFileName = in.next();
				finalFileName = getFileName(destFileName);
				deleteFile(initFileName);
				createFile(finalFileName);
				output[a0] = "r " + initFileName + " -> " + finalFileName;
			}
			
            // Write additional code to read the command's file name(s) and process the command
            // Print the output string appropriate to the command
        }
		
		for(int i=0; i<output.length;i++){
			System.out.println(output[i]);
		}
    }
	
	static String getFileName(String inFile){
		boolean fileExists = true;
		int x = 0;
		
		while(fileExists){
			//System.out.println(x);
			if((x == 0) && (SimpleFileCommands.fileList.contains(inFile))){
				x++;
			}else if(SimpleFileCommands.fileList.contains(inFile+"(" + x + ")")){
				x++;
			}else
			{
				fileExists = false;
			}
		}
		if(x != 0)
			inFile += "(" + x + ")";
		
		return inFile;
	}
	
	static void createFile(String inFile){
		SimpleFileCommands.fileList.add(inFile);
	}
	
	static void deleteFile(String inFile){
		SimpleFileCommands.fileList.remove(inFile);
	}
}