package com.alkemy.wallet.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    public RoleEntity() { }

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return this.name;
    }

}
