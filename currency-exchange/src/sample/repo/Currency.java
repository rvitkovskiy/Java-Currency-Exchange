package sample.repo;

public class Currency {

    private String nazwa_waluty;
    private double przelicznik;
    private String kod_waluty;
    private double kurs_sredni;

    public Currency() {
    }

    public Currency(String nazwa_waluty, double przelicznik, String kod_waluty, double kurs_sredni) {
        this.nazwa_waluty = nazwa_waluty;
        this.przelicznik = przelicznik;
        this.kod_waluty = kod_waluty;
        this.kurs_sredni = kurs_sredni;
    }

    public String getNazwa_waluty() {
        return nazwa_waluty;
    }

    public void setNazwa_waluty(String nazwa_waluty) {
        this.nazwa_waluty = nazwa_waluty;
    }

    public double getPrzelicznik() {
        return przelicznik;
    }

    public void setPrzelicznik(double przelicznik) {
        this.przelicznik = przelicznik;
    }

    public String getKod_waluty() {
        return kod_waluty;
    }

    public void setKod_waluty(String kod_waluty) {
        this.kod_waluty = kod_waluty;
    }

    public double getKurs_sredni() {
        return kurs_sredni;
    }

    public void setKurs_sredni(double kurs_sredni) {
        this.kurs_sredni = kurs_sredni;
    }
}
