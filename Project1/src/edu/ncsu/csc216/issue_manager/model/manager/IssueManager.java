package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.io.IssueReader;
import edu.ncsu.csc216.issue_manager.model.io.IssueWriter;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Manages overall system
 * @author Mahika Patil
 */
public class IssueManager {
	
	/** Singleton instance */
    private static final IssueManager SINGLETON = new IssueManager();

    /** Reference to the current issue list */
    private IssueList issueList;
    
	/** Constructs the issue manager object */
	private IssueManager(){
		issueList = new IssueList();
	}
	
	/**
     * Gets the  instance of the IssueManager.
     * @return IssueManager instance.
     */
	public static IssueManager getInstance() {
		return SINGLETON;
	}
	
	/**
     * Saves the current issue list to a file
     * @param filename The name of the file to save to
     */

	public void saveIssuesToFile(String filename) {
		IssueWriter.writeIssuesToFile(filename, issueList.getIssues());
	}
	
	/**
     * Loads an issue list from a file
     * @param filename The name of the file to load from
     */
	public void loadIssuesFromFile(String filename) {
		IssueReader.readIssuesFromFile(filename);
	}
	
	/**
     * creates a new empty issue list
     */
	public void createNewIssueList() {
		issueList = new IssueList();
	}
	
	/**
     * gets the current issue list as a two-dimensional array
     * @return an array representation of the issue list
     */
	public Object[][] getIssueListAsArray() {
		List<Issue> givenList = issueList.getIssues();
		String[][] issueArray = new String[givenList.size()][4];
		
		for(int i = 0; i < givenList.size(); i++) {
			Issue curIssue = givenList.get(i);
			issueArray[i][0] = Integer.toString(curIssue.getIssueId());
			issueArray[i][1] = curIssue.getStateName();
			issueArray[i][2] = curIssue.getIssueType();
			issueArray[i][3] = curIssue.getSummary();	
		}
		
		return issueArray;
	}
	
	/**
     * gets the current issue list for a certain issue type as a two-dimensional array
     * @param type type of issue to get
     * @return an array representation for the issues of a certain type
     */
	public Object[][] getIssueListAsArrayByIssueType(String type) {
		List<Issue> givenList = issueList.getIssuesByType(type);
		String[][] issueArray = new String[givenList.size()][4];
		
		for(int i = 0; i < givenList.size(); i++) {
			Issue curIssue = givenList.get(i);
			issueArray[i][0] = Integer.toString(curIssue.getIssueId());
			issueArray[i][1] = curIssue.getStateName();
			issueArray[i][2] = curIssue.getIssueType();
			issueArray[i][3] = curIssue.getSummary();	
		}
		
		return issueArray;
	}
	
	/**
     * gets an issue by its id
     * @param id The id of the issue to get
     * @return The issue with the specified id
     */
	public Issue getIssueById(int id) {
		return issueList.getIssueById(id);
	}
	
	/**
	 * executes a command on a certain issue
	 * @param id id of issue to execute command on
	 * @param command command to execute
	 */
	public void executeCommand(int id, Command command) {
		List<Issue> givenList = issueList.getIssues();
		for(int i  = 0; i < givenList.size(); i++) {
			if(givenList.get(i).getIssueId() == id) {
				givenList.get(i).update(command);
			}
		}
		
	}
	
	/**
	 * deletes an issue
	 * @param id id of issue to delete
	 */
	public void deleteIssueById(int id) {
		
		issueList.deleteIssueById(id);
	}
	
	/** 
	 * Add issue to issue list
	 * @param issueType type of issue being added
	 * @param summary summary of issue to be added
	 * @param note note for issue to be added
	 */
	public void addIssueToList(IssueType issueType, String summary, String note) {
		
		issueList.addIssue(issueType, summary, note);
		
	}
	
	
}
