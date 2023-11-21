import java.util.Scanner;

public class AddPlayerCommand implements Command {
    private Scanner sc;
    private TeamManager teamManager;
    private String input, playerID, playerName;
    Team currentTeam;

    public AddPlayerCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        System.out.print("Please input player information (id, name):");
        input = sc.nextLine();
        String[] strArr = input.split(", ");
        playerID = strArr[0];
        playerName = strArr[1];

        currentTeam = teamManager.getCurrentTeam();
        if (currentTeam != null) {
            if (currentTeam.getClass().getName().equals("FootBallTeam")) {
                System.out.print("Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):-");
            } else if (currentTeam.getClass().getName().equals("VolleyballTeam")) {
                System.out.print("Position (1 = attacker | 2 = defender):-");
            }
            int position = sc.nextInt();
            sc.nextLine();

            Player newPlayer = PlayerFactory.createPlayer(playerID, playerName);
            newPlayer.setPosition(position);

            currentTeam.addPlayer(newPlayer);
        } else {
            System.out.println("No current team. Can't add player.");
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
