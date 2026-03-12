package co.edu.uniquindio.iterate;

public class Client implements Comparable<Client>{
    public String name;
    public int age;
    public String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Client(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Client other) {
        int numero1 = 0;
        switch (other.color){
            case "Verde" -> numero1 = 3;
            case "Amarillo" -> numero1 = 2;
            case "Rojo" -> numero1 = 1;
        }
        int numero2 = 0;
        switch (this.color){
            case "Verde" -> numero2 = 3;
            case "Amarillo" -> numero2 = 2;
            case "Rojo" -> numero2 = 1;
        }
        return numero2 -  numero1;

    }
}
