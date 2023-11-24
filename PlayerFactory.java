/*
 * Factory for create player, can let command call
 */
public class PlayerFactory {
    public static Player createPlayer(String id, String name) {
        return new Player(id, name);
    }
}
