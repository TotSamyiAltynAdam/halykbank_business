package kz.halykbank.halykbank.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    private Integer totalPrice;

    @OneToMany
    private List<Item> items;

    @ManyToOne
    private Employee employee;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    @ManyToOne
    private Organization organization;
    @PostConstruct
    public void creationDate() {
        creationDate = LocalDate.now();
    }

}
