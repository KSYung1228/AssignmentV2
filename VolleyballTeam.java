import java.util.*;

public class VolleyballTeam extends Team {
    private final int ATTACKER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;

    public VolleyballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
    }

    public void displayTeam() {
        StringBuilder attackers = new StringBuilder();
        StringBuilder defenders = new StringBuilder();

        Enumeration<Player> players = getAllPlayers();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            String playerInfo = player.getPlayerID() + ", " + player.getName() + "\n";
            if (player.getPosition() == ATTACKER_POSITION) {
                attackers.append(playerInfo);
            } else if (player.getPosition() == DEFENDER_POSITION) {
                defenders.append(playerInfo);
            }
        }

        System.out.println(getName() + "(" + getTeamID() + ")");
        System.out.println("Attacker:");
        if (attackers.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(attackers.toString());
        }
        System.out.println("Defender:");
        if (defenders.isEmpty()) {
            System.out.println("NIL");
        } else {
            System.out.print(defenders.toString());
        }
    }

}
