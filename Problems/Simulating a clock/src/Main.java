class Clock {
    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes == 59) {
            minutes = 0;

            if (hours == 12) {
                hours = 1;
            } else {
                hours = hours + 1;
            }
        } else {
            minutes = minutes + 1;
        }
    }

    public static void main(String[] args) {
        testX(1, 59);
        testX(2, 59);
        testX(3, 59);
        testX(4, 59);
        testX(5, 59);
        testX(6, 59);
        testX(7, 59);
        testX(8, 59);
        testX(9, 59);
        testX(10, 59);
        testX(11, 59);
        testX(12, 59);
    }

    private static void testX(int hours, int minutes) {
        Clock cc = new Clock();
        cc.hours = hours;
        cc.minutes = minutes;

        cc.next();

        System.out.println(cc.hours + ":" + cc.minutes);
    }
}
