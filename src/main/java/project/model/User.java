package project.model;

import javax.persistence.*;

/**
 * Сущность User
 */
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true, nullable=false, length=64)
    private String username;

    @Column(nullable = false, length=24)
    private String password;

    @Column(nullable=false, length=32)
    private String firstName;

    @Column(nullable=false, length=32)
    private String lastName;

    public User() {
    }


}
