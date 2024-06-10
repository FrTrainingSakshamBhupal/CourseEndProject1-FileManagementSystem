import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to lockedMe.com!!!");
        System.out.println("Developed by: Saksham Bhupal");

        //Initialising the application
        LockedApp app = new LockedApp();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Please select one of the following options: ");
            System.out.println("1. Display files in ascending order");
            System.out.println("2. Perform file operations");
            System.out.println("3. Exit the application");

            int option = sc.nextInt();

            switch(option) {
                case 1:
                    app.printSortedFiles();
                    break;
                case 2:
                    System.out.println("Please select one of the following options: ");
                    System.out.println("1. Add a file");
                    System.out.println("2. Delete a file");
                    System.out.println("3. Search for a file");
                    System.out.println("4. Go back to the main menu");

                    int inp = sc.nextInt();
                    String path;
                    switch(inp) {
                        case 1:
                            System.out.println("Enter the file name: ");
                            path = sc.next();
                            app.addFile(path);
                            break;
                        case 2:
                            System.out.println("Enter the file name: ");
                            path = sc.next();
                            app.deleteFile(path);
                            break;
                        case 3:
                            System.out.println("Enter the file name: ");
                            path = sc.next();
                            app.searchFile(path);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option selected. Please try again.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using lockedMe.com!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        }
        
    }
}
