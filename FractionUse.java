class FractionUse {
    public static void main(String[] args) {
        Fractions f1 = new Fractions(30, 20);
        f1.print();

        Fractions f2 = new Fractions(12, 4);
        f2.print();

        f1.add(f2);
        f1.print();

        f2.multiply(f1);
        f2.print();

        Fractions f3 = Fractions.add(new Fractions(5, 9), new Fractions(2, 3));
        f3.print();

        //Fractions f4 = new Fractions(5, 0);

    }
}
