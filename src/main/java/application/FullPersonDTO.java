package application;

import domain.Person;

import java.util.Objects;

public class FullPersonDTO {

    private long id;

    private String name;

    private String date;

    public FullPersonDTO() {

    }

    public FullPersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.date = person.getDate().toString();
    }

    public FullPersonDTO(long id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FullPersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullPersonDTO that = (FullPersonDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }


}
