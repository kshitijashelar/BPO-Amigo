/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm;

import com.constant.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.DoubleStream;

/**
 *
 * @author Ganesh
 */
public class SlangWords implements Constant {

    public String getSlagWordConvertString(String review) {
        String slangwordFinalResult = null;
        try {
            String[] review_content = review.trim().split("\\s+");

            HashMap<String, String> map = new HashMap();
            File file = new File(SLAG_WORD_DICTIONARY_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line.trim()).append("\n");
                String[] splitStr = line.split("=");
                //------------- splitStr[0] = key , splitStr[1] = value ------------------
                map.put(splitStr[0], splitStr[1]);
            }
            StringBuilder finalOutput = new StringBuilder();
            for (String text : review_content) {
//                text = text.replaceAll("\\.", "");
//                text = text.replaceAll("\\?", "");
                int flag = 0;
                for (Entry<String, String> m : map.entrySet()) {
                    if (m.getKey().equals(text.toLowerCase())) {
                        if (m.getKey().equals(":*") || m.getKey().equals(":-*")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getValue().equals(":]") || m.getValue().equals(":)")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals(":p")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals(":(")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals("8-)")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals("8-|")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals("<3")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals("o-O")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals(":/")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else if (m.getKey().equals(">:O")) {
                            finalOutput.append(m.getValue()).append(" ");
                        } else {
                            finalOutput.append(m.getValue()).append(" ");
                        }
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    finalOutput.append(text).append(" ");
                }
            }
            slangwordFinalResult = finalOutput.toString().trim();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return slangwordFinalResult;
    }

    public String convertSmillyToStatement(String review) {
        StringBuilder builder = new StringBuilder();
        try {
            String[] words = review.split("\\s+");
            for (String word : words) {
                switch (word) {
                    case ":*":
                        builder.append("<img src=images/emotes-face-kiss.ico width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":-*":
                        builder.append("<img src=images/emotes-face-kiss.ico width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":]":
                        builder.append("<img src=images/smile.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":)":
                        builder.append("<img src=images/smile.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":p":
                        builder.append("<img src=images/yuck.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":(":
                        builder.append("<img src=images/sad.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case "8-)":
                        builder.append("<img src=images/glasses.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case "8-|":
                        builder.append("<img src=images/sunglasses.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case "<3":
                        builder.append("<a href=images/heart.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case "o-O":
                        builder.append("<img src=images/confused.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ":/":
                        builder.append("<img src=images/unsure.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    case ">:O":
                        builder.append("<img src=images/upset.jpg width=25 height=25 alt=").append(word).append("></img>").append(" ").append(word).append(" ");
                        break;
                    default:
                        builder.append(word).append(" ");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return builder.toString();
    }

//    public static void main(String[] args) {
//        SlangWords slangWords = new SlangWords();
//        String review = "ms dhoni is :-* filling  upset at night. ";
//        review = slangWords.convertSmillyToStatement(review);
//        System.out.println("CONVERT TO SMILLY : \n" + review);
//        review = Review.getStatementValidation(review);
//        String slangResult = slangWords.getSlagWordConvertString(review);
//        System.out.println("Slang Word Result : \n" + slangResult);
//        String[] statements = slangResult.split("\\.|\\?|and|or");
//        System.out.println("Total size : " + statements.length);
//        for (String stastement : statements) {
//            System.out.println(stastement);
//        }
//
//        System.out.println("Slang words : " + slangResult);
//    }
}
