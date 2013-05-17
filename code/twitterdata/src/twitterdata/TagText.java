package twitterdata;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class TagText
{
 public  String stringtagger(String sample,MaxentTagger tagger) throws IOException,
 ClassNotFoundException
    {
     String tagged = tagger.tagString(sample);
     return tagged;
}
}


