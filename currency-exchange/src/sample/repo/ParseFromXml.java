package sample.repo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ParseFromXml implements Parser{
    public ParseFromXml() {
    }

    @Override
    public CurrencyRepository parse(String responseString) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(CurrencyRepository.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (CurrencyRepository) jaxbUnmarshaller.unmarshal(new StringReader(responseString));

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }


}
