class Assignment {
    private int id;
    private String name;
    private String status;

    public Assignment(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Assignment ID: " + id + ", Name: " + name + ", Status: " + status;
    }
}

class Node {
    Assignment assignment;
    Node next;

    public Node(Assignment assignment) {
        this.assignment = assignment;
        this.next = null;
    }
}

class AssignmentLinkedList {
    private Node head;

    public AssignmentLinkedList() {
        this.head = null;
    }

    // Add an assignment to the end of the list
    public void addAssignment(Assignment assignment) {
        Node newNode = new Node(assignment);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for an assignment by ID
    public Assignment searchAssignmentById(int id) {
        Node current = head;
        while (current != null) {
            if (current.assignment.getId() == id) {
                return current.assignment;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all assignments
    public void traverseAssignments() {
        Node current = head;
        while (current != null) {
            System.out.println(current.assignment);
            current = current.next;
        }
    }

    // Delete an assignment by ID
    public boolean deleteAssignmentById(int id) {
        if (head == null) return false;
        if (head.assignment.getId() == id) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.assignment.getId() != id) {
            current = current.next;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }
}

class TaskManagementSystem {
    public static void main(String[] args) {
        AssignmentLinkedList assignmentList = new AssignmentLinkedList();

        // Add new assignments
        assignmentList.addAssignment(new Assignment(1, "Design UI", "In Progress"));
        assignmentList.addAssignment(new Assignment(2, "Develop Backend", "Not Started"));
        assignmentList.addAssignment(new Assignment(3, "Write Tests", "Not Started"));
        assignmentList.addAssignment(new Assignment(4, "Deploy Application", "Completed"));

        // Traversing and printing assignments
        System.out.println("All assignments:");
        assignmentList.traverseAssignments();

        // Searching for an assignment by ID
        System.out.println("\nSearching for assignment with ID 3:");
        Assignment assignment = assignmentList.searchAssignmentById(3);
        if (assignment != null) {
            System.out.println("Found: " + assignment);
        } else {
            System.out.println("Assignment not found.");
        }

        // Deleting an assignment by ID
        System.out.println("\nDeleting assignment with ID 2:");
        boolean isDeleted = assignmentList.deleteAssignmentById(2);
        System.out.println("Deleted: " + isDeleted);

        // Traversing and printing assignments after deletion
        System.out.println("\nAll assignments after deletion:");
        assignmentList.traverseAssignments();
    }
}
