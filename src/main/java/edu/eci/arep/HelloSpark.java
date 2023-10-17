package edu.eci.arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class HelloSpark {

    public static void main(String[] args) {
        secure("keys/ecikeystore.p12", "eci123", null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        get("/anotherhello",(req,res) -> URLReader.readUrlSecure("https://localhost:5001/anotherhello", "keys\\ecikeystore2.p12","clave1234"));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; // returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
