package pages;

public abstract class Animal {

    private String name;
    private String type;

    Animal() {
        name = "nameless one";
        type = "typeless one";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void walk() {
        System.out.println(getClass() + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass() + " " + name + " is sleeping");
    }

    public void eat(String what) {
        System.out.println(getClass() + " " + name + " is eating " + what);
    }

    public void speak() {
        System.out.println("Undefined");
    }

    public void speak(String lname, String ltype) {
        System.out.println(getClass() + " " + name + " is eating ");
    }
}