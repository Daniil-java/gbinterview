package homeworks.oop;

public class App {
}

interface Moveable {
    void move();
}
interface Stopable {
    void stop();
}

abstract class Car {
    public Engine engine;                           //внутренние поля класса не следует делать публичными
                                                    /*Согласну принципу открытости/закрытости конкретную
                                                    реализацию Engine можно заменить на интерфейс*/
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");         //методы stop() и start() следует отнести к одному интерфейсу
                                                    //или оставить их в классе
    }
    abstract void open();

    public Engine getEngine() {                     //При помощи lombok геттеры и сеттеры можно заменить одной аннотацией
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class LightWeightCar extends Car implements Moveable {
    @Override
    void open() {
        System.out.println("Car is open");
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
class Lorry extends Car, Moveable, Stopable {       //Интерфейсы реализуются при помощи ключевого слова "implements"
    public void move(){                             //@Override
        System.out.println("Car is moving");
    }
    public void stop(){                             //@Override
        System.out.println("Car is stop");
    }
}

