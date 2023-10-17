package edu.eci.arep;
import static spark.Spark.*;
public class Spark2 {
    public static void main(String[] args) {
        port(getPort());
        secure("keys/ecikeystore2.p12", "clave1234", null, null);
        get("/anotherhello", (req,res)-> "HOLA LA SEGUNDA PAGINA ES FUNCIONAL");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; // returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
