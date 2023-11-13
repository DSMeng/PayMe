import java.util.ArrayList;
import java.util.List;

class Group {
    private String name;
    private String details;
    private List<String> members;

    public Group(String name, String details) {
        this.name = name;
        this.details = details;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMember(String user) {
        members.add(user);
    }

    public String toString() {
        return "Group Name: " + name + "\nGroup Details: " + details + "\nMembers: " + members;
    }
}

public class createGroup {
    private List<Group> groups;
    private String currentUser;

    public createGroup() {
        groups = new ArrayList<>();
        currentUser = null;
    }

    public void displayGroupList() {
        System.out.println("Group List:");
        for (Group group : groups) {
            System.out.println(group.getName());
        }
    }

    public void createGroup(String groupName, String groupDetails) {
        Group newGroup = new Group(groupName, groupDetails);
        if (currentUser != null) {
            newGroup.addMember(currentUser);
        }
        groups.add(newGroup);

        System.out.println("Group created successfully!");
        System.out.println(newGroup);

        if (currentUser != null) {
            newGroup.addMember(currentUser);
            System.out.println(currentUser + " has been added to the group.");
        }
    }

    public void setCurrentUser(String user) {
        currentUser = user;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
