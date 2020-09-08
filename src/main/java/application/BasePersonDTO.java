package application;

import java.util.Objects;

public class BasePersonDTO {

    private String name;

    private String date;

    public BasePersonDTO () {

    }

    public BasePersonDTO(String name, String date) {
        this.name = name;
        this.date = date;
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
        return "BasePersonDTO{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePersonDTO that = (BasePersonDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }

}
