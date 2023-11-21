import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 创建一个新的团队管理器
        TeamManager teamManager = new TeamManager();

        // 创建一个新的CreateTeamCommand
        CreateTeamCommand createTeamCommand = new CreateTeamCommand(sc, teamManager);
        createTeamCommand.execute();

        // Set the current team
        SetCuttentTeamCommand setCurrentTeam = new SetCuttentTeamCommand(sc, teamManager);
        setCurrentTeam.execute();

        // 使用PlayerFactory创建球员并设置他们的位置
        Player player1 = PlayerFactory.createPlayer("P001", "John Doe");
        player1.setPosition(1); // goalkeeper
        Player player2 = PlayerFactory.createPlayer("P002", "Jane Doe");
        player2.setPosition(2); // defender
        Player player3 = PlayerFactory.createPlayer("P003", "Mike Smith");
        player3.setPosition(3); // midfielder
        Player player4 = PlayerFactory.createPlayer("P004", "Emma Jones");
        player4.setPosition(4); // forward

        // 将球员添加到球队中
        AddPlayerCommand add = new AddPlayerCommand(sc, teamManager);
        add.execute();
        // Modify a player's position in the current team
        // teamManager.modifyPlayerPosition("P001", 4);

        // 获取并显示当前团队
        Team currentTeam = teamManager.getCurrentTeam();
        if (currentTeam != null) {
            currentTeam.displayTeam();
        }

        // Delete a player from the current team
        teamManager.deletePlayer("P001");
        currentTeam.displayTeam();

        teamManager.displayAllTeams();

        teamManager.setCurrentTeam("V001");
        // Change the name of the current team
        teamManager.changeCurrentTeamName("New Team Name");
        teamManager.displayAllTeams();
    }
}