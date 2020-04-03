package sample.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {
    public String getXml() {

        try {
            String fformat = "xml";
            String url = "http://www.nbp.pl/kursy/xml/lasta.xml";
            System.out.println(url);
            URL obj = new URL(url);
            HttpURLConnection con = null;
            con = (HttpURLConnection) obj.openConnection();
            InputStream inputStream = con.getInputStream();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            inputStream));

            StringBuilder response = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null)
                response.append(currentLine);

            in.close();

            System.out.println(response.toString());
            String responseString = response.toString().replace(",", ".");

            int responseCode = con.getResponseCode();

            return responseString;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
