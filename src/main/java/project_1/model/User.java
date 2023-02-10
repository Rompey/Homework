package project_1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import project_1.enums.Role;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp birthday = Timestamp.from(Instant.now());
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Enumerated
    private Role role;
}
