package Practic16;
public final class Dish implements Item
{
    private final double cost;
    private final String name,description;

    public Dish(String name, String description)throws Exception
    {
        this.name=name;
        this.description=description;
        this.cost=0;
        throw new Exception ("java.lang.IllegalArgumentException ");
    }
    public Dish(String name, String description,double cost) throws Exception
    {
        this.name=name;
        this.description=description;
        this.cost=cost;
        if (name.equals("") || description.equals("")|| cost == 0)
            throw new Exception ("java.lang.IllegalArgumentException ");
    }
    public double getCost()
    {
        return cost;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
}
