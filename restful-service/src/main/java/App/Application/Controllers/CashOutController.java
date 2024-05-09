package App.Application.Controllers;


import App.Domain.CashOut;
import App.Infrastructure.CashOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/CashOut")
public class CashOutController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private CashOutRepository CashOutRepository;

    public CashOutController() {
        this.CashOutRepository = new CashOutRepository();
    }

    @GetMapping("/{PlayerID}")
    public List<CashOut> get(@PathVariable("PlayerID") String PlayerID) {
        this.CashOutRepository.setDatabaseConnection(databaseConnection);
        return this.CashOutRepository.get(PlayerID);
    }

    @GetMapping("/")
    public List<CashOut> get() {
        this.CashOutRepository.setDatabaseConnection(databaseConnection);
        return this.CashOutRepository.get();
    }

    @PostMapping("/")
    public String post(@RequestBody() CashOut transToSave) {
        this.CashOutRepository.setDatabaseConnection(databaseConnection);
        this.CashOutRepository.create(transToSave);
        return transToSave.getID();
    }

    @PutMapping("/{id}")
    public void put(@RequestBody() CashOut amountToUpdate, @PathVariable("id") String id) {
        this.CashOutRepository.setDatabaseConnection(databaseConnection);
        this.CashOutRepository.update(id, amountToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.CashOutRepository.setDatabaseConnection(databaseConnection);
        this.CashOutRepository.delete(id);
    }
}