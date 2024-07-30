/*
Types of Linked Lists :-
----------------------
Singly Linked List :- Each node contains a data part and a reference (or link) to the next node in the sequence. It's a one-way traversal.

Doubly Linked List :- Each node contains a data part, a reference to the next node, and a reference to the previous node, 
                    allowing two-way traversal.

*/


public class exercise5 {

    public static class Task {
        private String taskId;
        private String taskName;
        private String status;
        private Task next;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        public String getTaskId() { 
            return taskId; 
        }
        public void setTaskId(String taskId) { 
            this.taskId = taskId; 
        }
        public String getTaskName() { 
            return taskName; 
        }
        public void setTaskName(String taskName) { 
            this.taskName = taskName; 
        }
        public String getStatus() { 
            return status; 
        }
        public void setStatus(String status) { 
            this.status = status; 
        }
        public Task getNext() { 
            return next; 
        }
        public void setNext(Task next) { 
            this.next = next; 
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
        }
    }

    private Task head;

    public exercise5() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equals(taskId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.getTaskId().equals(taskId)) {
            head = head.getNext();
            return true;
        }

        Task current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTaskId().equals(taskId)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        exercise5 taskManagementSystem = new exercise5();

        Task task1 = new Task("1", "Design Database", "Pending");
        Task task2 = new Task("2", "Develop API", "In Progress");
        Task task3 = new Task("3", "Test Application", "Pending");

        taskManagementSystem.addTask(task1);
        taskManagementSystem.addTask(task2);
        taskManagementSystem.addTask(task3);

        System.out.println("All Tasks:");
        taskManagementSystem.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task foundTask = taskManagementSystem.searchTask("2");
        if (foundTask != null) {
            System.out.println(foundTask);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 2:");
        boolean isDeleted = taskManagementSystem.deleteTask("2");
        if (isDeleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nAll Tasks after deletion:");
        taskManagementSystem.traverseTasks();
    }
}




/*
output :

All Tasks:
Task ID: 1, Task Name: Design Database, Status: Pending
Task ID: 2, Task Name: Develop API, Status: In Progress
Task ID: 3, Task Name: Test Application, Status: Pending

Searching for Task with ID 2:
Task ID: 2, Task Name: Develop API, Status: In Progress

Deleting Task with ID 2:
Task deleted successfully.

All Tasks after deletion:
Task ID: 1, Task Name: Design Database, Status: Pending
Task ID: 3, Task Name: Test Application, Status: Pending

*/



/*

Time Complexity :-
---------------
Add: O(n) 
Search: O(n)
Traverse: O(n)
Delete: O(n) 

Advantages of Linked Lists over Arrays for Dynamic Data :-
-------------------------------------------------------
Dynamic Size: Linked lists can grow and shrink dynamically without the need for resizing.

Efficient Insertions/Deletions: Insertions and deletions are more efficient compared to arrays, 
                                especially when they occur at the beginning or middle of the list,
                                 as linked lists do not require shifting elements.

*/


