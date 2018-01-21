package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.src.PatternFinder;

public class PatternFinderTester {

	public static void main(String[] args) {
		BufferedReader reader = null;
		File file = null;
		try {
			file = new File("log.txt");
			reader = new BufferedReader(new FileReader(file));
			
			String[] inSplit = new String[100000];
			String line = null;
			int i = 0;
			
			while(file.exists() && (line = reader.readLine()) != null){
				if(line.equals("") == false){
					inSplit[i++] = line;
				}
			}
			
			/*String[] inSplit = {
					"Can not find  class A object with id :  123 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class B object with id :  124 in module Service Discovery 2 waiting for response for BB working for 2",
					"Can not find  class B object with id :  125 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class A object with id :  123 in module Service Discovery 2 waiting for response for CC working for 1",
					"Can not find  class B object with id :  126 in module Service Discovery 1 waiting for response for BB working for 3",
					"Can not find  class A object with id :  127 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class A object with id :  123 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class B object with id :  124 in module Service Discovery 2 waiting for response for BB working for 4",
					"Can not find  class B object with id :  125 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class A object with id :  123 in module Service Discovery 2 waiting for response for CC working for 1",
					"Can not find  class B object with id :  126 in module Service Discovery 1 waiting for response for BB working for 2",
					"Can not find  class A object with id :  127 in module Service Discovery 1 waiting for response for AA working for 2",
					"Can not find  class A object with id :  123 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class B object with id :  124 in module Service Discovery 2 waiting for response for BB working for 2",
					"Can not find  class B object with id :  125 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class A object with id :  123 in module Service Discovery 2 waiting for response for CC working for 1",
					"Can not find  class B object with id :  126 in module Service Discovery 1 waiting for response for BB working for 1",
					"Can not find  class A object with id :  127 in module Service Discovery 1 waiting for response for AA working for 2",
					"Can not find  class A object with id :  123 in module Service Discovery 1 waiting for response for AA working for 1",
					"Can not find  class B object with id :  124 in module Service Discovery 2 waiting for response for BB working for 3",
					"Can not find  class B object with id :  125 in module Service Discovery 1 waiting for response for AA working for 4",
					"Can not find  class A object with id :  123 in module Service Discovery 2 waiting for response for CC working for 5",
					"Can not find  class B object with id :  126 in module Service Discovery 1 waiting for response for BB working for 6",
					"Can not find  class A object with id :  127 in module Service Discovery 1 waiting for response for AA working for 1"
			};*/
			
			/*int c = 0, c1 = 0, c2 = 0;
			for(int j = 1 ; j < inSplit.length && inSplit[j] != null ; j++){
				if(inSplit[j].substring(0, 10).equals(inSplit[j-1].substring(0, 10))){
					c++;
				}
				else{
					System.out.println(j + "--" + inSplit[j].substring(0, 10) + ", " + inSplit[j-1].substring(0, 10));
				}
				
				c1++;
			}
			System.out.println(c + " " + c1 + " " + c2);*/
			
			int count = 0;
			for(i = 0 ; inSplit[i] != null ; i++){
				count ++;
			}
		
			PatternFinder obj = new PatternFinder(count);
			
			System.out.println("\n" + obj.findPattern(inSplit, count));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
