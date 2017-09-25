package ctci.stacksNqueues;

import java.util.Queue;

public class AnimalShelter{

    private static class AnimalWrap{
        Animal animal;
        int order;

        public AnimalWrap(Animal animal, int order){
            this.animal = animal;
            this.order = order;
        }
    }

    MyQueue<AnimalWrap> dogsQueue;
    MyQueue<AnimalWrap> catsQueue;

    private static int c = 0;

    /* pushes animal into queue.*/
    public void push(Animal animal){
        AnimalWrap animalWrap = new AnimalWrap(animal,c++);
        if(animal instanceof Dog){
            if(dogsQueue==null)
                dogsQueue = new MyQueue<>();
            dogsQueue.enqueue(animalWrap);
        }else if(animal instanceof Cat){
            if(catsQueue==null)
                catsQueue = new MyQueue<>();
            catsQueue.enqueue(animalWrap);
        }
    }


    public Animal pop(int animalNumber) throws Exception{
        Animal oldest = null;
       if(animalNumber==0){/* return oldest cat*/
          if(catsQueue.isEmpty()) throw new Exception();
          oldest = catsQueue.dequeue().animal;
       }else if(animalNumber==1){ /* return oldest dog*/
          if(dogsQueue.isEmpty()) throw new Exception();
          oldest = dogsQueue.dequeue().animal;
       }else{/* return oldest of Animals. */
           if(isEmpty()) throw new Exception();
           int catsOldest = catsQueue.isEmpty()?Integer.MAX_VALUE:catsQueue.peek().order;
           int dogsOldest = dogsQueue.isEmpty()?Integer.MAX_VALUE:dogsQueue.peek().order;
           oldest = catsOldest<dogsOldest?pop(0):pop(1);
       } return oldest;
    }

    /**/
    public boolean isEmpty(){
        return catsQueue.isEmpty() && dogsQueue.isEmpty();
    }

}

abstract class Animal{

    public String name;

    public Animal(String name){
        this.name = name;
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}


