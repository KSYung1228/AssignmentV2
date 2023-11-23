
/**
 *ITP4507 Contemporary Topics in Software Engineering
 *@author Yung Kai Sen 220069930
 *@version  java 21.0.1 2023-10-17 LTS
 */
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create TeamManager
        TeamManager teamManager = new TeamManager();

        // Create CommandFactory
        CommandFactory commandFactory = new CommandFactory(teamManager, sc);

        // Get input in while-Loop
        while (true) {
            System.out.println("Sport Teams Management System (STMS)");
            System.out.println("c = create team, g = set current team, a = add player, m = modify player's" + //
                    "position, d = delete player, s = show team, p = display all teams, t = change" + //
                    "team's name, u = undo, r = redo, l = list undo/redo, x = exit system");
            // check the current team is setted or not for start loop, if yes, print current
            // team
            if (teamManager.checkTeamList()) {
                System.out.println(teamManager.showCurrentTeam());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String commandType = sc.nextLine();

            // Base the user input to create command
            Command command = commandFactory.createCommand(commandType);

            // if command != null , execute the command
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid command");
            }
        }

    }
}