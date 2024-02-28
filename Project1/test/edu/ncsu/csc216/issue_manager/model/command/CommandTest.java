package edu.ncsu.csc216.issue_manager.model.command;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;


/**
 * Class to test the Command class
 */
public class CommandTest {
	
	/** Test Command's command value. */
	private CommandValue commandVal = CommandValue.ASSIGN;
	/** Test Command's user. */
	private String user = "mkpatil";
	/** Test Command's resolution. */
	private Resolution r = Resolution.FIXED;
	/** Test Command's note. */
	private String note = "note";
	
	
	/** Tests the Command constructor for valid input*/
	@Test
	public void testCommandValid() {
		Command c = new Command(commandVal, user, r, note);
		assertEquals(commandVal, c.getCommand());
		assertEquals(user, c.getOwnerId());
		assertEquals(r, c.getResolution());
		assertEquals(note, c.getNote());
	}
	
	/** Tests the Command constructor for invalid input*/
	@Test
	public void testCommandInvalid() {
		Exception e1 = assertThrows(IllegalArgumentException.class,
		        () -> new Command(null, user, r, note));
		assertEquals("Invalid Information.", e1.getMessage());
		    
	    Exception e2 = assertThrows(IllegalArgumentException.class,
	            () -> new Command(commandVal, "", r, note));
	    assertEquals("Invalid Information.", e2.getMessage());
	    
	    Exception e3 = assertThrows(IllegalArgumentException.class,
	            () -> new Command(CommandValue.RESOLVE, user, null, note));
	    assertEquals("Invalid Information.", e3.getMessage());
	    
	    Exception e4 = assertThrows(IllegalArgumentException.class,
	            () -> new Command(CommandValue.ASSIGN, null, r, note));
	    assertEquals("Invalid Information.", e4.getMessage());
	}
	
	
	/** Tests the getCommand method */
	@Test
	public void testGetCommand() {
		Command c = new Command(commandVal, user, r, note);	
		assertEquals(commandVal, c.getCommand());
	}
	
	/** Tests the getOwnerId method */
	@Test
	public void testGetOwnerId() {
		Command c = new Command(commandVal, user, r, note);	
		assertEquals(user, c.getOwnerId());
	}
	
	/** Tests the getResolution method */
	@Test
	public void testGetResolution() {
		Command c = new Command(commandVal, user, r, note);
		assertEquals(r, c.getResolution());
	}
	
	/** Tests the getNote method */
	@Test
	public void testGetNote() {
		Command c = new Command(commandVal, user, r, note);
		assertEquals(note, c.getNote());
	}
	

}
