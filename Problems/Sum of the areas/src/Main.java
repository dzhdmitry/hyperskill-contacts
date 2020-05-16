public static int sumOfAreas(Shape[] array) {
        int summ = 0;

        for (Shape sh: array) {
        if (sh.getClass() == Square.class) {
        Square sq = (Square) sh;
        summ = summ + (sq.getSide() * sq.getSide());
        } else if (sh.getClass() == Rectangle.class) {
        Rectangle rt = (Rectangle) sh;
        summ = summ + (rt.getWidth() * rt.getHeight());
        }
        }

        return summ;
}