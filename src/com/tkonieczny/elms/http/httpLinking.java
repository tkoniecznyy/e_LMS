package com.tkonieczny.elms.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tkonieczny.elms.classes.LoginInfo;
import com.tkonieczny.elms.classes.UserData;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class httpLinking {

    public static boolean getAuthOfLogin(LoginInfo loginInfo) {


        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/login");

        Gson gson = new Gson();

        // Tworzymy obiekt uzytkownika
        final LoginInfo loginInfoFromClient = loginInfo;

        // Serializacja obiektu do JSONa
        final String json = gson.toJson(loginInfoFromClient);

        try {

            final StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            final CloseableHttpResponse response = client.execute(httpPost);

            System.out.println("Kod odpowiedzi serwera: " + response.getStatusLine().getStatusCode());

            if (response.getStatusLine().getStatusCode() == 404) {

            } else if (response.getStatusLine().getStatusCode() == 201) {
                System.out.println("Odpowiedz z serwera - true");
                final HttpResponse response201 = client.execute(httpPost);  // Otrzymujemy odpowiedz od serwera.
                final HttpEntity entity201 = response201.getEntity();

                final String json201 = EntityUtils.toString(entity201);
                final Type type = new TypeToken<Boolean>(){}.getType();
                final Boolean authResponse = gson.fromJson(json201, type);

                return authResponse;
            }

            client.close();
        } catch (UnsupportedEncodingException e) {

            System.out.println("Houston, we have a problem with POST unsupported encoding");
            e.printStackTrace();
        } catch (ClientProtocolException e) {

            System.out.println("Houston, we have a problem with POST client protocol");
            e.printStackTrace();
        } catch (IOException e) {

            System.out.println("Houston, we have a problem with POST input output");
            e.printStackTrace();

        }return false;
    }

    public static UserData getInfoAboutLoggedUser(){

            final HttpClient client = HttpClientBuilder.create().build();

        /*
            Do konstruktora klasy HttpGet podajemy url z nasza usluga ktora zwaraca JSON'a.
            W tym miejscu tworzymy request serwera.
        */
            final HttpGet request = new HttpGet("http://127.0.0.1:8080/api/login/getLoggedUserData");

            /* Przy pomocy tej biblioteki zmienimy JSON'a na obiekt typu 'UserData'. */
            final Gson gson = new Gson();
            UserData userDataFromServerToReturn= null;
            try {

                final HttpResponse response = client.execute(request);  // Otrzymujemy odpowiedz od serwera.
                final HttpEntity entity = response.getEntity();

                final String json = EntityUtils.toString(entity);   // Na tym etapie odczytujemy JSON'a, ale jako String.


            /*
                Tutaj odbywa sie przetworzenie (serializacja) JSON'a (String) na UserData

             */

                final Type type = new TypeToken<UserData>(){}.getType();
                final UserData userDataFromServer = gson.fromJson(json, type);


                if(response.getStatusLine().getStatusCode() == 400) {
                    System.out.println("Brak danych do wyswietlenia!");
                } else if(response.getStatusLine().getStatusCode() == 200) {
                    userDataFromServerToReturn=userDataFromServer;
                    return  userDataFromServer;
                }

            } catch (IOException e) {

                System.out.println("Houston, we have a problem with GET");
                e.printStackTrace();

            }
            return userDataFromServerToReturn;
        }

    }





