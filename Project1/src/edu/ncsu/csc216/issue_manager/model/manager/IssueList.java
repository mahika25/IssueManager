/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * 
 */
public class IssueList {
	
	private int counter;
	
	public IssueList() {}
	
	public int addIssue (IssueType issueType, String summary, String note) {
		return 0;
	}
	
	public void addIssues(List<Issue> issues) {}
	
	private void addIssue(Issue issue) {}
	
	public List<Issue> getIssues(){
		return null;
	}
	
	public List<Issue> getIssuesByType(String type){
		return null;
	}
	
	public Issue getIssueById(int id){
		return null;
	}
	
	public void executeCommand(int id, Command command) {
		
	}
	
	public void deleteIssueById(int id) {
		
	}
	
	
	
	
	
}
