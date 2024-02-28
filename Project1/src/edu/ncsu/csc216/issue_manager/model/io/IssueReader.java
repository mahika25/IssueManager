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
			
			String[] issueStrings = fileString.split("\\r?\\n?[*]");
			
			for(int i = 0; i < issueStrings.length; i++) {
				
				try {
					Issue issue = processIssue(issueStrings[i]);
					issues.add(issue);
				} 
				
				catch (Exception e) {
					throw new IllegalArgumentException("Unable to load file.");
				}
			}
			
			
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
		String[] lineBreaker = line.split(",");
		
		if(lineBreaker.length < 7 || lineBreaker.length > 8) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		int id = Integer.parseInt(lineBreaker[0].substring(1));
		String state = lineBreaker[1];
        String issueType = lineBreaker[2];
        String summary = lineBreaker[3];
        String owner = lineBreaker[4];
        boolean confirmed = Boolean.parseBoolean(lineBreaker[5]);
        String resolution;
        ArrayList<String> notes = new ArrayList<>();
        
        String notesString;
        if(lineBreaker.length == 7) {
        	resolution = "";
        	notesString = lineBreaker[6];
  	
        }
        
        else {
        	resolution = lineBreaker[6];
        	notesString = lineBreaker[7];
        }
        
        String[] noteParts = notesString.split("\\r?\\n?[-]");
    	for(int i = 0; i < noteParts.length; i++) {
    		notes.add(noteParts[i]);
    	}
    	
    	Issue issue = new Issue(id, state, issueType, summary, owner, confirmed, resolution, notes);
    	return issue;
	}

}
