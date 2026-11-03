import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database.createTable();

        while (true) {
            String buffer = "0";
            if (buffer == "0") {
                System.out.print("What do you want to do?: \n" + "add\n" + "edit\n" + "delete\n" + "show\n" + "exit\n");

                buffer = scanner.nextLine();
                if (buffer.trim().equalsIgnoreCase("add")) {

                    System.out.println("What should be the title of this note?: ");
                    String title = scanner.nextLine().trim();
                    System.out.println("Input note");
                    String body = scanner.nextLine();

                    Database.addNote(title, body);
                    Database.showNotes();
                } else if (buffer.trim().equalsIgnoreCase("edit")) {
                    Database.showNotes();
                    System.out.println("Which note you want to edit?: (id)");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What should be the new title of this note?: ");
                    String title = scanner.nextLine().trim();
                    System.out.println("Input new body of this note");
                    String body = scanner.nextLine();
                    Database.editNote(id, title, body);
                    Database.showNotes();
                } else if (buffer.trim().equalsIgnoreCase("delete")) {
                    Database.showNotes();
                    System.out.println("Which note you want to delete?: (id)(\"none\" to exit delete mode)");
                    String buffer1 = scanner.nextLine();
                    if (buffer1.equalsIgnoreCase("none")) {
                        break;
                    }
                    int id;
                    try {
                        id = Integer.parseInt(buffer1);
                    } catch (Exception e) {
                        System.out.println("It's not a valid ID");
                        continue;
                    }
                    Database.deleteNote(id);
                    Database.showNotes();
                } else if (buffer.trim().equalsIgnoreCase("show")) {
                    Database.showNotes();
                } else if (scanner.nextLine().equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("it isn't a valid operation!");
                }
            }

        }
    }
}


