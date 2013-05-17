/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdata;
import java.util.Collection;
import java.util.List;
import java.io.StringReader;

import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
/**
 *
 * @author HP
 */
public class Parser {



public static void dp(String sent2) {
  LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
    String[] sent = { "This", "is", "an", "easy", "sentence", "." };
    List<CoreLabel> rawWords = Sentence.toCoreLabelList(sent);
    
 //  parse.pennPrint();
    System.out.println();
   
   // String sent2 = "This is another sentence.";
    TokenizerFactory<CoreLabel> tokenizerFactory =
      PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
    List<CoreLabel> rawWords2 =
      tokenizerFactory.getTokenizer(new StringReader(sent2)).tokenize();
  Tree parse = lp.apply(rawWords2);
    //parse = lp.apply(rawWords2);

    TreebankLanguagePack tlp = new PennTreebankLanguagePack();
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
    List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
    System.out.println(tdl);
    System.out.println();

    TreePrint tp = new TreePrint("penn,typedDependenciesCollapsed");
    tp.printTree(parse);
    
  }

}
