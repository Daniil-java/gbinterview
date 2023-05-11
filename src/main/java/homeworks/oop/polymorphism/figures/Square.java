package homeworks.oop.polymorphism.figures;

import homeworks.oop.polymorphism.Figure;

public class Square extends Figure {
    @Override
    protected void toCalculateArea() {
        System.out.println("Площадь квадрата");
    }
}
