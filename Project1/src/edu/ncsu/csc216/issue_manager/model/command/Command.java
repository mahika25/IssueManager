/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.command;

/**
 * Contains information about a user command that can be applied to an issue
 * @author Mahika Patil
 */
public class Command {
	
	/**
	 * Enumeration that contains the possible commands a user could do 
	 */
	public enum CommandValue { ASSIGN, CONFIRM, RESOLVE, VERIFY, REOPEN };
	
	/**
	 * Enumeration that contains the possible resolutions an issue could have
	 */
	public enum Resolution { FIXED, DUPLICATE, WONTFIX, WORKSFORME };
	
	/**String for the fixed resolution*/
	public static final String R_FIXED = "Fixed";
	
	/**String for the duplicate resolution*/
	public static final String R_DUPLICATE = "Duplicate";
	
	/**String for the won't fix resolution*/
	public static final String R_WONTFIX = "WontFix";
	
	/**String for the works for me resolution*/
	public static final String R_WORKSFORME = "WorksForMe";
	
	/** The id of the owner of the issue associated with the command*/
	private String ownerId;
	
	/** Note associated with the command*/
	private String note;
	
	/**
	 * Constructs the command object
	 * @param c value of the command
	 * @param ownerId id of the owner who owns the issue
	 * @param r resolution of the issue
	 * @param note note associated with command
	 */
	public Command(CommandValue c, String ownerId, Resolution r, String note) {
		
	}
	
	/**
	 * Gets the command value
	 * @return the command value
	 */
	public CommandValue getCommand() {
		return null;
	}
	
	/**
	 * Gets the owner id
	 * @return the owner id
	 */
	public String getOwnerId() {
		return null;
	}
	
	/**
	 * Gets the resolution
	 * @return the resolution
	 */
	public Resolution getResolution() {
		return null;
	}
	
	
	/**
	 * Gets the note
	 * @return the note
	 */
	public String getNote() {
		return null;
	}



}
