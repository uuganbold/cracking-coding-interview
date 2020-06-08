package ctci.chapter3;
import java.util.*;


public class Solution6 {

    private int counter=0;

    public static class Pet{
        public int arrivedAt;
    }

    public static class Cat extends Pet{

    }

    public static class Dog extends Pet{

    }

    private Queue<Cat> cats=new LinkedList<>();
    private Queue<Dog> dogs=new LinkedList<>();

    public void enqueue(Pet pet){
        pet.arrivedAt=counter++;
        if(pet instanceof Cat){
             cats.offer((Cat)pet);
        }else{
            dogs.offer((Dog)pet);
        }
    }

    public Pet dequeueAny(){
        if(cats.peek().arrivedAt>dogs.peek().arrivedAt){
            return dequeueDog();
        }else{
            return dequeueCat();
        }
    }

    public Cat dequeueCat(){
        return cats.poll();
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    
}