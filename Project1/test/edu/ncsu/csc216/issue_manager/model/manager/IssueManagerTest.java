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
		IssueManager manager1 = IssueManager.getInstance();
		IssueManager manager2 = IssueManager.getInstance();
		assertSame(manager1, manager2);
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
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
		assertEquals(0, manager.getIssueListAsArray().length);
	}
	
	/**Tests getIssueListAsArray method */
	@Test
	public void testGetIssueListAsArray() {
		IssueManager manager = IssueManager.getInstance();
	    manager.createNewIssueList();
	    manager.addIssueToList(IssueType.BUG, "summary1", "note1");
	    manager.addIssueToList(IssueType.ENHANCEMENT, "summary2", "note2");
	    Object[][] issueArray = manager.getIssueListAsArray();
	    
	    assertEquals(2, issueArray.length);
	    
	    assertEquals("1", issueArray[0][0].toString());
	    assertEquals("New", issueArray[0][1].toString());
	    assertEquals("Bug", issueArray[0][2].toString());
	    assertEquals("summary1", issueArray[0][3].toString());
	    
	    assertEquals("2", issueArray[1][0].toString());
	    assertEquals("New", issueArray[1][1].toString());
	    assertEquals("Enhancement", issueArray[1][2].toString());
	    assertEquals("summary2", issueArray[1][3].toString());
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
