import java.util.*;

public class TeamManager {
    private List<Team> teams;
    private Team currentTeam;
    private final Caretaker caretaker = new Caretaker();
    private HashMap<String, Integer> previousPositions;

    public TeamManager() {
        this.teams = new ArrayList<>();
        previousPositions = new HashMap<>();
    }

    public boolean checkTeamList() {
        if (teams != null && teams.contains(currentTeam)) {
            return true;
        }
        return false;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
        setCurrentTeam(team.getTeamID());
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
        Player player = getPlayer(playerId);
        if (player != null) {
            // Save the old position
            int oldPosition = player.getPosition();
            previousPositions.put(playerId, oldPosition);

            // Modify the position
            player.setPosition(newPosition);
        }
    }

    public int getPreviousPosition(String playerId) {
        return previousPositions.getOrDefault(playerId, 0);
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

    public void getCurrentTeamName() {
        if (currentTeam != null) {
            currentTeam.getName();
        } else {
            System.out.println("No current team set");
        }
    }

    public void changeCurrentTeamName(String newName) {
        if (currentTeam != null) {
            currentTeam.setName(newName);
        } else {
            System.out.println("No current team set");
        }
    }

    public void undo() {
        caretaker.undo();
    }

    public void redo() {
        caretaker.redo();
    }

    public void showUndoList() {
        caretaker.showUndoList();
    }

    public void showRedoList() {
        caretaker.showRedoList();
    }

    public void showHistoryRedoList() {
        caretaker.showHistoryRedoList();
    }

    public void showHistoryUndoList() {
        caretaker.showHistoryUndoList();
    }

    public void removeTeam(Team team) {
        teams.remove(team);
        if (team.equals(currentTeam)) {
            if (teams.isEmpty()) {
                currentTeam = null;
            } else {
                currentTeam = teams.get(0);
            }
        }
    }

    public Player getPlayer(String playerId) {
        for (Team team : teams) {
            Enumeration<Player> players = team.getAllPlayers();
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPlayerID().equals(playerId)) {
                    return player;
                }
            }
        }
        return null;
    }

    public void addPlayer(Player player, String teamId) {
        for (Team team : teams) {
            if (team.getTeamID().equals(teamId)) {
                team.addPlayer(player);
                break;
            }
        }
    }

    public void pushCommand(Memento command) {
        caretaker.pushCommand(command);
    }

    public String showCurrentTeam() {
        return "The current team is " + currentTeam.getTeamID() + " " + currentTeam.getName();
    }
}