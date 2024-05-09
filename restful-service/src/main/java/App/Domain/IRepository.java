package App.Domain;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IRepository<Item> {
    public Item create(Item item);

    public int update(String id, Item item);

    public boolean delete(String id);

    public List<Item> get(String id);

    public List<Item> get();

    public void setDatabaseConnection(JdbcTemplate databaseConnection);
}
