import java.util.HashSet;
import java.util.Set;

public class hello_world {
    public static void main(String[] args){
        Set<Person> s = new HashSet<Person>();
        Person p1 = new Person(12, "Emily");
        Person p2 = new Person(34, "Lucy");
        Person p3 = new Person(12, "Jack");
        s.put(9,p1);
        s.put(p2);
        s.add(p3);
        System.out.println(s);
    }
}

class Person{
    //class variables
    public int id;
    public String name;

    //constructor
    Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " - Name: " + this.name;
    }

    @Override
    public boolean equals(Object other){
        //type casting an object (casting the object from the Object class onto Person class)
        Person p = (Person) other;
        System.out.println("this.id: " + this.id + " p.id: " + p.id);
        if (this.id == p.id){
            return true;
        }
        return false;
    }
}
