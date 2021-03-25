package com.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.algorithm.BayesClassifier;
import com.algorithm.Classifier;

public class RunnableExample {
    
    public static void main(String[] args) {

        /*
         * Create a new classifier instance. The context features are
         * Strings and the context will be classified with a String according
         * to the feature set of the context.
         */
        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();
        /*
         * Please note, that this particular classifier implementation will
         * "forget" learned classifications after a few learning sessions. The
         * number of learning sessions it will record can be set as follows:
         */
//        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
        
        /*
         * The classifier can learn from classifications that are handed over
         * to the learn methods. Imagin a tokenized text as follows. The tokens
         * are the text's features. The category of the text will either be
         * positive or negative.
         */
        final String[] positiveText = "I love sunny days".split("\\s");
        final String[] negativeText = "I hate rain".split("\\s");
        final String[] developer1 = "let declaration must be or switch body block".split("\\s");
        final String[] developer2 = "let declaration must be direct child of block top-level implicit block, or switch body block".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));
        bayes.learn("negative", Arrays.asList(negativeText));
//        bayes.learn("brendan@mozilla.org",Arrays.asList(developer1));
//        bayes.learn("nobody@mozilla.org",Arrays.asList(developer2));
        // to set new bugs features and predict the developer name
//        final String[] unknownBug = "let declaration must be direct child of block top-level implicit block, or switch body block".split("\\s");
//        System.out.println( // will output "positive"
//               "New Developer Assigned to bug is : "+ bayes.classify(Arrays.asList(unknownBug)).getCategory());
//	     ((BayesClassifier<String, String>) bayes).classifyDetailed(Arrays.asList(unknownDev));
//	      System.out.println("Total Category : "+bayes.getCategoriesTotal());
//	      System.out.println("Category : "+bayes.getCategories().toString());
//	      System.out.println("Features : "+bayes.getFeatures().toString());
//	      System.out.println("Probability : "+bayes.classify(Arrays.asList(unknownBug)).getProbability());
//          BayesClassifier<Collection, Collection> classifier = new BayesClassifier<Collection, Collection>();
//          classifier.classifyDetailed((Collection)bayes.getFeatures());
//         System.out.println("To see All Details : "+ classifier.toString());
        /*
         * Now that the classifier has "learned" two classifications, it will
         * be able to classify similar sentences. The classify method returns
         * a Classification Object, that contains the given featureset,
         * classification probability and resulting category.
         */
        final String[] unknownText1 = "let declaration  switch body block top-level implicit".split("\\s");
//        final String[] unknownText2 = "there will be rain".split("\\s");
//
//        System.out.println( // will output "positive"
//                bayes.classify(Arrays.asList(unknownText1)).getCategory());
//        System.out.println( // will output "positive"
//                bayes.classify(Arrays.asList(unknownText1)).getProbability());
//        System.out.println( // will output "positive"
//                bayes.classify(Arrays.asList(unknownText1)).getFeatureset());
//        System.out.println( // will output "negative"
//                bayes.classify(Arrays.asList(unknownText2)).getCategory());
//
//        System.out.println("Probability : "+bayes.classify(Arrays.asList(unknownText2)).getProbability());
        /*
         * The BayesClassifier extends the abstract Classifier and provides
         * detailed classification results that can be retrieved by calling
         * the classifyDetailed Method.
         *
         * The classification with the highest probability is the resulting
         * classification. The returned List will look like this.
         * [
         *   Classification [
         *     category=negative,
         *     probability=0.0078125,
         *     featureset=[today, is, a, sunny, day]
         *   ],
         *   Classification [
         *     category=positive,
         *     probability=0.0234375,
         *     featureset=[today, is, a, sunny, day]
         *   ]
         * ]
         */
        
     BayesClassifier<String, String> st = new BayesClassifier<String, String>();
     st.learn("Positive", Arrays.asList(positiveText));
     st.learn("Negative", Arrays.asList(negativeText));
     st.learn("Developer1",Arrays.asList(developer1));
     st.learn("Developer2",Arrays.asList(developer2));
     Collection<Classification<String, String>> classified = ((BayesClassifier<String, String>) st).classifyDetailed(Arrays.asList(unknownText1));
     Iterator<Classification<String, String>> iterator = classified.iterator();
     while(iterator.hasNext()) {
    	 Classification<String, String> c = iterator.next();
    	 System.out.println(c.getCategory() + " :: " + c.getProbability());
     }
//     System.out.println(st.classifyDetailed(Arrays.asList(unknownText1)).toString());
     
        
    }

}
