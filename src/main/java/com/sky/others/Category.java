package com.sky.others;

public enum Category {
    SPORTS("Sports"),
    NEWS("News");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
