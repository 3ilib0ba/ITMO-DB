package com.example.demo.config;

public enum RoleConfig {
    UNAUTHORIZED("UNAUTHORIZED"),

    ROLE_USER("USER"),

    ROLE_ADMIN("ADMIN"),

    ROLE_MANAGER("MANAGER"),

    ROLE_INSTRUCTOR("INSTRUCTOR");

    private final String name;

    RoleConfig(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
