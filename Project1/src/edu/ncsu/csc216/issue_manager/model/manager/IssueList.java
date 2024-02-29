/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;
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
	
	/** List to store issues */
    private List<Issue> issues;
	
	/** Constructs the IssueList object */
	public IssueList() {
		this.counter = 1;
		this.issues = new ArrayList<>();
	}
	
	/** 
	 * Add issue to issue list
	 * @param issueType type of issue being added
	 * @param summary summary of issue to be added
	 * @param note note for issue to be added
	 * @return the issue id
	 */
	public int addIssue (IssueType issueType, String summary, String note) {
		if(!issues.isEmpty()) {
			Issue lastIssue = issues.get(issues.size() - 1);
			int maxId = lastIssue.getIssueId();
			counter = maxId + 1;
		}
		
		else {
			counter = 1;
		}
		
		Issue issue = new Issue(counter, issueType, summary, note);
		addIssue(issue);
		return issue.getIssueId();
	}
	
	/**
	 * Add multiple issues to a list
	 * @param issues issues to be added
	 */
	public void addIssues(List<Issue> issues) {
		
		for(int i = 0; i < issues.size(); i++) {
			addIssue(issues.get(i));
		}
	}
	
	/**
	 * Add existing issue 
	 * @param issue issue to be added
	 */
	private void addIssue(Issue issue) {
		
		for(int j = 0; j < issues.size(); j++) {
			if(issues.get(j).getIssueId() == issue.getIssueId()) {
				return;
			}		
		}
		
		int index = 0;
		for(int i = 0; i < issues.size(); i++) {
			if(issues.get(i).getIssueId() > issue.getIssueId()) {
				break;
			}
			
			index++;
		}
		
		issues.add(index, issue);
	}
	
	/**
	 * Get list of issues
	 * @return list of all issues
	 */
	public List<Issue> getIssues(){
		return issues;
	}
	
	/**
	 * Get list of issues of a certain type
	 * @param type of issues to get
	 * @return list of all issues
	 */
	public List<Issue> getIssuesByType(String type){
		ArrayList<Issue> typeList = new ArrayList<>();
		for(int i = 0; i < issues.size(); i++) {
			if(issues.get(i).getIssueType().equals(type)) {
				typeList.add(issues.get(i));
			}
		}
		
		return typeList;
	}
	
	/**
	 * Get an issue by its id
	 * @param id id to get
	 * @return issue of the specified id
	 */
	public Issue getIssueById(int id){
		
		for(int i = 0; i < issues.size(); i++) {
			if(issues.get(i).getIssueId() == id) {
				return issues.get(i);
			}
		}
		return null;
	}
	
	/**
	 * executes a command on a certain issue
	 * @param id id of issue to execute command on
	 * @param command command to execute
	 */
	public void executeCommand(int id, Command command) {
		for(int i = 0; i < issues.size(); i++) {
			if(issues.get(i).getIssueId() == id) {
				issues.get(i).update(command);
			}
		}
		
	}
	
	/**
	 * deletes an issue
	 * @param id id of issue to delete
	 */
	public void deleteIssueById(int id) {
		
		for(int i = 0; i < issues.size(); i++) {
			if(issues.get(i).getIssueId() == id) {
				issues.remove(i);
			}
		}
		
	}
	

	
	
}
