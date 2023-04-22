package com.hw.thermostat.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "_user", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean isEnabled;
    private String roles;

}
