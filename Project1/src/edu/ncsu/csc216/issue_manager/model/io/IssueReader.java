/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * Class to read Issues from a file
 * @author Mahika Patil
 */
public class IssueReader {
	
	/** Constructs an IssueReader object */
	public IssueReader() {
		// empty constructor
	}
	
	/** 
	 * Reads issue from a file
	 * @param filename the name of the file issues are being read from
	 * @return a list of issues
	 */
	public static ArrayList<Issue> readIssuesFromFile(String filename){
		ArrayList<Issue> issues = new ArrayList<>();
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(filename));
			String fileString = "";
			while(fileReader.hasNextLine()) {
				fileString += fileReader.nextLine() + "\n";
			}
			
			Scanner lineReader = new Scanner(fileString);
			lineReader.useDelimiter("\\r?\\n?[*]");
			
			while (lineReader.hasNext()) {
				Issue issue = processIssue(lineReader.next());
				issues.add(issue);
			}
			lineReader.close();
			
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		return issues;
	}
	
	/** 
	 * Processes and individual issue
	 * @param line line of the file
	 * @return a processed issue
	 */
	private static Issue processIssue(String line) {
			Scanner lineScanner = new Scanner(line);
			String firstLine = lineScanner.nextLine();
			String secondLine = "";
			while(lineScanner.hasNextLine()){
				secondLine += lineScanner.nextLine();
			}
			
			lineScanner.close();
			
			Scanner lineBreaker = new Scanner(firstLine);
			lineBreaker.useDelimiter(",");
			
			 int id = lineBreaker.nextInt();
			 String state = lineBreaker.next();
			 String issueType = lineBreaker.next();
			 String summary = lineBreaker.next();
			 String owner = lineBreaker.next();
			 boolean confirmed = Boolean.parseBoolean(lineBreaker.next());
			 String resolution;
			 if(lineBreaker.hasNext()) {
				 resolution = lineBreaker.next();
			 }
			 
			 else {
				 resolution = "";
			 }
			
			 lineBreaker.close();
			 
			 Scanner notesReader = new Scanner(secondLine);
			 notesReader.useDelimiter("\\r?\\n?[-]");
			 
			 ArrayList<String> noteList = new ArrayList<>();
			 
			 while(notesReader.hasNext()) {
				 noteList.add(notesReader.next());
			 }
			 
			 notesReader.close();
			
			Issue issue = new Issue(id, state, issueType, summary, owner, confirmed, resolution, noteList);
			return issue;
		
       }
        
    	
    	
}

