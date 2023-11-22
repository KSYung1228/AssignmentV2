import java.util.Scanner;

public class AddPlayerCommand implements Command, Memento {
    private Scanner sc;
    private TeamManager teamManager;
    private String input, playerID, playerName;
    private Player addedPlayer;
    private int position;
    Team currentTeam;

    public AddPlayerCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        try {
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
                position = sc.nextInt();
                sc.nextLine();

                addedPlayer = PlayerFactory.createPlayer(playerID, playerName);
                addedPlayer.setPosition(position);

                currentTeam.addPlayer(addedPlayer);
                System.out.println("Player is added.");
            } else {
                System.out.println("No current team. Can't add player.");
            }
            teamManager.pushCommand(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undo() {
        if (currentTeam != null) {
            currentTeam.removePlayer(addedPlayer);
        }
    }

    @Override
    public void redo() {
        if (currentTeam != null) {
            addedPlayer = PlayerFactory.createPlayer(playerID, playerName);
            addedPlayer.setPosition(position);
            currentTeam.addPlayer(addedPlayer);
        }
    }

    @Override
    public String getDescription() {
        return "Add player, " + playerID + ", " + playerName + ", " + getPositionDescription();
    }

    private String getPositionDescription() {
        String[] footballPositions = { "goal keeper", "defender", "midfielder", "forward" };
        String[] volleyballPositions = { "attacker", "defender" };

        if (currentTeam.getClass().getName().equals("FootBallTeam")) {
            return footballPositions[position - 1];
        } else if (currentTeam.getClass().getName().equals("VolleyballTeam")) {
            return volleyballPositions[position - 1];
        } else {
            return "unknown position";
        }
    }
}