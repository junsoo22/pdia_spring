package com.example.demo.product;

import lombok.Getter;

@Getter
public enum Language {
    KO("ko"),
    EN("en");

    private final String langType;

    Language(String langType) {
        this.langType = langType;
    }
}
