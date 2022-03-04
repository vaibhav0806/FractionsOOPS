

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Fractions {
    private int numerator;
    private int denominator;

    public Fractions(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0){
            throw new ArithmeticException("Denominator cannot be 0");
        }
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator){
        if(denominator == 0){
            throw new ArithmeticException("Denominator cannot be set to 0");
        }
        this.denominator = denominator;
        simplify();
    }

    public static Fractions add(Fractions f1, Fractions f2){
        int n = f1.numerator*f2.denominator + f1.denominator*f2.numerator;
        int d = f1.denominator*f2.denominator;
        Fractions f = new Fractions(n, d);
        return f;
    }

    public void add(Fractions f1){
        this.numerator = this.numerator*f1.denominator + this.denominator*f1.numerator;
        this.denominator = f1.denominator*this.denominator;
        simplify();
    }

    public static Fractions multiply(Fractions f1, Fractions f2){
        return new Fractions(f1.numerator*f2.numerator, f1.denominator*f2.denominator);
    }

    public void multiply(Fractions f1){
        this.numerator = this.numerator * f1.numerator;
        this.denominator = this.denominator * f1.denominator;
        simplify();
    }

    public static Fractions subtract(Fractions f1, Fractions f2){
        return new Fractions(f1.numerator*f2.denominator - f1.denominator*f2.numerator, f1.denominator*f2.denominator);
    }

    public void subtract(Fractions f1){
        this.numerator = this.numerator*f1.denominator - this.denominator*f1.numerator;
        this.denominator = f1.denominator*this.denominator;
        simplify();
    }

    public static Fractions divide(Fractions f1, Fractions f2){
        return new Fractions(f1.numerator*f2.denominator, f1.denominator*f2.numerator);
    }

    public void divide(Fractions f1){
        this.numerator = this.numerator*f1.denominator;
        this.denominator = this.denominator*f1.numerator;
        simplify();
    }

    public void print(){
        if(this.denominator == 1){
            System.out.println(this.numerator);
        }
        else{
            System.out.println(this.numerator+"/"+this.denominator);
        }
    }
    private void simplify(){
        int gcd = 1;
        int smallest = Math.min(numerator, denominator);

        for(int i = 2; i <= smallest; i++){
            if(numerator%i==0 && denominator%i==0)
                gcd = i;
        }

        numerator /= gcd;
        denominator /= gcd;
    }
}
