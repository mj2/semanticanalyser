package twitterdata;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class Polarity {
    public static String sentiwordType(String str)
    {
    if(str.equals("JJ")|| str.equals("JJR")||str.equals("JJS"))
    return "a";
    if(str.equals("NN")||str.equals("NNS")||str.equals("NP")||str.equals("NPS"))
    return "n";
    if(str.equals("RB")||str.equals("RBR")||str.equals("RBS"))
    return "r";
    if(str.equals("VB")||str.equals("VBD")||str.equals("VBG")||str.equals("VBN")||str.equals("VBP")||str.equals("VBZ"))
    return "v";
    return "s";
    }
    public static int getPolarity(String tweet,String inp,MaxentTagger tagger)throws IOException,
 ClassNotFoundException
    {
    int result=0;
    TagText p=new TagText();
    double resultscore=0;
    String tagged=p.stringtagger(tweet,tagger);
    String[] data = tagged.split(" ");
    String ngram="";
    for(String W:data)
    {
        String[] wt=W.split("_");
        ngram =ngram+wt[1]+" ";
    }
    System.out.println(tagged);
         for(String w:data)
         {
            String[] wt = w.split("_");
            SWN3 s = new SWN3();
            String type=sentiwordType(wt[1]);
            if(!type.equals("s"))
            {
                if(type.equals("v")||type.equals("r"))
                {
                    double tempscore=s.score(wt[0],type);
                    if(tempscore<s.score(wt[0],"a"))
                    {
                        resultscore+=s.score(wt[0],"a");
                        System.out.println("Score of "+wt[0]+" is "+s.score(wt[0],"a"));
                    }
                    else
                    {
                        resultscore += s.score(wt[0], type);
                        System.out.println("Score of "+wt[0]+" is "+s.score(wt[0], type));
                    }
                   }
                   else
                   {
                        resultscore += s.score(wt[0], type);
                        System.out.println("Score of "+wt[0]+" is "+s.score(wt[0], type));
                    }

                 }
                }
         if(tweet.contains("not"))
         {
             resultscore=resultscore*(-1);
         }
System.out.println("total score is "+resultscore);
if(resultscore>0)
{
    result=1;
}
else if(resultscore<0)
{
    result=-1;
}
else
{
    result=0;
}
return result;
}
}
