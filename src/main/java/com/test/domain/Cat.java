package com.test.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("C")
public class Cat extends Pet {

    private boolean playful;

    public boolean isPlayful() {
        return playful;
    }

    public void setPlayful(boolean playful) {
        this.playful = playful;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;

        Cat cat = (Cat) o;

        if (playful != cat.playful) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (playful ? 1 : 0);
        return result;
    }
}
