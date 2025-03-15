package lr2;

class Animal {
    String name;
    int age;

    Animal() {
    }

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Woof!");
    }

}

class Cat extends Animal {
    String color;

    Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}

class Bird extends Animal {
    boolean canFly;

    Bird(String name, int age, boolean canFly) {
        this.name = name;
        this.age = age;
        this.canFly = canFly;
    }

    @Override
    void makeSound() {
        System.out.println("Chirp!");
    }

    void fly() {
        if (canFly) {
            System.out.println(name + " is flying.");
        } else {
            System.out.println(name + " cannot fly.");
        }
    }
}

public class Animals {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Generic", 5);
        genericAnimal.makeSound();
        Dog dog = new Dog("Cat", 3, "Chihuahua");
        dog.makeSound();
        Cat cat = new Cat("Dog", 2, "Leopard");
        cat.makeSound();
        Bird bird = new Bird("Popka", 12, true);
        bird.makeSound();
        bird.fly();
    }
}
