package App.Application.Controllers;


import App.Domain.CashIn;
import App.Infrastructure.CashInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/CashIn")
public class CashInController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private CashInRepository CashInRepository;

    public CashInController() {
        this.CashInRepository = new CashInRepository();
    }

    @GetMapping("/{PlayerID}")
    public List<CashIn> get(@PathVariable("PlayerID") String PlayerID) {
        this.CashInRepository.setDatabaseConnection(databaseConnection);
        return this.CashInRepository.get(PlayerID);
    }

    @GetMapping("/")
    public List<CashIn> get() {
        this.CashInRepository.setDatabaseConnection(databaseConnection);
        return this.CashInRepository.get();
    }

    @PostMapping("/")
    public String post(@RequestBody() CashIn transToSave) {
        this.CashInRepository.setDatabaseConnection(databaseConnection);
        this.CashInRepository.create(transToSave);
        return transToSave.getID();
    }

    @PutMapping("/{id}")
    public void put(@RequestBody() CashIn amountToUpdate, @PathVariable("id") String id) {
        this.CashInRepository.setDatabaseConnection(databaseConnection);
        this.CashInRepository.update(id, amountToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.CashInRepository.setDatabaseConnection(databaseConnection);
        this.CashInRepository.delete(id);
    }
}