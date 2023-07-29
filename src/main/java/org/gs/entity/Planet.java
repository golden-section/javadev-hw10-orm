package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "planet")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Planet {
    @Id
    @Column(name = "id", length = 30, nullable = false)
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;
}