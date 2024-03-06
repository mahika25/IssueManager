package edu.ncsu.csc216.issue_manager.model.manager;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Class to test the IssueManager class
 */
public class IssueManagerTest {
	
	/**Creates an instance of issueManager to use */
	IssueManager manager = IssueManager.getInstance();
	
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
		manager.createNewIssueList();
		ArrayList<String> notes1 = new ArrayList<>();
		notes1.add("[New] Note 1");
		notes1.add("[Confirmed] Note 2");
		notes1.add("[Working] Note 3");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		
		
		try {
			manager.saveIssuesToFile("test-files/writeRecords.txt");
		} catch (IllegalArgumentException e) {
			fail("Cannot write to issues to file");
		}
		
		checkFiles("test-files/IssueManagerTest.txt", "test-files/writeRecords.txt");
		
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
			fail("Error reading files." + e.getMessage());
		}
	}
	
	/**Tests loadIssuesFromFile method */
	@Test
	public void testLoadIssuesFromFile() {
		manager.createNewIssueList();
		manager.loadIssuesFromFile("test-files/issue1.txt");
		
		Object[][] issues = manager.getIssueListAsArray();
		assertEquals(5, issues.length);
		assertEquals(1, issues[0][0]);
        assertEquals("New", issues[0][1]);
        assertEquals("Enhancement", issues[0][2]);
        assertEquals("Issue description", issues[0][3]);
   
	
	}
	
	/**Tests createNewIssueList method */
	@Test
	public void testCreateNewIssueList() {
		manager.createNewIssueList();
		assertEquals(0, manager.getIssueListAsArray().length);
	}
	
	/**Tests getIssueListAsArray method */
	@Test
	public void testGetIssueListAsArray() {
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
		manager.createNewIssueList();
	    manager.addIssueToList(IssueType.BUG, "summary1", "note1");
	    manager.addIssueToList(IssueType.ENHANCEMENT, "summary2", "note2");
	    manager.addIssueToList(IssueType.BUG, "summary3", "note3");
	    Object[][] issueArray = manager.getIssueListAsArrayByIssueType("Bug");
	    
	    assertEquals(2, issueArray.length);
	    
	    assertEquals("1", issueArray[0][0].toString());
	    assertEquals("New", issueArray[0][1].toString());
	    assertEquals("Bug", issueArray[0][2].toString());
	    assertEquals("summary1", issueArray[0][3].toString());
	    
	    assertEquals("3", issueArray[1][0].toString());
	    assertEquals("New", issueArray[1][1].toString());
	    assertEquals("Bug", issueArray[1][2].toString());
	    assertEquals("summary3", issueArray[1][3].toString());
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
		manager.createNewIssueList();
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		Command command = new Command(CommandValue.CONFIRM, "mkpatil", Resolution.FIXED, "note");
		manager.executeCommand(1, command);
		
		Issue curIssue = manager.getIssueById(1);
	    assertEquals(Issue.CONFIRMED_NAME, curIssue.getStateName());
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
	
	/**Tests getIssueListAsArrayByIssueType method */
	@Test
	public void testGetIssueListAsArrayByIssueType2() {
		manager.loadIssuesFromFile("test-files/issue1.txt");
	    Object[][] issueArray = manager.getIssueListAsArrayByIssueType("Bug");
	    
	    assertEquals(2, issueArray.length);
	    
	    assertEquals("3", issueArray[0][0].toString());
	    assertEquals("Confirmed", issueArray[0][1].toString());
	    assertEquals("Bug", issueArray[0][2].toString());
	    assertEquals("Issue description", issueArray[0][3].toString());
	    
	    assertEquals("7", issueArray[1][0].toString());
	    assertEquals("Working", issueArray[1][1].toString());
	    assertEquals("Bug", issueArray[1][2].toString());
	    assertEquals("Issue description", issueArray[1][3].toString());
	}
	
	/**Tests deleteissueById method */
	@Test
	public void testAddIssueToList() {
		manager.createNewIssueList();
	    manager.addIssueToList(IssueType.BUG, "summary1", "note1");
	    manager.addIssueToList(IssueType.ENHANCEMENT, "summary2", "note2");
	    manager.addIssueToList(IssueType.BUG, "summary3", "note3");
	    Object[][] issueArray = manager.getIssueListAsArrayByIssueType("Bug");
	    
	    assertEquals(2, issueArray.length);
	    
	    assertEquals("1", issueArray[0][0].toString());
	    assertEquals("New", issueArray[0][1].toString());
	    assertEquals("Bug", issueArray[0][2].toString());
	    assertEquals("summary1", issueArray[0][3].toString());
	    
	    assertEquals("3", issueArray[1][0].toString());
	    assertEquals("New", issueArray[1][1].toString());
	    assertEquals("Bug", issueArray[1][2].toString());
	    assertEquals("summary3", issueArray[1][3].toString());
	}

	

}
