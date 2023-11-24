
/* 
 *command to modify player position in current team 
 */
import java.util.*;

public class ModifyPlayerPositionCommand implements Command, Memento {
    private Scanner sc;
    private TeamManager teamManager;
    private String playerId;
    private int newPosition;
    private int oldPosition;
    Team currentTeam;

    // set the basic attribute
    public ModifyPlayerPositionCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    // action to modify player position
    @Override
    public void execute() {
        try {
            System.out.print("Please input player ID:-");
            playerId = sc.nextLine();
            currentTeam = teamManager.getCurrentTeam();
            if (currentTeam != null) {
                if (currentTeam.getClass().getName().equals("FootBallTeam")) {
                    System.out.print("Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):-");
                } else if (currentTeam.getClass().getName().equals("VolleyballTeam")) {
                    System.out.print("Position (1 = attacker | 2 = defender):-");
                }
                newPosition = sc.nextInt();
                sc.nextLine();

                // Save the player's old position
                oldPosition = teamManager.getPreviousPosition(playerId);
            }
            teamManager.modifyPlayerPosition(playerId, newPosition);
            teamManager.pushCommand(this);
            System.out.println("Position is updated.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // set the player position back
    @Override
    public void undo() {
        try {
            if (oldPosition != 0) {
                teamManager.modifyPlayerPosition(playerId, oldPosition);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // re-set the new position to player
    @Override
    public void redo() {
        try {
            teamManager.modifyPlayerPosition(playerId, newPosition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Modify player position, " + playerId + ", "
                + getPositionDescription(newPosition);
    }

    private String getPositionDescription(int position) {
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