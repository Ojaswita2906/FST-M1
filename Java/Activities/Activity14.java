package activities;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file =new File("C:\\Users\\OjaswitaPaul\\Documents\\eclipse\\check3.txt");
		
		boolean fStatus = file.createNewFile();
		
		if (fStatus) {
			FileUtils.writeStringToFile(file, "My Name is Ojaswita", Charset.defaultCharset());
        } else {
            System.out.println("File already exists at this path.");
        }
		
		System.out.println("Read File : " + FileUtils.readFileToString(file, "UTF8"));
		
		File destDir = new File("C:\\Users\\OjaswitaPaul\\Documents");
		FileUtils.copyFileToDirectory(file, destDir);
		
		//Get file from new directory
		File newFile = FileUtils.getFile(destDir, "check3.txt");
		//Read data from file
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		
		System.out.println("Read newfile: " + newFileData);
		
		 
	}
	
	
	

}
