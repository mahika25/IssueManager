# Overview
The Issue Management System is a tool designed to help teams track and manage issues effectively throughout their lifecycle. With an organized workflow, issues can be assigned, updated, verified, and closed, allowing for smoother project management and accountability.

## Key Features
Multi-State Issue Tracking
Issues progress through various states — New, Working, Verifying, Confirmed, and Closed — to provide better tracking and accountability at each stage.

- Categorization of Issues:
Supports different types of issues, such as bugs and enhancements, making it easy to filter and prioritize based on project needs.

- Detailed Issue Management:
Each issue includes an ID, type, summary, resolution, owner, and confirmation status for comprehensive tracking.

- Centralized Management:
A central IssueManager class handles the creation, storage, and retrieval of issues, allowing for easy management of all issues in one place.

- File Persistence:
Load and save issues to/from files for easy data persistence, making the system suitable for long-term project tracking.

- Graphical User Interface (GUI):
An optional GUI provides a user-friendly interface, making it simple for non-technical users to interact with and manage issues visually.

## How It Works
1. Create and Track Issues: Start by creating new issues, which enter the system in the "New" state.
  
2. State Transitions: Move issues through states as they are worked on, verified, and eventually closed. Each state defines what actions can be performed on the issue, aligning with the project’s workflow.
  
3. Categorization: View all issues or filter by type (e.g., bugs, enhancements) for focused work.
 
4. Save and Load Issues: Save the current list of issues to a file for future reference, or load an existing file to continue working with saved issues.

