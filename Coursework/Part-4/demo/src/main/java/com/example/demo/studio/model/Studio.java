package com.example.demo.studio.model;

import com.example.demo.balance.model.Balance;
import com.example.demo.client.model.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "studio")
public class Studio {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne
    private LegalInfo legalInfo;

    @OneToOne
    private Balance balance;

    public Studio() {
    }

    public Studio(long id, String name, String description, Role role, LegalInfo legalInfo, Balance balance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.role = role;
        this.legalInfo = legalInfo;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LegalInfo getLegalInfo() {
        return legalInfo;
    }

    public void setLegalInfo(LegalInfo legalInfo) {
        this.legalInfo = legalInfo;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", legalInfo=" + legalInfo +
                ", balance=" + balance +
                '}';
    }
}
