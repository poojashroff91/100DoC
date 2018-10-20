package factory;
class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory
{
    private int id = 0;
    public Person createPerson(String name)
    {
        return new Person(id++, name);

    }
}

class DemoPerson {
    public static void main(String[] args) {
        PersonFactory pf = new PersonFactory();
        Person pooja = pf.createPerson("pooja");
        System.out.println(pooja);
        Person santosh = pf.createPerson("santosh");
        System.out.println(santosh);
    }
}