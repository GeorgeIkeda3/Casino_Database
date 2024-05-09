package App.Application.Controllers;


import App.Domain.PlayerAccount;
import App.Infrastructure.PlayerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/PlayerAccount")
public class PlayerAccountController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private PlayerAccountRepository playerAccountRepository;

    public PlayerAccountController() {
        this.playerAccountRepository = new PlayerAccountRepository();
    }

    @GetMapping("/{id}")
    public List<PlayerAccount> get(@PathVariable("id") String id) {
        this.playerAccountRepository.setDatabaseConnection(databaseConnection);
        return this.playerAccountRepository.get(id);
    }

    @GetMapping("/")
    public List<PlayerAccount> get() {
        this.playerAccountRepository.setDatabaseConnection(databaseConnection);
        return this.playerAccountRepository.get();
    }


}
