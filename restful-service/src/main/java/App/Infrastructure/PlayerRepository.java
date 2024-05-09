package App.Infrastructure;

import App.Domain.IPlayerRepository;
import App.Domain.Player;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PlayerRepository implements IPlayerRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public Player create(Player player) {
        String sql = "INSERT INTO gi203242.PLAYER VALUES ('"
                + player.getID() + "', '"
                + player.getName() + "', '"
                + player.getEmail() + "', '"
                + player.getDateOfBirth() + "');";
        this.databaseConnection.execute(sql);
        return player;
    }

    @Override
    public int update(String name, Player player) {
        String sql = "UPDATE gi203242.PLAYER SET ID = '"
                + player.getID() + "',"
                + "Name = '" + player.getName() + "',"
                + "Email = '" + player.getEmail() + "',"
                + "DateOfBirth = '" + player.getDateOfBirth() + "' "
                + "WHERE Name = '" + name + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM gi203242.PLAYER" +
                " WHERE ID = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    public List<Player> get(@PathVariable("id") String id) {
        String sql = "SELECT * FROM gi203242.PLAYER where ID = '" + id + "';";
        List<Player> players = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Player.class));
        return players;
    }

    public List<Player> get() {
        String sql = "SELECT * FROM gi203242.PLAYER;";
        List<Player> players = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Player.class));
        return players;
    }

    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
