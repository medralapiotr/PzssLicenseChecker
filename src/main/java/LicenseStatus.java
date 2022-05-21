import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;


public class LicenseStatus {

    final String websiteURL = "https://portal.pzss.org.pl/Player/Applications";
    final String loginURL = "https://portal.pzss.org.pl/";

    public void fetchLicenseStatus(Map<String,String> credentials) {
        try {
            // call main website to get cookies
            Connection.Response loginForm = Jsoup.connect(loginURL)
                    .data(credentials)
                    .method(Connection.Method.POST)
                    .execute();

            // call data website to fetch data table
            Document dataWebsite = Jsoup.connect(websiteURL)
                    .referrer(loginURL)
                    .cookies(loginForm.cookies())
                    .followRedirects(false)
                    .get();

            // select table header and data rows
            Element headers = dataWebsite.select("thead").get(0); //select the headers of the table.
            Element body = dataWebsite.select("tbody").get(0); //select body of the table.

            //create map to catch data from table
            Map <String, String> data = new HashMap<>();
            for (int i=0; i<6; i++){
                String header = headers.select("th").get(i).text().toString();
                String tableValue = body.select("th,td").get(i).text().toString();
                data.put(header,tableValue);
                System.out.println(header + ":" + tableValue);

                System.out.println(data);
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
