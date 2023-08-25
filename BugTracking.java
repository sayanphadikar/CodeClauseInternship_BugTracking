import java.util.*;

class Bug {
    private int id;
    private String description;
    private String status;

    public Bug(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Open";
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

public class BugTracking {
    private List<Bug> bugs;

    public BugTracking() {
        bugs = new ArrayList<>();
    }

    public void reportBug(String description) {
        int id = bugs.size() + 1;
        Bug bug = new Bug(id, description);
        bugs.add(bug);
        System.out.println("Bug reported successfully with ID: " + id);
    }

    public void viewBugs() {
        System.out.println("-------- List of Bugs --------");
        for (Bug bug : bugs) {
            System.out.println("Bug ID: " + bug.getId());
            System.out.println("Description: " + bug.getDescription());
            System.out.println("Status: " + bug.getStatus());
            System.out.println();
        }
    }

    public void changeBugStatus(int bugId, String newStatus) {
        Bug bug = findBugById(bugId);
        if (bug != null) {
            bug.setStatus(newStatus);
            System.out.println("Bug status updated successfully.");
        } else {
            System.out.println("Bug not found.");
        }
    }

    private Bug findBugById(int bugId) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugId) {
                return bug;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BugTracking bugSystem = new BugTracking();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------- Bug Tracking System --------");
            System.out.println("1. Report Bug");
            System.out.println("2. View Bugs");
            System.out.println("3. Change Bug Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter bug description: ");
                    scanner.nextLine(); // Consume newline
                    String description = scanner.nextLine();
                    bugSystem.reportBug(description);
                    break;

                case 2:
                    bugSystem.viewBugs();
                    break;

                case 3:
                    System.out.print("Enter bug ID: ");
                    int bugId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    bugSystem.changeBugStatus(bugId, newStatus);
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
