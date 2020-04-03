package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

import sample.repo.Currency;
import sample.repo.CurrencyRepository;
import sample.repo.Calculator;
import sample.repo.Parser;
import sample.repo.ParseFromXml;
import sample.repo.WebClient;

public class Controller {
    @FXML
    public TextField result;
    @FXML
    public ComboBox toComboBox;
    @FXML
    public ComboBox fromComboBox;
    @FXML
    public Text modificationDate;
    @FXML
    public TextField value;

    private CurrencyRepository tabelaKursow;

    private Calculator calculator = new Calculator();

    private Currency fromPozycja = new Currency();
    private Currency toPozycja = new Currency();
    private String dataModyfkiacji;

    public Controller() {
        System.out.println("Controller");

    }

    public void calculateExchangeRates(ActionEvent actionEvent) {   //obsluga przycisku obliczania

        try{
            String fromString = (String) fromComboBox.getValue();

            List<Currency> listaPozycji = tabelaKursow.getPozycja();

            for(Currency pozycja : listaPozycji) {
                if(pozycja.getKod_waluty().equals(fromComboBox.getValue()))
                    fromPozycja = pozycja;
                if(pozycja.getKod_waluty().equals(toComboBox.getValue()))
                    toPozycja = pozycja;
            }
            NumberFormat formatter = new DecimalFormat("#0.000");
            result.setText(String.valueOf(formatter.format(calculator.calculate(Double.parseDouble( value.getText()),fromPozycja, toPozycja))));


        }catch(NumberFormatException e){
//            e.printStackTrace();
            result.setText("Kwota ma być liczbą");
        }
    }


    public void dataUpdate(ActionEvent actionEvent) {   //obsluga przycisku aktualizacji danych

        WebClient webclient = new WebClient();
        Parser parser = new ParseFromXml();
        tabelaKursow = parser.parse(webclient.getXml());
        tabelaKursow.getPozycja().add(new Currency("polski_zloty", 1, "PLN", 1.0));
        List<String> kodyWalut = tabelaKursow.getPozycja().stream().map(Currency::getKod_waluty).collect(Collectors.toList());
        toComboBox.getItems().addAll(kodyWalut);
        fromComboBox.getItems().addAll(kodyWalut);
        modificationDate.setText("Data ostatniej aktualizacji: " + tabelaKursow.getData_publikacji());
        System.out.println(kodyWalut);


    }
}
