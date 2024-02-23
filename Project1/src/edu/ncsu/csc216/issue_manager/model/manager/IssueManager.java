package edu.ncsu.csc216.issue_manager.model.manager;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Manages overall system
 * @author Mahika Patil
 */
public class IssueManager {
	
	/** Constructs the issue manager object */
	private IssueManager(){ }
	
	/**
     * Gets the  instance of the IssueManager.
     * @return IssueManager instance.
     */
	public static IssueManager getInstance() {
		return null;
	}
	
	/**
     * Saves the current issue list to a file
     * @param filename The name of the file to save to
     */

	public void saveIssuesToFile(String filename) {
		
	}
	
	/**
     * Loads an issue list from a file
     * @param filename The name of the file to load from
     */
	public void loadIssuesFromFile(String filename) {
			
	}
	
	/**
     * creates a new empty issue list
     */
	public void createNewIssueList() {
		
	}
	
	/**
     * gets the current issue list as a two-dimensional array
     * @return an array representation of the issue list
     */
	public Object[][] getIssueListAsArray() {
		return null;
	}
	
	/**
     * gets the current issue list for a certain issue type as a two-dimensional array
     * @param type type of issue to get
     * @return an array representation for the issues of a certain type
     */
	public Object[][] getIssueListAsArrayByIssueType(String type) {
		return null;
	}
	
	/**
     * gets an issue by its id
     * @param id The id of the issue to get
     * @return The issue with the specified id
     */
	public Issue getIssueById(int id) {
		return null;
	}
	
	/**
	 * executes a command on a certain issue
	 * @param id id of issue to execute command on
	 * @param command command to execute
	 */
	public void executeCommand(int id, Command command) {
		
	}
	
	/**
	 * deletes an issue
	 * @param id id of issue to delete
	 */
	public void deleteIssueById(int id) {
		
	}
	
	/** 
	 * Add issue to issue list
	 * @param issueType type of issue being added
	 * @param summary summary of issue to be added
	 * @param note note for issue to be added
	 */
	public void addIssueToList(IssueType issueType, String summary, String note) {
		
	}
	
	
}
