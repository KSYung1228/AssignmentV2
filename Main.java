import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 创建一个新的团队管理器
        TeamManager teamManager = new TeamManager();

        // 创建一个新的CommandFactory
        CommandFactory commandFactory = new CommandFactory(teamManager, sc);

        // 在一个循环中不断地获取用户的输入，并执行相应的命令
        while (true) {
            System.out.println("Sport Teams Management System (STMS)");
            System.out.println("c = create team, g = set current team, a = add player, m = modify player's" + //
                    "position, d = delete player, s = show team, p = display all teams, t = change" + //
                    "team's name, u = undo, r = redo, l = list undo/redo, x = exit system");
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