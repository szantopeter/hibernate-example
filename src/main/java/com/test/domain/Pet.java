package com.test.domain;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="race", length = 1, discriminatorType= DiscriminatorType.STRING)
public abstract class Pet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person owner;

    @Column(insertable=false, updatable=false)
    public String race;

    public String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", owner=" + owner +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        if (id != pet.id) {
            return false;
        }
        if (name != null ? !name.equals(pet.name) : pet.name != null) {
            return false;
        }
        if (owner != null ? !owner.equals(pet.owner) : pet.owner != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
