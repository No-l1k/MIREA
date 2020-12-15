package Practic15;
public class Person
{
    private String name,surname,patronymic;

    Person(String surname)
    {
        this.surname=surname;
    }

    Person(String surname,String name,String patronymic)
    {
        this.surname=surname;
        this.name=name;
        this.patronymic=patronymic;
    }


    public String toString()
    {
        if(name==null || patronymic==null)
        {
            return(surname);
        }
        else
        {
            return(surname+" "+name+" "+patronymic);

        }
    }

    public static void main(String []args)
    {
        Person p=new Person("Смирнов","Сергей","Сергеевич");
        System.out.println(p.toString());
        Person p1=new Person("Иванов");
        System.out.println(p1.toString());
    }
}