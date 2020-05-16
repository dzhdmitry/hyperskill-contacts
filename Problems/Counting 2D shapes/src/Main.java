public static int count2DShapes(Shape[] shapes) {
    int amount = 0;

    for (Shape shape: shapes) {
        if (Shape2D.class.isInstance(shape) && shape.getClass() != Shape2D.class) {
            amount++;
        }
    }

    return amount;
}
