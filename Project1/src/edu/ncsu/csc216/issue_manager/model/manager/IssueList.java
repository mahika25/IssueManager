/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Class to manage a list of issues 
 * @author Mahika Patil
 */
public class IssueList {
	
	/** Counter to generate issue Id */
	private int counter;
	
	/** Constructs the IssueList object */
	public IssueList() { }
	
	/** 
	 * Add issue to issue list
	 * @param issueType type of issue being added
	 * @param summary summary of issue to be added
	 * @param note note for issue to be added
	 * @return the issue id
	 */
	public int addIssue (IssueType issueType, String summary, String note) {
		return 0;
	}
	
	/**
	 * Add multiple issues to a list
	 * @param issues issues to be added
	 */
	public void addIssues(List<Issue> issues) { }
	
	/**
	 * Add existing issue 
	 * @param issue issue to be added
	 */
	private void addIssue(Issue issue) { }
	
	/**
	 * Get list of issues
	 * @return list of all issues
	 */
	public List<Issue> getIssues(){
		return null;
	}
	
	/**
	 * Get list of issues of a certain type
	 * @param type of issues to get
	 * @return list of all issues
	 */
	public List<Issue> getIssuesByType(String type){
		return null;
	}
	
	/**
	 * Get an issue by its id
	 * @param id id to get
	 * @return issue of the specified id
	 */
	public Issue getIssueById(int id){
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
	
	
	
	
	
}
