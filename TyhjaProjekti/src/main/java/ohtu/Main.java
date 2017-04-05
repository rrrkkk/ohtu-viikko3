
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "010823552";
        Integer total_hours = 0, total_done = 0;
        if ( args.length>0) {
            studentNr = args[0];
        }

	String url1 = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText1 = Request.Get(url1).execute().returnContent().asString();

        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText1 );

        String url2 = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText2 = Request.Get(url2).execute().returnContent().asString();

	System.out.println("opiskelijanumero: " + studentNr);
        System.out.println();
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText2, Submission[].class);
        
        // System.out.println("Oliot:");
        for (Submission submission : subs) {
            System.out.println(" " + submission);
            total_hours += submission.getHours();
            total_done += submission.getTotalDone();
        }

        System.out.println();
        System.out.println("yhteensä: " + total_done + " tehtävää " + total_hours + " tuntia");
    }
}
