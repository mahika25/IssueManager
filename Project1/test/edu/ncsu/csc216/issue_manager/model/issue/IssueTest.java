package edu.ncsu.csc216.issue_manager.model.issue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Class to test the Issue class
 */
public class IssueTest {
	
	/**Issue ID for testing */
	private int id = 1;
	/**Issue owner for testing */
	private IssueType issueType = IssueType.ENHANCEMENT;
	/**Issue summary for testing */
	private String summary = "summary";
	/**Issue note for testing */
	private String note = "note";

	
	
	/** Tests all getter and setter methods in the class*/
	@Test
	public void testGetterMethods() {
		
		Issue issue = new Issue(id, issueType, summary, note);
		assertEquals(1, issue.getIssueId());
		assertEquals("Enhancement", issue.getIssueType());
		assertEquals(summary, issue.getSummary());
		assertEquals("[New] note", issue.getNotes().get(0));
		assertEquals(null, issue.getOwner());
		assertFalse(issue.isConfirmed());
		assertEquals("New", issue.getStateName());
		assertNull(issue.getResolution());
		
	}
	
	/** Tests toString method */
	@Test
	public void testToString() {
		Issue issue = new Issue(id, issueType, summary, note);
		assertEquals("*1,New,Enhancement,summary,,false,\n-[New] note \n", issue.toString());
	}
	
	/** Tests testUpdate method */
	@Test
	public void testUpdate() {
		Issue issue = new Issue(id, issueType, summary, note);
		assertEquals("New", issue.getStateName());
		
		Command c = new Command(CommandValue.ASSIGN, "mkpatil", Resolution.WONTFIX, "note");
		issue.update(c);
		assertEquals("mkpatil", issue.getOwner());
		assertEquals("Working", issue.getStateName());
		
		Command c2 = new Command(CommandValue.RESOLVE, "mkpatil", Resolution.FIXED, "note2");
		issue.update(c2);
		assertEquals("Verifying", issue.getStateName());
		
		Command c3 = new Command(CommandValue.VERIFY, "mkpatil", Resolution.FIXED, "note2");
		issue.update(c3);
		assertEquals("Closed", issue.getStateName());
		
		
		
	}
	
	/** Tests testUpdate method */
	@Test
	public void testUpdate2() {
		ArrayList<String> notes = new ArrayList<>();
		Issue issue = new Issue(id, "New", "Bug", "summary", "mkpatil", true, "Duplicate", notes);
		assertEquals("New", issue.getStateName());
		
		Command c = new Command(CommandValue.CONFIRM, "mkpatil", Resolution.WONTFIX, "note");
		issue.update(c);
		assertEquals("Confirmed", issue.getStateName());
		
		Command c2 = new Command(CommandValue.RESOLVE, "mkpatil", Resolution.WONTFIX, "note2");
		issue.update(c2);
		assertEquals("Closed", issue.getStateName());
		
		Command c3 = new Command(CommandValue.REOPEN, "mkpatil", Resolution.FIXED, "note3");
		issue.update(c3);
		assertEquals("Working", issue.getStateName());
		
	}
	
	/** Tests testUpdate method */
	@Test
	public void testUpdate3() {
		ArrayList<String> notes = new ArrayList<>();
		Issue issue = new Issue(id, "New", "Bug", "summary", "mkpatil", false, "Duplicate", notes);
		assertEquals("New", issue.getStateName());
		
		Command c = new Command(CommandValue.RESOLVE, "mkpatil", Resolution.DUPLICATE, "note");
		issue.update(c);
		assertEquals("Closed", issue.getStateName());
		
		Command c2 = new Command(CommandValue.REOPEN, "mkpatil", Resolution.DUPLICATE, "note2");
		issue.update(c2);
		assertEquals("Confirmed", issue.getStateName());
		
		Command c3 = new Command(CommandValue.ASSIGN, "mkpatil", Resolution.DUPLICATE, "note3");
		issue.update(c3);
		assertEquals("Working", issue.getStateName());
		
		Command c4 = new Command(CommandValue.RESOLVE, "mkpatil", Resolution.DUPLICATE, "note2");
		issue.update(c4);
		assertEquals("Closed", issue.getStateName());
		
	}
	
	/** Tests testUpdate method */
	@Test
	public void testUpdate4() {
		ArrayList<String> notes = new ArrayList<>();
		Issue issue = new Issue(id, "New", "Bug", "summary", null, true, "Duplicate", notes);
		assertEquals("New", issue.getStateName());
		
		Command c = new Command(CommandValue.RESOLVE, null, Resolution.DUPLICATE, "note");
		issue.update(c);
		assertEquals("Closed", issue.getStateName());
		
		Command c2 = new Command(CommandValue.REOPEN, null, Resolution.DUPLICATE, "note2");
		issue.update(c2);
		assertEquals("Confirmed", issue.getStateName());
		

		
	}
	
	/** Tests testUpdate method that throws an assertion*/
	@Test
	public void testUpdateFail() {
		ArrayList<String> notes = new ArrayList<>();
		Issue issue = new Issue(id, "New", "Bug", "summary", "mkpatil", false, "Duplicate", notes);
		assertEquals("New", issue.getStateName());
		
		Command c = new Command(CommandValue.RESOLVE, "mkpatil", Resolution.DUPLICATE, "note");
		issue.update(c);
		assertEquals("Closed", issue.getStateName());
		
		Command c2 = new Command(CommandValue.CONFIRM, "mkpatil", Resolution.DUPLICATE, "note2");
		assertThrows(UnsupportedOperationException.class, () -> issue.update(c2));
		
	}
	
	
	

}
