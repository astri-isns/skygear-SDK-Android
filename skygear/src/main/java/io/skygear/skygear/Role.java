package io.skygear.skygear;

import android.support.annotation.NonNull;

/**
 * The Skygear User Role.
 */
public class Role implements Comparable<Role> {
    private final String name;

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Gets the role name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(@NonNull Role another) {
        return this.name.compareTo(another.name);
    }

    @Override
    public boolean equals(Object another) {
        return another instanceof Role && this.compareTo((Role) another) == 0;
    }
}
