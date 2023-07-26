import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected boolean ageInformation;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {

        return ageInformation = (age != 0);
    }

    public boolean hasAddress() {
        return (address != null);
    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {

        return hasAddress() ? address : "город не установлен";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (ageInformation) {
            age = age + 1;
            System.out.println("Новый возраст" + age);
        } else {
            System.out.println("Нет данных о возрасте");
        }
    }

    @Override
    public String toString() {
        return (hasAge()) ?
                getName() + " " + getSurname() + ", возраст: " + getAge() + ", город пребывания: (" + getAddress() + ")" :
                getName() + " " + getSurname() + ", возраст: нет данных, город пребывания: (" + getAddress() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);

//        int result = 31;
//
//        result = result*31 + name.hashCode();
//        result = result*31 + surname.hashCode();
//        result = result*31 + age;
//        result = result*31 + (hasAddress() ? address.hashCode() : 0);
//
//        return result;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }
}