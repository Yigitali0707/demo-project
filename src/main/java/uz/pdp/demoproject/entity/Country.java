package uz.pdp.demoproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.pdp.demoproject.entity.enums.Continent;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Continent continent;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
