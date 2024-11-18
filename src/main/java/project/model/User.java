package project.model;

import javax.persistence.*;

/**
 * Сущность User
 */
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username",unique=true, nullable=false, length=64)
    private String username;

    @Column(name="password",nullable = false, length=24)
    private String password;

    @Column(name="firstname",nullable=false, length=32)
    private String firstName;

    @Column(name="lastname",nullable=false, length=32)
    private String lastName;

    public User() {
    }


}
