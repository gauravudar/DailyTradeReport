package main.java.com.jpmorgan;

import java.util.Arrays;

public enum EntityDirection {
    BUY("B"),SELL("S");

    private final String code;

    EntityDirection(String code) {
        this.code = code;
    }

    public static EntityDirection fromCode(String code) {
        return Arrays.stream(values())
                     .filter(direction -> code.equals(direction.getCode()))
                     .findAny()
                     .orElse(null);
    }

    public String getCode() {
        return code;
    }
}
