package kz.aitu.restpro2423.rest.entities;

import java.util.Objects;

// Participant class
public class Participant {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String occupation;

    public Participant(String name, int age, String email, String phone, String address, String occupation) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.occupation = occupation;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    @Override
    public String toString() {
        return "Participant: " + name + ", Age: " + age + ", Email: " + email + ", Phone: " + phone +
                ", Address: " + address + ", Occupation: " + occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return age == that.age &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                phone.equals(that.phone) &&
                address.equals(that.address) &&
                occupation.equals(that.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phone, address, occupation);
    }
}
