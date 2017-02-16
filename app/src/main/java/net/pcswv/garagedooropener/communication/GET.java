package net.pcswv.garagedooropener.communication;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;
import android.util.Log;
/**
 * Created by droby on 1/19/2017.
 */

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
public class GET {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        makePostRequest();

    }
    private void makePostRequest() {


        HttpClient httpClient = new DefaultHttpClient();
        // replace with your url
        HttpPost httpPost = new HttpPost("www.example.com");


        //Post Data
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
        nameValuePair.add(new BasicNameValuePair("username", "test_user"));
        nameValuePair.add(new BasicNameValuePair("password", "123456789"));


        //Encoding POST data
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            // log exception
            e.printStackTrace();
        }

        //making POST request.
        try {
            HttpResponse response = httpClient.execute(httpPost);
            // write response to log
            Log.d("Http Post Response:", response.toString());
        } catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception
            e.printStackTrace();
        }

    }
}

