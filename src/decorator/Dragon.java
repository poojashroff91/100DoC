package decorator;
class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{

    private int age;
    private Bird bird;
    private Lizard lizard;

    public Dragon() {
        this.bird = new Bird();
        this.lizard = new Lizard();
    }

    public void setAge(int age)
    {
        // todo
        this.age = age;
        this.bird.age = age;
        this.lizard.age = age;
    }
    public String fly()
    {
        // todo
        return bird.fly();

    }
    public String crawl()
    {
        // todo
        return lizard.crawl();

    }
}