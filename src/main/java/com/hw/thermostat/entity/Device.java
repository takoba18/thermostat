package com.hw.thermostat.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "device", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@ToString
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double temperature;
    private boolean isCritical;
}
