import java.util.*;

public class TeamManager {
    private List<Team> teams;
    private Team currentTeam;

    public TeamManager() {
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void setCurrentTeam(String teamID) {
        for (Team team : this.teams) {
            if (team.getTeamID().equals(teamID)) {
                this.currentTeam = team;
                break;
            }
        }
    }

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    public void modifyPlayerPosition(String playerId, int newPosition) {
        if (currentTeam != null) {
            Enumeration<Player> players = currentTeam.getAllPlayers();
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPlayerID().equals(playerId)) {
                    player.setPosition(newPosition);
                    break;
                }
            }
        } else {
            System.out.println("No current team set");
        }
    }

    public void deletePlayer(String playerId) {
        if (currentTeam != null) {
            Enumeration<Player> players = currentTeam.getAllPlayers();
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPlayerID().equals(playerId)) {
                    currentTeam.removePlayer(player);
                    break;
                }
            }
        } else {
            System.out.println("No current team set");
        }
    }

    public void displayAllTeams() {
        for (Team team : teams) {
            System.out.println(team.getClass().getSimpleName() + " " + team.getName() + " (" + team.getTeamID() + ")");
        }
    }

    public void changeCurrentTeamName(String newName) {
        if (currentTeam != null) {
            currentTeam.setName(newName);
        } else {
            System.out.println("No current team set");
        }
    }
}