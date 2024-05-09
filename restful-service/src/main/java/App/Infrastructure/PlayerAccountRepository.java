package App.Infrastructure;

import App.Domain.IPlayerAccountRepository;
import App.Domain.PlayerAccount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PlayerAccountRepository implements IPlayerAccountRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public PlayerAccount create(PlayerAccount playerAccount) {
        return null;
    }

    @Override
    public int update(String id, PlayerAccount playerAccount) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public List<PlayerAccount> get(@PathVariable("id") String id) {
        String sql = "SELECT gi203242.PLAYER.ID, gi203242.PLAYER.[Name], gi203242.PLAYER.Email, gi203242.PLAYER_ACCOUNT.Balance\n"
                + "FROM PLAYER\n"
                + "INNER JOIN PLAYER_ACCOUNT ON PLAYER.ID = PLAYER_ACCOUNT.AccountID\n"
                + "WHERE AccountID = '" + id + "';";
        List<PlayerAccount> accounts = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(PlayerAccount.class));
        return accounts;
    }

    public List<PlayerAccount> get() {
        String sql = "SELECT * FROM gi203242.Player_Account ORDER BY AccountID ASC;";
        List<PlayerAccount> accounts = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(PlayerAccount.class));
        return accounts;
    }

    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
