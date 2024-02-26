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
	public enum CommandValue { 
		
		/** Command Value of Assign*/
		ASSIGN, 

		/** Command Value of Confirm*/
		CONFIRM, 
		
		/** Command Value of Resolve*/
		RESOLVE, 
		
		/** Command Value of Verify*/
		VERIFY, 
		
		/** Command Value of Reopen*/
		REOPEN 
		
	};
	
	/**
	 * Enumeration that contains the possible resolutions an issue could have
	 */
	public enum Resolution { 
		
		/** Resolution of fixed */
		FIXED, 
		
		/** Resolution of duplicate */
		DUPLICATE, 
		
		/** Resolution of wont fix */
		WONTFIX, 
		
		/** Resolution of works for me */
		WORKSFORME 
		
	};
	
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
	
	/** Command value associated with command*/
	private CommandValue c;
	
	/** Command value associated with command*/
	private Resolution resolution;
	
	
	/**
	 * Constructs the command object
	 * @param c value of the command
	 * @param ownerId id of the owner who owns the issue
	 * @param r resolution of the issue
	 * @param note note associated with command
	 * @throws IllegalArgumentException if invalid information is given
	 */
	public Command(CommandValue c, String ownerId, Resolution r, String note) {
		if((c == null) || (c == CommandValue.ASSIGN && ("".equals(ownerId) || ownerId == null)) || (c == CommandValue.RESOLVE && r == null) 
				|| ("".equals(note) || note == null)){
			throw new IllegalArgumentException("Invalid Information.");
		}
		
		this.c = c;
		this.ownerId = ownerId;
		this.resolution = r;
		this.note = note;
		
		
	}
	
	/**
	 * Gets the command value
	 * @return the command value
	 */
	public CommandValue getCommand() {
		return c;
	}
	
	/**
	 * Gets the owner id
	 * @return the owner id
	 */
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * Gets the resolution
	 * @return the resolution
	 */
	public Resolution getResolution() {
		return resolution;
	}
	
	
	/**
	 * Gets the note
	 * @return the note
	 */
	public String getNote() {
		return note;
	}



}
