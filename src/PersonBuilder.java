
public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age >= 0 && age <= 120) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Введено недопустимое значение возраста");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || surname == null) {
            throw new IllegalStateException("Поля 'name' и 'surname' обязательны к заполнению");
        } else if (age == 0) {
            Person person = new Person(name, surname);
            person.setAddress(address);
            return person;
        } else {
            Person person = new Person(name, surname, age);
            person.setAddress(address);
            return person;
        }
    }
}