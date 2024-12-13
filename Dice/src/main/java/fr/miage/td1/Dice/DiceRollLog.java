package fr.miage.td1.Dice;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class DiceRollLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int diceCount;

    @ElementCollection
    private List<Integer> results;

    private Date timestamp;

    public DiceRollLog() {}


    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
