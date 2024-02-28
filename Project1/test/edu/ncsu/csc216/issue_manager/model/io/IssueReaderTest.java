package edu.ncsu.csc216.issue_manager.model.io;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * Class to test the IssueReader class
 */
public class IssueReaderTest {
	
	/** Tests the readIssuesFromFile method for a valid file*/
	@Test
	public void testReadIssuesFromFileValid(){
		ArrayList<Issue> issues = IssueReader.readIssuesFromFile("test-files/issue1.txt");
        assertEquals(5, issues.size());
        
        // Test individual issues
        Issue issue1 = issues.get(0);
        assertEquals(1, issue1.getIssueId());
        assertEquals("New", issue1.getStateName());
        assertEquals("Enhancement", issue1.getIssueType());
        assertEquals("Issue description", issue1.getSummary());
        assertEquals("", issue1.getOwner());
        assertEquals(false, issue1.isConfirmed());
        assertEquals("", issue1.getResolution());
        assertEquals(1, issue1.getNotes().size());
        assertEquals("Note 1", issue1.getNotes().get(0));
        
        
        Issue issue2 = issues.get(3);
        assertEquals(14, issue2.getIssueId());
        assertEquals("Verifying", issue2.getStateName());
        assertEquals("Enhancement", issue2.getIssueType());
        assertEquals("Issue description", issue2.getSummary());
        assertEquals("owner", issue2.getOwner());
        assertEquals(false, issue2.isConfirmed());
        assertEquals("Fixed", issue2.getResolution());
        assertEquals(3, issue2.getNotes().size());
        assertEquals(" Note 1", issue2.getNotes().get(0));
        assertEquals(" Note 2", issue2.getNotes().get(1));
        assertEquals(" Note 3", issue2.getNotes().get(2));
	}
	

}
