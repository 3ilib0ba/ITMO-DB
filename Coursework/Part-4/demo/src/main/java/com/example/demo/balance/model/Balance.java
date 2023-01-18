package com.example.demo.balance.model;


import com.example.demo.client.model.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "value")
    private Float value;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Balance() {
    }

    public Balance(Long id, Float value, Role role) {
        this.id = id;
        this.value = value;
        this.role = role;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "value=" + value +
                ", role=" + role +
                '}';
    }
}
