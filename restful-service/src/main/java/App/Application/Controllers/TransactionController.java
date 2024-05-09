package App.Application.Controllers;


import App.Domain.Transaction;
import App.Infrastructure.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private TransactionRepository TransactionRepository;

    public TransactionController() {
        this.TransactionRepository = new TransactionRepository();
    }

    @GetMapping("/{PlayerID}")
    public List<Transaction> get(@PathVariable("PlayerID") String PlayerID) {
        this.TransactionRepository.setDatabaseConnection(databaseConnection);
        return this.TransactionRepository.get(PlayerID);
    }

    @GetMapping("/")
    public List<Transaction> get() {
        this.TransactionRepository.setDatabaseConnection(databaseConnection);
        return this.TransactionRepository.get();
    }

    @PostMapping("/")
    public String post(@RequestBody() Transaction transToSave) {
        this.TransactionRepository.setDatabaseConnection(databaseConnection);
        this.TransactionRepository.create(transToSave);
        return transToSave.getID();
    }

    @PutMapping("/{id}")
    public void put(@RequestBody() Transaction amountToUpdate, @PathVariable("id") String id) {
        this.TransactionRepository.setDatabaseConnection(databaseConnection);
        this.TransactionRepository.update(id, amountToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.TransactionRepository.setDatabaseConnection(databaseConnection);
        this.TransactionRepository.delete(id);
    }
}