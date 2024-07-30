package e_commerce.gent_style.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @NotNull(message = "Product name can not be null")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Product description can not be null")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Product price can not be null")
    @Min(value = 0, message = "Price cannot be less than 0")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;
}
