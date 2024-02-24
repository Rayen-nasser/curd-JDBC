import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initial Step: Connect with database
        Connection c = ConnectionManager.connect();

        int choice; // declare choice variable outside the loop

        do {
            Scanner choose = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("1. View All Steps");
            System.out.println("2. Insert A New Step");
            System.out.println("3. Delete Warn Step");
            System.out.println("4. Edit A Step");
            System.out.println("5. Quit");

            choice = choose.nextInt(); // assign user's choice to the choice variable

            switch (choice) {
                case 1:
                    Views.getAllStep(c);
                    break;
                case 2:
                    System.out.println("Please enter information to insert a new step:");
                    Scanner userInput = new Scanner(System.in);

                    System.out.println("Enter the title:");
                    String title = userInput.nextLine();

                    System.out.println("Enter the description:");
                    String description = userInput.nextLine();

                    System.out.println("Enter the example:");
                    String example = userInput.nextLine();

                    // You can include additional input validation or processing here if needed

                    Date date = new Date();
                    Step s = new Step(title, description, example, date);
                    Create.createStep(c, s);
                    break;
                case 3:
                    System.out.println("Please enter Id of a step:");
                    userInput = new Scanner(System.in);
                    int id = Integer.parseInt(userInput.nextLine());

                    Delete.deleteStep(c, id);
                    break;
                case 4:
                    userInput = new Scanner(System.in);

                    // Prompt user for step ID to edit
                    System.out.println("Enter the ID of the step you want to edit:");
                    id = userInput.nextInt();
                    userInput.nextLine(); // Consume newline

                    // Fetch the old version of the step
                    Step oldStep = ViewSingel.getStepById(c, id);
                    if (oldStep == null) {
                        // Step not found, return
                        return;
                    }

                    // Display old values to the user
                    System.out.println("Old Title: " + oldStep.getTitle());
                    System.out.println("Old Description: " + oldStep.getDescription());
                    System.out.println("Old Example: " + oldStep.getExample());

                    // Prompt user for new values
                    System.out.println("Enter the new title:");
                    String newTitle = userInput.nextLine();

                    System.out.println("Enter the new description:");
                    String newDescription = userInput.nextLine();

                    System.out.println("Enter the new example:");
                    String newExample = userInput.nextLine();

                    // Create a new Step object with the updated values
                    Step newStep = new Step(id, newTitle, newDescription, newExample, oldStep.getDate());

                    // Update the step in the database
                    Update.updateStep(c, newStep);
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
