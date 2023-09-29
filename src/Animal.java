import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        this.species = speciesName;
        this.canHop = hopper;
        this.canSwim = swimmer;
    }

    public boolean canHop() {
        return this.canHop;
    }

    public boolean canSwim() {
        return this.canSwim;
    }

    @Override
    public String toString() {
        return "Animal [species=" + this.species + "]";
    }
}

class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}

class TraditionalSearch {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("turtle", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));

//        print(animals, new CheckIfHopper());

        /** Using lambda expression
         * Java relies on the context when figuring what lambda expressions mean */
        print(animals, a -> a.canHop());
        print(animals, a -> a.canSwim());


    }

//    private static void print(List<Animal> animals, CheckIfHopper checker) {
//        for (Animal animal : animals) {
//            if (checker.test(animal)) {
//                System.out.println(animal);
//            }
//        }
//    }



//    /** Using lambda expression */
//    private static void print(List<Animal> animals, CheckTrait checker) {
//        for (Animal animal : animals) {
//            if (checker.test(animal)) {
//                System.out.println(animal);
//            }
//        }
//    }

    /** FunctionalInterface heeft EEN abstract methode
    /** Using Predicate + test() method */
    private static void print(List<Animal> animals, Predicate<Animal> checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) { System.out.println(animal);
            }
        }
    }

}