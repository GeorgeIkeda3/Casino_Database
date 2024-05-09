package App.Infrastructure;

import App.Domain.CashIn;
import App.Domain.ICashInRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CashInRepository implements ICashInRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public CashIn create(CashIn cashIn) {
        String sql = "INSERT INTO gi203242.CASH_IN VALUES ('"
                + cashIn.getID() + "', '"
                + cashIn.getDate() + "', '"
                + cashIn.getAmount() + "', '"
                + cashIn.getPlayerID() + "');";
        this.databaseConnection.execute(sql);
        return cashIn;
    }

    @Override
    public int update(String id, CashIn cashIn) {
        String sql = "UPDATE gi203242.CASH_IN SET ID = '" + cashIn.getID() + "',"
                + "Cash_In_Date = '" + cashIn.getDate() + "',"
                + "Amount = '" + cashIn.getAmount() + "',"
                + "PlayerID = '" + cashIn.getPlayerID() + "' " +
                "WHERE ID = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM gi203242.CASH_IN WHERE ID = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<CashIn> get(String playerID) {
        String sql = "SELECT * FROM gi203242.CASH_IN WHERE PlayerID = '" + playerID + "';";
        List<CashIn> cash = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(CashIn.class));
        return cash;
    }

    @Override
    public List<CashIn> get() {
        String sql = "SELECT * FROM gi203242.CASH_IN;";
        List<CashIn> cash = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(CashIn.class));
        return cash;
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
