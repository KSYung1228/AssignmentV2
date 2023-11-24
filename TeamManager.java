
/*
 * class to deal the action from command
 */
import java.util.*;

public class TeamManager {
    // attribute for system
    private List<Team> teams;
    private Team currentTeam;
    private final Caretaker caretaker = new Caretaker();
    private HashMap<String, Integer> previousPositions;

    public TeamManager() {
        this.teams = new ArrayList<>();
        previousPositions = new HashMap<>();
    }

    // check is the current set for start system
    public boolean checkTeamList() {
        if (teams != null && teams.contains(currentTeam)) {
            return true;
        }
        return false;
    }

    // deal the add team command feom CreateTeam Command
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

    // get the current team for different command use
    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    // deal the modify position command use
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

    // also for modify position use
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

    // for display all team command use
    public void displayAllTeams() {
        for (Team team : teams) {
            System.out.println(team.getClass().getSimpleName() + " " + team.getName() + " (" + team.getTeamID() + ")");
        }
    }

    // for change team name use, can help undo action in command
    public void getCurrentTeamName() {
        if (currentTeam != null) {
            currentTeam.getName();
        } else {
            System.out.println("No current team set");
        }
    }

    // for change team name use
    public void changeCurrentTeamName(String newName) {
        if (currentTeam != null) {
            currentTeam.setName(newName);
        } else {
            System.out.println("No current team set");
        }
    }

    // call caretaker undo action
    public void undo() {
        caretaker.undo();
    }

    // call caretaker redo action
    public void redo() {
        caretaker.redo();
    }

    // call caretaker undo list
    public void showUndoList() {
        caretaker.showUndoList();
    }

    // call caretaker redo list
    public void showRedoList() {
        caretaker.showRedoList();
    }

    // call caretaker history redo list, not to use in this
    // assignment(extrafunction)
    public void showHistoryRedoList() {
        caretaker.showHistoryRedoList();
    }

    // call caretaker history undo list, not to use in this
    // assignment(extrafunction)
    public void showHistoryUndoList() {
        caretaker.showHistoryUndoList();
    }

    // remove team for undo create team command use
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

    // get the player in team for command use
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

    // add player in command addplayer use
    public void addPlayer(Player player, String teamId) {
        for (Team team : teams) {
            if (team.getTeamID().equals(teamId)) {
                team.addPlayer(player);
                break;
            }
        }
    }

    // push the undostack from command to caretaker
    public void pushCommand(Memento command) {
        caretaker.pushCommand(command);
    }

    // show the current team for every times use the system
    public String showCurrentTeam() {
        return "The current team is " + currentTeam.getTeamID() + " " + currentTeam.getName();
    }

    // check is the teams exists, reduce the exception for modify the team, like
    // setcurrent tema
    public boolean teamExists(String teamID) {
        for (Team team : teams) {
            if (team.getTeamID().equals(teamID)) {
                return true;
            }
        }
        return false;
    }
}