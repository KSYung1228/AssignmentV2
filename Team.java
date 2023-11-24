
/*
 * Team for assignment provided
 */
import java.util.*;

public abstract class Team {
    private String teamId;
    private String name;
    private Vector<Player> players;

    public Team(String teamID) {
        players = new Vector<>();
        this.teamId = teamID;
    }

    public String getTeamID() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Enumeration<Player> getAllPlayers() {
        return players.elements();
    }

    public abstract void updatePlayerPosition();

    public abstract void displayTeam();
}
