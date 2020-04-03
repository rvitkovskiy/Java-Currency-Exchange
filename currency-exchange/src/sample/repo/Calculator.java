package sample.repo;

public class Calculator {
    public double calculate(double value, Currency from, Currency to){
        return (value*from.getPrzelicznik()*from.getKurs_sredni()*to.getPrzelicznik())/to.getKurs_sredni();
    }
}
