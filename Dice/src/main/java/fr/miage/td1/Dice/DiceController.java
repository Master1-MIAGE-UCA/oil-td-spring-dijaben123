package fr.miage.td1.Dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @Autowired
    private DiceRollLogRepository diceRepository;

    @GetMapping("/rollDice")
    public List<Integer> rollDice(){
        return diceService.rollDice(1);
    }

    @GetMapping("/rollDices/{X}")
    public List<Integer> rollDiceXtime(@PathVariable int X){
        return diceService.rollDice(X);
    }

    @GetMapping("/diceLogs")
    public Iterable<DiceRollLog> diceLogs(){
        return diceRepository.findAll();
    }

}