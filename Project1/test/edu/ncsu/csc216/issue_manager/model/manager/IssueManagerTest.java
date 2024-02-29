package edu.ncsu.csc216.issue_manager.model.manager;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Class to test the IssueManager class
 */
public class IssueManagerTest {
	
	/**Tests getInstance method */
	@Test
	public void testGetInstance() {
		fail();
	}
	
	/**Tests saveIssuesToFile method */
	@Test
	public void testSaveIssuesToFile() {
		fail();
	}
	
	/**Tests loadIssuesFromFile method */
	@Test
	public void testLoadIssuesFromFile() {
		fail();
	}
	
	/**Tests createNewIssueList method */
	@Test
	public void testCreateNewIssueList() {
		fail();
	}
	
	/**Tests getIssueListAsArray method */
	@Test
	public void testGetIssueListAsArray() {
		fail();
	}
	
	/**Tests getIssueListAsArrayByIssueType method */
	@Test
	public void testGetIssueListAsArrayByIssueType() {
		fail();
	}
	
	/**Tests getIssueById method */
	@Test
	public void testGetIssueById() {
		IssueList list = new IssueList();
        int id = list.addIssue(IssueType.BUG, "summary", "note");
        assertEquals("summary", list.getIssueById(id).getSummary());
	}
	
	/**Tests executeCommand method */
	@Test
	public void testExecuteCommand() {
		fail();
	}
	
	/**Tests deleteissueById method */
	@Test
	public void testDeleteIssueById() {
		IssueList list = new IssueList();
        int id = list.addIssue(IssueType.BUG, "summary", "note");
        assertEquals(1, list.getIssues().size());
        list.deleteIssueById(id);
        assertEquals(0, list.getIssues().size());
	}
	
	/**Tests addIssueToList method */
	@Test
	public void testAddIssueToList() {
		IssueList issueList = new IssueList();
		int id = issueList.addIssue(IssueType.BUG, "summary", "note");
		assertEquals(1, id);
		 
		Issue issue = issueList.getIssueById(id);
		assertEquals("Bug", issue.getIssueType());
		assertEquals("summary", issue.getSummary());
		assertEquals("[New] note", issue.getNotes().get(0));
	}
	

}
