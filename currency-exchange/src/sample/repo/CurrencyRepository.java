package sample.repo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tabela_kursow")

public class CurrencyRepository {

    //    @XmlElement(name="numer_tabeli")
    private String numer_tabeli;
    //    @XmlElement(name="data_publikacji")
    private String data_publikacji;
    private List<Currency> pozycja;

    public String getNumer_tabeli() {
        return numer_tabeli;
    }

    public void setNumer_tabeli(String numer_tabeli) {
        this.numer_tabeli = numer_tabeli;
    }

    public String getData_publikacji() {
        return data_publikacji;
    }

    public void setData_publikacji(String data_publikacji) {
        this.data_publikacji = data_publikacji;
    }

    public List<Currency> getPozycja() {
        return pozycja;
    }

    public void setPozycja(List<Currency> pozycja) {
        this.pozycja = pozycja;
    }

}
