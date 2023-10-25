package java_interface;

import java.util.ArrayList;

abstract class Vehicle_ {
   private String name;
   private int maxSpeed;
   
   
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getMaxSpeed() {
      return maxSpeed;
   }

   public void setMaxSpeed(int maxSpeed) {
      this.maxSpeed = maxSpeed;
   }

   abstract public void move();
//   abstract public void fly();
}

interface Flyable_ {
   void fly();
}

class Car_ extends Vehicle_ {
   public Car_ (String name, int maxSpeed) {
      setName(name);
      setMaxSpeed(maxSpeed);
   }
   
   @Override
   public void move() {
      System.out.println("도로를 따라 이동 중");
   }
   
//   @Override
//   public void fly() {
//      
//   }
}

class Airplane_ extends Vehicle_ implements Flyable_ {
   public Airplane_ (String name, int maxSpeed) {
      setName(name);
      setMaxSpeed(maxSpeed);
   }
   
   @Override
   public void fly() {
      System.out.println("고도 10,000피트에서 비행 중");
   }

   @Override
   public void move() {
      System.out.println("하늘을 날아가는중");
   }
}

public class FinalPrac {

   public static void main(String[] args) {
      ArrayList<Vehicle_> list = new ArrayList<>();
      Vehicle_ v1 = new Car_("벤츠", 180);
      Vehicle_ v2 = new Airplane_("보잉", 1200);
      
      list.add(v1);
      list.add(v2);
      
      for (Vehicle_ v : list) {
    	  System.out.println(v.getName() + v.getMaxSpeed());
    	  if(v instanceof Airplane_) {
    		  ((Airplane_) v).fly();
    	  }
//         if (v instanceof Car_) {
//            System.out.printf("%s속도는 : %d\n", v.getName(), v.getMaxSpeed());
//            v.move();
//         } else {
//            System.out.printf("%s속도는 : %d\n", v.getName(), v.getMaxSpeed());
//            v.move();
//            v.fly();
//         }
      }
   }
}