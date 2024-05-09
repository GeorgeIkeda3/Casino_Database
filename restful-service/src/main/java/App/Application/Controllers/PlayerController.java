package App.Application.Controllers;


import App.Domain.Player;
import App.Infrastructure.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Player")
public class PlayerController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private PlayerRepository playerRepository;

    public PlayerController() {
        this.playerRepository = new PlayerRepository();
    }

    @GetMapping("/{id}")
    public List<Player> get(@PathVariable("id") String id) {
        this.playerRepository.setDatabaseConnection(databaseConnection);
        return this.playerRepository.get(id);
    }

    @GetMapping("/")
    public List<Player> get() {
        this.playerRepository.setDatabaseConnection(databaseConnection);
        return this.playerRepository.get();
    }

    @PostMapping("/")
    public String post(@RequestBody() Player playerToSave) {
        this.playerRepository.setDatabaseConnection(databaseConnection);
        this.playerRepository.create(playerToSave);
        return playerToSave.getName();
    }

    @PutMapping("/{name}")
    public void put(@RequestBody() Player playerToUpdate, @PathVariable("name") String name) {
        this.playerRepository.setDatabaseConnection(databaseConnection);
        this.playerRepository.update(name, playerToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.playerRepository.setDatabaseConnection(databaseConnection);
        this.playerRepository.delete(id);
    }
}