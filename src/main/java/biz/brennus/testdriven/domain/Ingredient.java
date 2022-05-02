package biz.brennus.testdriven.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;
    private String unit;

    public Ingredient() { }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }
}
