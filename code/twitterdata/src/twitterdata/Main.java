package twitterdata;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class Main {
    public static boolean selectTweet(String s)
    {
        return !s.contains("http://");
    }
    public static void main(String[] args) throws Exception
    {
        Polarity pol = new Polarity();
        MaxentTagger tagger = new MaxentTagger("F:\\New folder\\project\\stanford-postagger-2012-11-11\\models\\wsj-0-18-left3words.tagger");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String urlstr = "http://search.twitter.com/search.json?q=";
        System.out.print("Search for : ");
        int counter_neutral=0,counter_positive=0,counter_negative=0;
        String inp1=in.readLine();
        String inp=inp1.toLowerCase();
        String temp="";
        for(int i=0;i<inp.length();i++)
        {
        if(inp.charAt(i)==' ')
        {
        urlstr+=temp;
        urlstr+="%20";
        temp="";
        }
        else
        {
        temp+=inp.charAt(i);
        }
        }
        urlstr +=temp;
        urlstr +="&page=";
        int stop=0;
        int count=0;
        int pageno=0;
        while(stop==0)
        {
        StringBuffer buff = new StringBuffer();
        pageno++;
        URL url = new URL( urlstr+Integer.toString(pageno));
        BufferedReader br = new BufferedReader(
        new InputStreamReader(
        url.openConnection().getInputStream()));
        int c;
        while((c=br.read())!=-1)
        {
        buff.append((char)c);
        }
        br.close();
        JSONObject js = new JSONObject(buff.toString());
        JSONArray tweets = js.getJSONArray("results");
        JSONObject tweet;
        for(int i=0;i<tweets.length();i++) {
        tweet = tweets.getJSONObject(i);
        String s=tweets.getJSONObject(i).getString("text");
        if(selectTweet(s))
        {
        count++;
        String tweettext1=tweets.getJSONObject(i).getString("text");
        String tweettext=tweettext1.toLowerCase();
        int resultscore = Polarity.getPolarity(tweettext, inp, tagger);
              if (resultscore == 0)
              {
              System.out.println(tweettext);
              System.out.println("neutral");
              counter_neutral++;
              }
              else if (resultscore > 0)
              {
              System.out.println(tweettext);
              System.out.println("positive");
              counter_positive++;
              }
              else
              {
              System.out.println(tweettext);
              System.out.println("negative");
              counter_negative++;
              }
    }
         if((counter_positive+counter_negative+counter_neutral)==50)
        {
        break;
        }
        
 }
}
      System.out.println("Total tweets related to the product "+(counter_positive+counter_negative+counter_neutral));
      System.out.println("positive tweets "+counter_positive);
      System.out.println("negative tweets "+counter_negative);
      System.out.println("neutral tweets "+counter_neutral);

    }
}
