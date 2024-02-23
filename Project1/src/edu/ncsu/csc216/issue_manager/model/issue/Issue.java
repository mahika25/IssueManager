/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;

/**
 * Represents and issue and all its information
 * @author Mahika Patil
 */
public class Issue {
	
	/** Enum that shows the possible types of issues */
	public enum IssueType { ENHANCEMENT, BUG };
	
	/**
	 * Interface for states in the Issue State Pattern.  All 
	 * concrete issue states must implement the IssueState interface.
	 * The IssueState interface should be a private interface of the 
	 * Issue class.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface IssueState {
		
		/**
		 * Update the Issue based on the given Command.
		 * An UnsupportedOperationException is throw if the Command
		 * is not a valid action for the given state.  
		 * @param command Command describing the action that will update the Issue's
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command command);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();

	}
	
	/**
	 * Represents the new state of the Issue Manager FSM
	 */
	private class NewState implements IssueState {
        
		/** Constructs the new state object */
		private NewState() { }
		
		/** Updates the state based on the command
		 * @param command to be executed on the issue
		 */
		public void updateState(Command command) {  }
	
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return null;
		}
		
    }
	
	/**
	 * Represents the working state of the Issue Manager FSM
	 */
	private class WorkingState implements IssueState {
        
		/** Constructs the working state object */
		private WorkingState() { }
		
		/** Updates the state based on the command
		 * @param command to be executed on the issue
		 */
		public void updateState(Command command) { }
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return null;
		}
		
    }
	
	/**
	 * Represents the closed state of the Issue Manager FSM
	 */
	private class ClosedState implements IssueState {
        
		/** Constructs the closed state object */
		private ClosedState() { }
		
		/** Updates the state based on the command
		 * @param command to be executed on the issue
		 */
		public void updateState(Command command) { }
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return null;
		}
		
    }

	/**
	 * Represents the verifying state of the Issue Manager FSM
	 */
	private class VerifyingState implements IssueState {
	    
		/** Constructs the verifying state object */
		private VerifyingState() { }
		
		/** Updates the state based on the command
		 * @param command to be executed on the issue
		 */
		public void updateState(Command command) { }
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return null;
		}
		
	}

	
	/**
	 * Represents the confirmed state of the Issue Manager FSM
	 */
	private class ConfirmedState implements IssueState {
	    
		/** Constructs the confirmed state object */
		private ConfirmedState() { }
		
		/** Updates the state based on the command
		 * @param command to be executed on the issue
		 */
		public void updateState(Command command) { }
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return null;
		}
		
	}
	
	/** String to represent enhancement issues */
	public static final String I_ENHANCEMENT = "Enhancement";
	
	/** String to represent bug issues */
	public static final String I_BUG = "Bug";
	
	/** Id of the issue */
	private int issueId;
	
	/** Summary of the issue */
	private String summary;
	
	/** Owner of the issue */
	private String owner;
	
	/** Whether the issue is confirmed or not  */
	private boolean confirmed;
	
	/** List of notes about the issue */
	private ArrayList<String> notes;
	
	/** String to represent new state */
	public static final String NEW_NAME = "New";
	
	/** String to represent working state */
	public static final String WORKING_NAME = "Working";
	
	/** String to represent confirmed state */
	public static final String CONFIRMED_NAME = "Confirmed";
	
	/** String to represent verifying state */
	public static final String VERIFYING_NAME = "Verifying";
	
	/** String to represent closed state */
	public static final String CLOSED_NAME = "Closed";
	
	/**
	 * Constructs an issue with some basic information
	 * @param id id of the issue
	 * @param issueType type of issue
	 * @param summary summary of the issue
	 * @param note note for the issue
	 */
	public Issue(int id, IssueType issueType, String summary, String note){ }
	
	/**
	 * Constructs an issue with some all the information
	 * @param id id of the issue
	 * @param state state of the issue
	 * @param issueType type of issue
	 * @param summary summary of the issue
	 * @param owner owner of the issue
	 * @param confirmed whether the issue is confirmed or not 
	 * @param resolution resolution of the issue
	 * @param notes list of notes associated with an issue
	 */
	public Issue(int id, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String> notes) { }
	
	/** sets the issue id 
	 * @param id id to set for the issue
	 */
	private void setIssueId(int id) { }
	
	/** sets the issue state 
	 * @param state state to set for the issue
	 */
	private void setState(String state) { }
	
	/** sets the issue type 
	 * @param type type to set for the issue
	 */
	private void setIssueType(String type) { }
	
	/** sets the issue summary 
	 * @param summary summary to set for the issue
	 */
	private void setSummary(String summary) { }
	
	/** sets the issue owner 
	 * @param owner owner to set for the issue
	 */
	private void setOwner(String owner) { }
	
	/** sets if the issue is confirmed or not 
	 * @param confirmed whether issue is confirmed or not
	 */
	private void setConfirmed(boolean confirmed) { }
	
	/** sets the issue resolution 
	 * @param resolution resolution to set for the issue
	 */
	private void setResolution(String resolution) { }
	
	/** sets the notes list for the issue
	 * @param notes notes to set for the issue
	 */
	private void setNotes(ArrayList<String> notes) { }
	
	/** gets the id of the issue
	 * @return id of the issue
	 */
	public int getIssueId() {
		return 0;
	}
	
	/** gets the state name of the issue
	 * @return state name of the issue
	 */
	public String getStateName() {
		return null;
	}
	
	
	/** gets the type of the issue
	 * @return type of the issue
	 */
	public String getIssueType() {
		return null;
	}
	
	/** gets the resolution of the issue
	 * @return resolution of the issue
	 */
	public String getResolution() {
		return null;
	}
	
	/** gets the owner of the issue
	 * @return owner of the issue
	 */
	public String getOwner() {
		return null;
	}
	
	/** gets the summary of the issue
	 * @return summary of the issue
	 */
	public String getSummary() {
		return null;
	}
	
	
	/** gets the notes for the issue
	 * @return notes of the issue
	 */
	public ArrayList<String> getNotes() {
		return null;
	}
	
	/** gets the notes in string form for the issue
	 * @return notes in string form of the issue
	 */
	public String getNotesString() {
		return null;
	}
	
	/** gets the confirmed boolean
	 * @return if the issue is confirmed or not
	 */
	public boolean isConfirmed() {
		return false;
	}
	
	/** converts issue to a string
	 * @return string form of issue object
	 */
	public String toString() {
		return null;
	}
	
	/** adds note to note list for issue
	 * @param note note to add
	 */
	private void addNote(String note) {
		
	}
	
	/** updates the command for the issue
	 * @param command command to update to
	 */
	public void update(Command command) {
		
	}
	
	

}
