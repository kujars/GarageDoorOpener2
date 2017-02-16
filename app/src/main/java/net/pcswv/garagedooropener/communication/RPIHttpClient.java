package net.pcswv.garagedooropener.communication;

/**
 * Created by droby on 1/19/2017.
 */

import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RPIHttpClient {
    public final static int DEFAULT_PORT = 8000;

    protected String urlBase;
    protected String auth;

    public RPIHttpClient(String host) {
        this.urlBase = "http://" + host + ":" + String.valueOf(DEFAULT_PORT);
    }

    public RPIHttpClient(String host, int port) {
        this.urlBase = "http://" + host + ":" + String.valueOf(port);
    }

    public String sendRequest(String method, String path) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(this.urlBase + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            int TIMEOUT = 500;
            connection.setConnectTimeout(TIMEOUT);
            if (this.auth != null) {
                connection.setRequestProperty("Authorization", this.auth);
            }


            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void setCredentials(String login, String password) {
        String s = login + ":" + password;
        this.auth = "Basic " + Base64.encodeToString(s.getBytes(), Base64.DEFAULT);
    }

}
