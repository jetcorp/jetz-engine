package jetzengine.entity;

import lombok.Getter;

@Getter
public enum ZuserRole {
    ADMIN("AMDIN"),
    USER("USER");

    ZuserRole(String role) {
        this.role = role;
    }

    private String role;
}