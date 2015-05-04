package BattlesHenrichsScully;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class readInFile{
	//string that holds the file name
	private String filename;
	/*
	 * constructor - sets the filename attribute
	 */
	public readInFile(String name){
		setFname(name);
	}
	/**
	 * sets the filename
	 * @param name
	 */
	private void setFname(String name){
		this.filename = name;
	}
	/**
	 * creates and returns an arraylist that contains every line from a file
	 * @return - return an array list
	 * @throws IOException - just in case
	 */
	public ArrayList<String> readFile() throws IOException{
		ArrayList<String> fileList = new ArrayList<String>();
		for(String line : Files.readAllLines(Paths.get(this.filename))){
			fileList.add(line);
		}
		
		return fileList;
	}
	
	
}