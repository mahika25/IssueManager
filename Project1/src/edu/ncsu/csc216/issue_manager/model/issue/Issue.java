/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;

/**
 * 
 */
public class Issue {
	
	public enum IssueType {ENHANCEMENT, BUG};
	
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
	
	private class NewState implements IssueState {
        
		private NewState() {}
		public void updateState(Command command) {}
		public String getStateName() {
			return null;
		}
		
    }
	
	private class WorkingState implements IssueState {
        
		private WorkingState() {}
		public void updateState(Command command) {}
		public String getStateName() {
			return null;
		}
		
    }
	
	private class ClosedState implements IssueState {
        
		private ClosedState() {}
		public void updateState(Command command) {}
		public String getStateName() {
			return null;
		}
		
    }

	private class VerifyingState implements IssueState {
	    
		private VerifyingState() {}
		public void updateState(Command command) {}
		public String getStateName() {
			return null;
		}
		
	}


	private class ConfirmedState implements IssueState {
	    
		private ConfirmedState() {}
		public void updateState(Command command) {}
		public String getStateName() {
			return null;
		}
		
	}
	
	public static final String I_ENHANCEMENT = "Enhancement";
	public static final String I_BUG = "Bug";
	
	private int issueId;
	private String summary;
	private String owner;
	private boolean confirmed;
	private ArrayList<String> notes;
	
	public static final String NEW_NAME = "New";
	public static final String WORKING_NAME = "Working";
	public static final String CONFIRMED_NAME = "Confirmed";
	public static final String VERIFYING_NAME = "Verifying";
	public static final String CLOSED_NAME = "Closed";
	
	public Issue(int id, IssueType issueType, String summary, String note){}
	public Issue(int id, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String> notes) {}
	
	
	private void setIssueId(int id) {}
	private void setState(String state) {}
	private void setIssueType(String type) {}
	private void setSummary(String summary) {}
	private void setOwner(String owner) {}
	private void setConfirmed(boolean confirmed) {}
	private void setResolution(String resolution) {}
	private void setNotes(ArrayList<String> notes) {}
	
	public int getIssueId() {
		return 0;
	}
	
	public String getStateName() {
		return null;
	}
	
	public String getIssueType() {
		return null;
	}
	
	public String getResolution() {
		return null;
	}
	
	public String getOwner() {
		return null;
	}
	
	public String getSummary() {
		return null;
	}
	
	public ArrayList<String> getNotes() {
		return null;
	}
	
	public String getNotesString() {
		return null;
	}
	
	public boolean isConfirmed() {
		return false;
	}
	
	public String toString() {
		return null;
	}
	
	private void addNote(String note) {
		
	}
	
	public void update(Command command) {
		
	}
	
	

}
