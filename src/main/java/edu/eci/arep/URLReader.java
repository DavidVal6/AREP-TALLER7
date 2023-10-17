package edu.eci.arep;

import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;
import java.util.logging.*;

import javax.net.ssl.*;

public class URLReader {

    public static String readUrlSecure(String url, String trustfile, String paswd) {
        try {
            KeyStore trustStore = loadTrustStore(trustfile, paswd);
            TrustManagerFactory tmf = initTrustManagerFactory(trustStore);

            SSLContext sslContext = initSSLContext(tmf);

            // Set the default global SSLContext so all the connections will use it
            SSLContext.setDefault(sslContext);

        } catch (Exception ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return readURL(url);
    }

    private static KeyStore loadTrustStore(String trustfile, String paswd) throws Exception {
        File trustStoreFile = new File(trustfile);
        char[] trustStorePassword = paswd.toCharArray();

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);

        return trustStore;
    }

    private static TrustManagerFactory initTrustManagerFactory(KeyStore trustStore) throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Print the trustManagers returned by the TMF for debugging
        for (TrustManager t : tmf.getTrustManagers()) {
            System.out.println(t);
        }

        return tmf;
    }

    private static SSLContext initSSLContext(TrustManagerFactory tmf) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        return sslContext;
    }

    public static String readURL(String sitetoread) {
        String response = null;
        try {
            URL siteURL = new URL(sitetoread);
            BufferedReader reader = new BufferedReader(new InputStreamReader(siteURL.openStream()));

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response = inputLine;
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return response;
    }
}
