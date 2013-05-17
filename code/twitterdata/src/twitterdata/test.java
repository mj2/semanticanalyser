/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdata;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 *
 * @author HP
 */
public class test {
public static void main(String[] args) throws Exception {
        Polarity pol = new Polarity();
        MaxentTagger tagger = new MaxentTagger("F:\\New folder\\project\\stanford-postagger-2012-11-11\\models\\wsj-0-18-left3words.tagger");
        String inp="";
    //   String tweettext="my samsung galaxy s3 has frozen twice this morning. loads of problem. terrible phone. never have a fault free day with it!!!";
    //    String tweettext="awesome phone I love it the samsung galaxy s3 is amazing";
      // String tweettext="samsung galaxy s3 is the greatest phone ever. Had this phone for months :)";
       String tweettext="my samsung mobile is not awesome";
     //   String tweettext="i'm using nokia lumia 610.can you help me?";
//String tweettext="my stupid samsung galaxzy note wont work";
        // String tweettext="Battery of my cell is draining superb fast,samsung sucks";
        // String tweettext="i am loving my new samsumg galaxy s3";
        //    String tweettext="hell samsung nokia is the best";
        //  String tweettext="my samsung galaxy working good";
   //     String tweettext = "samsung is not awesome";
        // Parser P=new Parser();
        //  P.dp(tweettext);
 //System.out.println(tweet.getString("from_user")+" at "+tweet.getString("created_at"));
        //   System.out.println(tweets.getJSONObject(i).getString("text")+"\n");
  //      String inp = "samsung";
      //  String tweettext="samsung galaxy s3 is not not awesome";
     // String tweettext="my mum got the samsung galaxy s3";
    //  String tweettext="ready to become a samsung galaxy s3 owner";

        int resultscore = Polarity.getPolarity(tweettext, inp, tagger);
       // System.out.println("total score is "+resultscore);
         if (resultscore == 0) {
             System.out.println(tweettext);
              System.out.println("neutral");

        } else if (resultscore > 0) {
            System.out.println(tweettext);
            System.out.println("positive");

        } else {
            System.out.println(tweettext);
            System.out.println("negative");

        }
}

}
