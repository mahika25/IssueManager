package edu.ncsu.csc216.issue_manager.model.manager;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Class to test the IssueList class
 */
public class IssueListTest {
	
	/** Tests the addIssue method */
	@Test
	public void testAddIssue() {
		IssueList issueList = new IssueList();
		int id = issueList.addIssue(IssueType.BUG, "summary", "note");
		assertEquals(1, id);
		 
		Issue issue = issueList.getIssueById(id);
		assertEquals("Bug", issue.getIssueType());
		assertEquals("summary", issue.getSummary());
		assertEquals("[New] note", issue.getNotes().get(0));

		
	}
	
	/** Tests the addIssues method */
	@Test
	public void testAddIssues() {
		IssueList list = new IssueList();
        assertEquals(0, list.getIssues().size());
        List<Issue> issuesToAdd = new ArrayList<>();
        issuesToAdd.add(new Issue(1, IssueType.BUG, "summary", "note"));
        issuesToAdd.add(new Issue(2, IssueType.ENHANCEMENT, "summary1", "note2"));
        list.addIssues(issuesToAdd);
        assertEquals(2, list.getIssues().size());
        assertEquals("New", list.getIssues().get(0).getStateName());
        assertEquals("summary1", list.getIssues().get(1).getSummary());
	}
	
	/** Tests the getIssues method */
	@Test
	public void testGetIssues(){
		IssueList list = new IssueList();
        assertEquals(0, list.getIssues().size());
        list.addIssue(IssueType.BUG, "summary1", "note2");
        assertEquals(1, list.getIssues().size());
        assertEquals("summary1", list.getIssues().get(0).getSummary());
	}
	
	/** Tests the getIssuesByType method */
	@Test
	public void testGetIssuesByType(){
		IssueList list = new IssueList();
        list.addIssue(IssueType.BUG, "summary1", "note");
        list.addIssue(IssueType.ENHANCEMENT, "summary2", "note2");
        list.addIssue(IssueType.BUG, "summary3", "note3");
        assertEquals(2, list.getIssuesByType("Bug").size());
        assertEquals(1, list.getIssuesByType("Enhancement").size());
	}
	
	/** Tests the getIssueById method */
	@Test
	public void testGetIssueById(){
		IssueList list = new IssueList();
        int id = list.addIssue(IssueType.BUG, "summary", "note");
        assertEquals("summary", list.getIssueById(id).getSummary());
	}
	
	/** Tests the executeCommand method */
	@Test
	public void testExecuteCommand() {
		IssueList list = new IssueList();
        assertEquals(0, list.getIssues().size());
        
      
        int id = list.addIssue(IssueType.BUG, "Bug summary", "Bug note");
        Command command = new Command(CommandValue.ASSIGN, "Owner", Resolution.DUPLICATE, "Note");
        list.executeCommand(id, command);
        assertEquals("Owner", list.getIssueById(id).getOwner());
        
        command = new Command(CommandValue.CONFIRM, "", Resolution.FIXED, "Confirming the issue");
        list.executeCommand(id, command);
        assertTrue(list.getIssueById(id).isConfirmed());
	}
	
	/** Tests the deleteIssueById method */
	@Test
	public void testDeleteIssueById() {
		IssueList list = new IssueList();
        int id = list.addIssue(IssueType.BUG, "summary", "note");
        assertEquals(1, list.getIssues().size());
        list.deleteIssueById(id);
        assertEquals(0, list.getIssues().size());
	}

}
