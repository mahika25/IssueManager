/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;

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
		public void updateState(Command command) {
			String note = command.getNote();
			if("".equals(note) || note == null) {
				throw new IllegalArgumentException("Invalid information.");
			}
			switch(command.getCommand()) {
				case ASSIGN:
					if(issueType.equals(IssueType.ENHANCEMENT)) {
						String ownerId = command.getOwnerId();
						
						if("".equals(ownerId) ||  ownerId == null) {
							throw new IllegalArgumentException("Invalid information.");
						}
						
						setOwner(ownerId);
						state = workingState;
						addNote(note);
						
					}
					
					
					break;
					
					
				case CONFIRM:
					if(issueType == IssueType.BUG) {
						state = confirmedState;
						setConfirmed(true);
						addNote(note);

					}
					
					
					break;
					
				
				case RESOLVE:
					Resolution r = command.getResolution();
					if(issueType == IssueType.ENHANCEMENT && r.equals(Resolution.WORKSFORME)
							|| r.equals(Resolution.FIXED)) {
						throw new UnsupportedOperationException("Invalid information.");
					}
					resolution = r;
					state = closedState;
					addNote(note);
					break;	
				
				default:
					throw new UnsupportedOperationException("Invalid information.");
				
				
			}
		}
	
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return NEW_NAME;
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
		public void updateState(Command command) {
			Resolution r = command.getResolution();
			String note = command.getNote();
			if("".equals(note) || note == null) {
				throw new IllegalArgumentException("Invalid information.");
			}
			
			switch(command.getCommand()) {
				case RESOLVE:
					if(r.equals(Resolution.FIXED)) {
						resolution = r;
						state = verifyingState;
						addNote(note);
					}
					
					else {
						if(issueType == IssueType.ENHANCEMENT && r.equals(Resolution.WORKSFORME)) {
							throw new UnsupportedOperationException("Invalid information.");
						}
						
						resolution = r;
						state = closedState;
						addNote(note);
					}
					break;
					
				default:
					throw new UnsupportedOperationException("Invalid information.");
			}
		}
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return WORKING_NAME;
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
		public void updateState(Command command) {
			String note = command.getNote();
			if("".equals(note) || note == null) {
				throw new IllegalArgumentException("Invalid information.");
			}
			
			switch(command.getCommand()) {
				case REOPEN:
					if(issueType.equals(IssueType.ENHANCEMENT)) {
						if(owner != null && !"".equals(owner)) {
							state = workingState;
							addNote(note);
						}
						
						else {
							state = newState;
							addNote(note);
						}
					}
					
					else {
						if(owner != null && !"".equals(owner)) {
							if(confirmed) {
								state = workingState;
								addNote(note);
							}
							else {
								state = confirmedState;
								addNote(note);
							}
						}
						
						else {
							state = newState;
							addNote(note);
						}
					}
					break;
					
				default:
					throw new UnsupportedOperationException("Invalid information.");
			}
		}
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return CLOSED_NAME;
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
		public void updateState(Command command) {
			
			String note = command.getNote();
			if("".equals(note) || note == null) {
				throw new IllegalArgumentException("Invalid information.");
			}
			
			switch(command.getCommand()) {
			
				case VERIFY:
					state = closedState;
					addNote(note);
					break;
					
				case REOPEN:
					state = workingState;
					addNote(note);
					break;
					
				default:
					throw new UnsupportedOperationException("Invalid information.");
			}
		}
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return VERIFYING_NAME;
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
		public void updateState(Command command) {
			Resolution r = command.getResolution();
			String note = command.getNote();
			if("".equals(note) || note == null) {
				throw new IllegalArgumentException("Invalid information.");
			}
			
			switch(command.getCommand()) {
		
			case ASSIGN:
					String ownerId = command.getOwnerId();
					
					if("".equals(ownerId) || ownerId == null) {
						throw new IllegalArgumentException("Invalid information.");
					}
					
					setOwner(ownerId);
					state = workingState;
					addNote(note);
					break;
					
			case RESOLVE:
				if(r.equals(Resolution.WONTFIX)) {
					resolution = r;
					state = closedState;
					addNote(note);
				}
				
				if(r.equals(Resolution.WORKSFORME) && issueType.equals(IssueType.BUG)) {
					throw new UnsupportedOperationException("Invalid information.");
				}
				break;
				
			default:
				throw new UnsupportedOperationException("Invalid information.");
				
			}	

			
			
		}
		
		/** gets the name of the state
		 * @return the name of the state
		 */
		public String getStateName() {
			return CONFIRMED_NAME;
		}
		
	}
	
	/** String to represent enhancement issues */
	public static final String I_ENHANCEMENT = "Enhancement";
	
	/** String to represent bug issues */
	public static final String I_BUG = "Bug";
	
	/** Id of the issue */
	private int issueId;
	
	/** State of the issue */
	private IssueState state;
	
	/** Type of the issue */
	private IssueType issueType;
	
	/** Summary of the issue */
	private String summary;
	
	/** Owner of the issue */
	private String owner;
	
	/** Whether the issue is confirmed or not  */
	private boolean confirmed;
	
	/** Resolution of the issue */
	private Resolution resolution;
	
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
	
	/** Instance of the New State */
	private final IssueState newState = new NewState();
	
	/** Instance of the Working State */
    private final IssueState workingState = new WorkingState();
    
    /** Instance of the Confirmed State */
    private final IssueState confirmedState = new ConfirmedState();
    
    /** Instance of the Verifying State */
    private final IssueState verifyingState = new VerifyingState();
    
    /** Instance of the Closed State */
    private final IssueState closedState = new ClosedState();

	
	
	/**
	 * Constructs an issue with some basic information
	 * @param id id of the issue
	 * @param issueType type of issue
	 * @param summary summary of the issue
	 * @param note note for the issue
	 */
	public Issue(int id, IssueType issueType, String summary, String note){
		
		if (issueType == null || summary == null || "".equals(summary) || note == null || "".equals(note)) {
			throw new IllegalArgumentException("Issue cannot be created."); 
		}
		
		setIssueId(id);
		this.state = newState;
		this.issueType = issueType;
		this.summary = summary;
		this.owner = null;
		this.confirmed = false;
		this.resolution = null;
		this.notes = new ArrayList<String>();
		addNote(note);
			
	}
	
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
	public Issue(int id, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String> notes) {
		setIssueId(id);
		setState(state);
		setIssueType(issueType);
		setSummary(summary);
		setOwner(owner);
		setConfirmed(confirmed);
		setResolution(resolution);
		setNotes(notes);
		
	}
	
	/** sets the issue id 
	 * @param id id to set for the issue
	 * @throws Illegal Argument Exception if id is less than 1
	 */
	private void setIssueId(int id) { 
		if(id < 1) {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		
		this.issueId = id;
	}
	
	/** sets the issue state 
	 * @param state state to set for the issue
	 * @throws IllegalArgumentException if invalid string is given
	 */
	private void setState(String state) { 
		switch(state) {
			case NEW_NAME:
				this.state = newState;
				break;
			case WORKING_NAME:
				this.state = workingState;
				break;
			case CONFIRMED_NAME:
				this.state = confirmedState;
				break;
			case VERIFYING_NAME:
				this.state = verifyingState;
				break;
			case CLOSED_NAME:
				this.state = closedState;
				break;
			default:
				throw new IllegalArgumentException("Issue cannot be created");
		}
	}
	
	/** sets the issue type 
	 * @param type type to set for the issue
	 * @throws IllegalArgumentException if invalid string is given
	 */
	private void setIssueType(String type) {
		if(type.equals(I_ENHANCEMENT)) {
			this.issueType = IssueType.ENHANCEMENT;
		}
		
		else if(type.equals(I_BUG)) {
			this.issueType = IssueType.BUG;
		}
		
		else {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
	}
	
	/** sets the issue summary 
	 * @param summary summary to set for the issue
	 * @throws IllegalArgumentException if invalid string is given
	 */
	private void setSummary(String summary) {
		if("".equals(summary) || summary == null) {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		
		this.summary = summary;
	}
	
	/** sets the issue owner 
	 * @param owner owner to set for the issue
	 */
	private void setOwner(String owner) {
		if("".equals(owner)) {
			this.owner = null;
		}
		
		else {
			this.owner = owner;
		}
		
	}
	
	/** sets if the issue is confirmed or not 
	 * @param confirmed whether issue is confirmed or not
	 */
	private void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	/** sets the issue resolution 
	 * @param resolution resolution to set for the issue
	 */
	private void setResolution(String resolution) {
		
		if(resolution.equals(Command.R_FIXED)) {
			this.resolution = Resolution.FIXED;
		}
		
		if(resolution.equals(Command.R_DUPLICATE)) {
			this.resolution = Resolution.DUPLICATE;
		}
		
		if(resolution.equals(Command.R_WONTFIX)) {
			this.resolution = Resolution.WONTFIX;
		}
		
		if(resolution.equals(Command.R_WORKSFORME)) {
			this.resolution = Resolution.WORKSFORME;
		}
		

	}
		
		
	
	/** sets the notes list for the issue
	 * @param notes notes to set for the issue
	 */
	private void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	
	/** gets the id of the issue
	 * @return id of the issue
	 */
	public int getIssueId() {
		return issueId;
	}
	
	/** gets the state name of the issue
	 * @return state name of the issue
	 */
	public String getStateName() {
		
		return state.getStateName();
		
	}
	
	
	/** gets the type of the issue
	 * @return type of the issue
	 */
	public String getIssueType() {
		if(issueType.equals(IssueType.ENHANCEMENT)) {
			return I_ENHANCEMENT;
		}
		
		else {
			return I_BUG;
		}
		
	}
	
	/** gets the resolution of the issue
	 * @return resolution of the issue
	 */
	public String getResolution() {
		if(resolution == null) {
			return null;
		}
		switch(resolution) {
			case FIXED:
				return Command.R_FIXED;
		case DUPLICATE:
				return Command.R_DUPLICATE;
		case WONTFIX:
				return Command.R_WONTFIX;
		case WORKSFORME:
				return Command.R_WORKSFORME;
			default:
				return null;
		}
	}
	
	/** gets the owner of the issue
	 * @return owner of the issue
	 */
	public String getOwner() {
		return owner;
	}
	
	/** gets the summary of the issue
	 * @return summary of the issue
	 */
	public String getSummary() {
		return summary;
	}
	
	
	/** gets the notes for the issue
	 * @return notes of the issue
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	
	/** gets the notes in string form for the issue
	 * @return notes in string form of the issue
	 */
	public String getNotesString() {
		String notesString = "";
		for(int i = 0; i < notes.size(); i++) {
			notesString += "-" + notes.get(i) + "\n";	
		}
		
		return notesString;
	}
	
	/** gets the confirmed boolean
	 * @return if the issue is confirmed or not
	 */
	public boolean isConfirmed() {
		return confirmed;
	}
	
	/** converts issue to a string
	 * @return string form of issue object
	 */
	public String toString() {
		String issueString = "";
		if(owner == null) {
			owner = "";
		}
		issueString += "*" + issueId + "," + getStateName() + "," + getIssueType() + ","
				+ summary + "," + owner + "," + confirmed + ",";
		
		if(resolution != null) {
			issueString += getResolution();
		}
		
		issueString += '\n';
		issueString += getNotesString();
		return issueString;
		
		
	}
	
	/** adds note to note list for issue
	 * @param note note to add
	 */
	private void addNote(String note) {
		if (note != null && !("".equals(note))) {
            notes.add("[" + getStateName() + "] " + note);
        }
		
	}
	
	/** updates the command for the issue
	 * @param command command to update to
	 */
	public void update(Command command) {
		state.updateState(command);
	}
	
	

}
