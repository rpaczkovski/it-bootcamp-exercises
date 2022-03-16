package application.models.entities;

public class Client  {

    private Integer ID;
    private String name;
    private String surname;

    public Client(Integer id, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.ID = id;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "\n" +
                "Cliente dados: " +
                ", ID='" + ID + '\'' +
                ", nome='" + name + '\'' +
                ", sobrenome='" + surname + '\'';
    }

}
