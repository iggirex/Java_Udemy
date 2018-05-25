package com.iggi.learningfilereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApplicationClass {

	public static void main(String[] args) {
		
		File file = new File("myfile.txt"); // making a new file

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);){
			
			String line = bufferedReader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading the file " + file.getName());
		}
	}
}
