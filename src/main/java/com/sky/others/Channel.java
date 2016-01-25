package com.sky.others;

public enum Channel {
    ARSENAL_TV("Arsenal TV"),
    CHELSEA_TV("Chelsea TV"),
    LIVERPOOL_TV("Liverpool TV"),
    SKY_NEWS("Sky News"),
    SKY_SPORTS_NEWS("Sky Sports News");

    private String displayName;

    Channel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
