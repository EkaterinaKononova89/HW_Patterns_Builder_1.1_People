public class Main {
    public static void main(String[] args) throws IllegalStateException, IllegalArgumentException { // нужно ли указывать?
        Person mom = new PersonBuilder()
                .setName("Екатерина")
                .setSurname("Кононова")
                .setAge(34)
                .setAddress("Екатеринбург")
                .build();
        Person daughter = mom.newChildBuilder()
                .setName("Таисия")
                .setAge(5)
                .build();
        System.out.println("У " + mom + " есть дочь, " + daughter);
        mom.happyBirthday();
        System.out.println(mom.getAge());

//        try {
//            // Не хватает обязательных полей
//            new PersonBuilder().build();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }

//        try {
//            // Возраст недопустимый
//            new PersonBuilder().setAge(-100).build();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
    }
}