package guru.springframework.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    public Ingredient(String description, BigDecimal amount, UnityOfMeasure unityOfMeasure){
        this.description = description;
        this.amount = amount;
        this.unityOfMeasure = unityOfMeasure;
    }

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnityOfMeasure unityOfMeasure;

}
