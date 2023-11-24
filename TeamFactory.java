/*
 * facotry to create team, use by command
 */
public class TeamFactory {

    public static Team createTeam(String teamId, String teamType) {

        if (teamType.equalsIgnoreCase("v")) {
            return new VolleyballTeam(teamId);
        } else if (teamType.equalsIgnoreCase("f")) {
            return new FootBallTeam(teamId);
        } else {
            return null;
        }

    }

}