public class Student extends Person implements Details {
    private int age;

    // Constructor
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // Methods
    public void showDetails(){

    }

    public void showDetails(int index){}

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
