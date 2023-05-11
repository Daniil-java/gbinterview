package homeworks.oop.polymorphism;

import homeworks.oop.polymorphism.figures.Circle;
import homeworks.oop.polymorphism.figures.Square;
import homeworks.oop.polymorphism.figures.Triangle;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        List<Figure> figures = Arrays.asList(square, triangle, circle);

        for (Figure figure : figures) {
            figure.toCalculateArea();
        }
    }
}
