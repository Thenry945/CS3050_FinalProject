package BattlesHenrichsScully;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class readInFile{
	
	private String filename;
	
	public readInFile(String name){
		setFname(name);
	}
	
	private void setFname(String name){
		this.filename = name;
	}
	
	public ArrayList<String> readFile() throws IOException{
		ArrayList<String> fileList = new ArrayList<String>();
		for(String line : Files.readAllLines(Paths.get(this.filename))){
			fileList.add(line);
		}
		
		return fileList;
	}
	
	
	
}