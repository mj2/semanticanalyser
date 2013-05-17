/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdata;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.net.URL;
import java.util.*;






public class problem {

     public static void main(String[] args)
    {
    ArrayList<String > studentTokens = new ArrayList<String>();

    try{
        // Open the file that is the first
        // command line parameter
        FileInputStream fstream = new  FileInputStream("C:/Users/HP/Desktop/d2.txt");

        // Get the object of DataInputStream
        DataInputStream k = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(k));
        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)
        {
            // Print the content on the console
            //System.out.println (strLine);
          String[] words = strLine.split(" ");
          //int count=words.length;

                System.out.print(words[0]+" ");
            System.out.print(words[2]+"\n");
             BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String urlstr = "https://api.twitter.com/1/statuses/show/";
        String id=words[0];
        urlstr+=id;
        urlstr+=".json";
        StringBuffer buff = new StringBuffer();
        URL url = new URL( urlstr);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
     //   System.out.println(url.toString());
     //   System.out.println();
            int c;
        while((c=br1.read())!=-1)
        {
            buff.append((char)c);
        }
        br1.close();

        JSONObject tweet = new JSONObject(buff.toString());
        //  System.out.println(tweet.getString("from_user")+" at "+tweet.getString("created_at"));
          System.out.println(tweet.getString("text")+"\n");

 System.out.println(tweet.getString("text")+"\n");
          String sentence =tweet.getString("text") ;
        // String sentence="hi this is obama and oice to meet obama";


          String sen=sentence.toLowerCase();
          String[] word = sen.split(" ");
         Map<String, Integer>wordCount = new HashMap<String,Integer>();
         for(String s: words)
        {

        Integer count = wordCount.get(s);
        wordCount.put(s, count == null ? 1 : count + 1);
        }
       System.out.println(wordCount.get("meet"));



          System.out.println("");
        }

        //Close the input stream
        k.close();
    }catch (Exception e)
    {//Catch exception if any
        System.err.println("Error: " + e.getMessage());
    }
         


         }




     }
    

