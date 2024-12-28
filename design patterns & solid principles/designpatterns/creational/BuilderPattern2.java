package designpatterns.creational;

class Dog{
    private String name;
    private String gender;
    private String breed;
    private Double price;
    public Dog (DogBuilder builder){
        this.name=builder.getName();
        this.breed=builder.getBreed();
        this.price=builder.getPrice();
        this.gender= builder.getGender();

    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBreed() {
        return breed;
    }

    public Double getPrice() {
        return price;
    }

    private  void setName(String name) {
        this.name = name;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", price=" + price +
                '}';
    }

    public static class DogBuilder{
        private String name;
        private String gender;
        private String breed;
        private Double price;

        public String getName() {
            return name;
        }

        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getGender() {
            return gender;
        }

        public DogBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public String getBreed() {
            return breed;
        }

        public DogBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Double getPrice() {
            return price;
        }

        public DogBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }
        public Dog build(){
            return new Dog(this);
        }
    }

}
public class BuilderPattern2 {
    public static void main(String[] args) {
        Dog dog1= new Dog.DogBuilder()
                .setName("Bruno")
                .setGender("Male")
                .setPrice(456.36)
                .setBreed("Pug")
                .build();
        System.out.println(dog1);
        Dog dog2=new Dog.DogBuilder()
                .setGender("Female")
                .setName("Alissa")
                .build();
        System.out.println(dog2);
    }
}
