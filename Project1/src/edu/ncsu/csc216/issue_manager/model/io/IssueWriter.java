/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * Class that writes issues to a file
 * @author Mahika Patil
 */
public class IssueWriter {
	
	/**
	 * writes issues to file
	 * @param filename filename to write to
	 * @param issues issues to write in the file
	 */
	public static void writeIssuesToFile(String filename, List<Issue> issues) {
		
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(filename));
			for (int i = 0; i < issues.size(); i++){
				Issue issue = issues.get(i);
				output.print(issue.toString());
			}
			
			output.close();
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		
		
	}

}
