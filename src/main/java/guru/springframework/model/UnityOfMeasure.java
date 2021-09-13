package guru.springframework.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class UnityOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
