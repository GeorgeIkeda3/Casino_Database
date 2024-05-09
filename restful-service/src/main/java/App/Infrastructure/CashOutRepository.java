package App.Infrastructure;

import App.Domain.CashOut;
import App.Domain.ICashOutRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CashOutRepository implements ICashOutRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public CashOut create(CashOut cashOut) {
        String sql = "INSERT INTO gi203242.CASH_OUT VALUES ('"
                + cashOut.getID() + "', '"
                + cashOut.getDate() + "', '"
                + cashOut.getAmount() + "', '"
                + cashOut.getPlayerID() + "');";
        this.databaseConnection.execute(sql);
        return cashOut;
    }

    @Override
    public int update(String id, CashOut cashOut) {
        String sql = "UPDATE gi203242.CASH_OUT SET ID = '" + cashOut.getID() + "',"
                + "Cash_Out_Date = '" + cashOut.getDate() + "',"
                + "Amount = '" + cashOut.getAmount() + "',"
                + "PlayerID = '" + cashOut.getPlayerID() + "' " +
                "WHERE ID = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM gi203242.CASH_OUT WHERE ID = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<CashOut> get(String playerID) {
        String sql = "SELECT * FROM gi203242.CASH_OUT WHERE PlayerID = '" + playerID + "';";
        List<CashOut> cash = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(CashOut.class));
        return cash;
    }

    @Override
    public List<CashOut> get() {
        String sql = "SELECT * FROM gi203242.CASH_OUT;";
        List<CashOut> cash = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(CashOut.class));
        return cash;
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
