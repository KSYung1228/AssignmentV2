
/*
 * Football team from assignment provided
 */
import java.util.*;

public class FootBallTeam extends Team {
    private final int GOALKEEPER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;
    private final int MIDFIELDER_POSITON = 3;
    private final int FORWARD_POSITION = 4;

    public FootBallTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {

    }

    public void displayTeam() {
        StringBuilder goalkeeper = new StringBuilder();
        StringBuilder defenders = new StringBuilder();
        StringBuilder midfielder = new StringBuilder();
        StringBuilder forward = new StringBuilder();

        Enumeration<Player> players = getAllPlayers();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            String playerInfo = player.getPlayerID() + ", " + player.getName() + "\n";
            if (player.getPosition() == GOALKEEPER_POSITION) {
                goalkeeper.append(playerInfo);
            } else if (player.getPosition() == DEFENDER_POSITION) {
                defenders.append(playerInfo);
            } else if (player.getPosition() == MIDFIELDER_POSITON) {
                midfielder.append(playerInfo);
            } else if (player.getPosition() == FORWARD_POSITION) {
                forward.append(playerInfo);
            }
        }

        System.out.println(getClass().toString().replace("class", "") + " " + getName() + " (" + getTeamID() + ") ");
        System.out.println("Goal Keeper:");
        if (goalkeeper.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(goalkeeper.toString());
        }
        System.out.println("Defender:");
        if (defenders.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(defenders.toString());
        }
        System.out.println("Midfielder:");
        if (midfielder.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(midfielder.toString());
        }
        System.out.println("Forward:");
        if (forward.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(forward.toString());
        }
    }

}
