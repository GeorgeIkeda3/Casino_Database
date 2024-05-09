package App.Infrastructure;

import App.Domain.ITransactionRepository;
import App.Domain.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TransactionRepository implements ITransactionRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public Transaction create(Transaction transaction) {
        String sql = "INSERT INTO gi203242.TRANS VALUES ('"
                + transaction.getID() + "', '"
                + transaction.getDate() + "', '"
                + transaction.getPlayerID() + "', '"
                + transaction.getAmount() + "', '"
                + transaction.getMethod() + "');";
        this.databaseConnection.execute(sql);
        return transaction;
    }

    @Override
    public int update(String id, Transaction transaction) {
        String sql = "UPDATE gi203242.TRANS SET ID = '" + transaction.getID() + "',"
                + "[Date] = '" + transaction.getDate() + "', "
                + "PlayerID = '" + transaction.getPlayerID() + "', "
                + "Amount = '" + transaction.getAmount() + "', "
                + "Method = '" + transaction.getMethod() + "' " +
                "WHERE ID = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM gi203242.TRANS WHERE ID = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Transaction> get(String playerID) {
        String sql = "SELECT * FROM gi203242.TRANS WHERE PlayerID = '" + playerID + "'";
        List<Transaction> trans = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Transaction.class));
        return trans;
    }

    @Override
    public List<Transaction> get() {
        String sql = "SELECT * FROM gi203242.TRANS;";
        List<Transaction> trans = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Transaction.class));
        return trans;
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection =databaseConnection;
    }
}
