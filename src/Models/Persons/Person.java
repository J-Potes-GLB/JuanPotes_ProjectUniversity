package Models.Persons;

public abstract class Person {
    protected String name;
    protected int id;

    // Methods

    // Method to check if an id sent as parameter is the same as the id of the person
    public boolean idEquals(int id){
        return id == this.id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
