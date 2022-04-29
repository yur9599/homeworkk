package designPatterns.factory;

import designPatterns.factory.shapes.Rectangle;
import designPatterns.factory.shapes.Shape;
import designPatterns.factory.shapes.Square;
import designPatterns.factory.shapes.Triangle;

public class ShapeFactory {

    public Shape createShape(String shape){
        return switch (shape) {
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> new Square();
        };
    }

}
