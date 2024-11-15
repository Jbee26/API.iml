import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;

import java.util.Arrays;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class ReadJson {
    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", 1704310046);
        file.put("Tution Fees", 65400);


        // To print in JSON format.
        System.out.print(file.get("Tution Fees"));
        ReadJson readingIsWhat = new ReadJson();

    }

    public ReadJson(){
        try {
            pull();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public  void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {

            URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totlaJson);
        System.out.println(jsonObject);

        try {


            //String name = (String)jsonObject.get("name");
          //  String mass = (String)jsonObject.get("mass");
          //  String eColor = (String)jsonObject.get("eye_color");
            //String bYear = (String)jsonObject.get("birth_year");
            //JSONArray starships = (JSONArray)jsonObject.get("starships");



            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("abilities");
            org.json.simple.JSONArray msg2 = (org.json.simple.JSONArray) jsonObject.get("forms");
            org.json.simple.JSONArray msg3 = (org.json.simple.JSONArray) jsonObject.get("game_indices");

            int n =   msg.size(); //(msg).length();
            int n2 = msg2.size();
            int n3 = msg2.size();

            for (int i = 0; i < n; ++i) {
                JSONObject test = (JSONObject) msg.get(i);
                System.out.println(test);
                // System.out.println(person.getInt("key"));
                JSONObject name1 = (JSONObject) test.get("ability");
                System.out.println(name1);
                String abName = (String) name1.get("name");
                System.out.println(abName);
            }

            for (int a = 0; a < n2; ++a) {
                JSONObject test2 = (JSONObject) msg2.get(a);
                System.out.println(test2);
                String title = (String) test2.get("name");
                System.out.println(title);
//
            }


            for (int l = 0; l < n3; ++l) {
                JSONObject test3 = (JSONObject) msg3.get(l);
                System.out.println(test3);
                JSONObject version = (JSONObject) test3.get("version");
                System.out.println(version);
                String vName = (String) version.get("name");
                System.out.println(vName);
            }


















            // System.out.println(mass);
          //  System.out.println(eColor);
           // System.out.println(bYear);
          //  for (int i = 0; i < starships.size(); i++) {
               // System.out.println(starships.get(i));

           // }
//            for (int i = 0; i < ability.size(); i++) {
//                 System.out.println(ability.get(i));
//                 }




            }

        catch (Exception e) {
            e.printStackTrace();
        }




    }
}

