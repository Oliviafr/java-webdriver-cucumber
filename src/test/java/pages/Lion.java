package pages;

public class Lion extends Animal {
    public Lion() {

    }

    public Lion( String name, String type ) {
        setName(name);
        setType(type);
    }

    public void speak( String lname, String ltype ) {
        String lion_name = "lion";
        String lion_type = "African";
        if (lion_name.equals(lname) && lion_type.equals(ltype)) {
            System.out.println(getName() + " is roar!");
        } else {
            System.out.println("Missing Info");
        }
    }

}
