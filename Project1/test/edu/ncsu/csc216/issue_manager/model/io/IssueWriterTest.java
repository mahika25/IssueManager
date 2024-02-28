/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;




/**
 * Class to test the IssueWriter class
 */
public class IssueWriterTest {
	
	/** Tests writeIssuesToFile method */
	@Test
	public void testWriteIssuesToFile() {
		
		List<Issue> issues = new ArrayList<Issue>();
		ArrayList<String> notes1 = new ArrayList<>();
		notes1.add("[New] Note 1");
		notes1.add("[Confirmed] Note 2");
		notes1.add("[Working] Note 3");
		issues.add(new Issue(3, "Working", "Bug", "Issue description", "", true, "", notes1));
		
		
		try {
			IssueWriter.writeIssuesToFile("test-files/writeRecords.txt", issues);
		} catch (IllegalArgumentException e) {
			fail("Cannot write to course records file");
		}
		
		checkFiles("test-files/issue10.txt", "test-files/writeRecords.txt");
	}
		

		/**
		 * Helper method to compare two files for the same contents
		 * @param expFile expected output
		 * @param actFile actual output
		 */
		private void checkFiles(String expFile, String actFile) {
			try (Scanner expScanner = new Scanner(new File(expFile));
				 Scanner actScanner = new Scanner(new File(actFile));) {
				
				while (expScanner.hasNextLine()) {
					assertEquals(expScanner.nextLine(), actScanner.nextLine());
				}
				
				expScanner.close();
				actScanner.close();
			} catch (IOException e) {
				fail("Error reading files.");
			}
		}

}
