/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
  
  char[] special = new char[]{'.', '?'};
  
  public static void main(String[] args) {
    JUnitCore.main("Solution"); 
  }
  
  @Test
  public void testIsValidSentence_validcase() {
    String sentence = "hello world. how is the weather today?";
    List<String> dic = new ArrayList<String>(Arrays.asList("hello", "world", "how", "is", "the", "weather", "today"));
    
    Assert.assertTrue(isValidSentence(sentence, dic));
    
    
  } 
  
  @Test
  public void testIsValidSentence_inValidcase() {
    String sentence = "hello world. how is the weather today?";
    List<String> dic = new ArrayList<String>(Arrays.asList("hello", "world", "how", "is", "the", "weather"));
    
    Assert.assertFalse(isValidSentence(sentence, dic));
  }
  
  
  
  // Given a string and a dictionary of words print whether the string is valid or not
  private boolean isValidSentence(String str, List<String> dictionary){
    // convert dictionary into hash so that look up can be on a constant time
    Map<String, Boolean> dict_map = new HashMap<>();
    dictionary.forEach(word -> {
      dict_map.put(word, true);
    });
    
    
    // go through each word and look up in the map. As soon as a word is not found
    // then break the loop and return.
    String[] words = str.split(" ");
    boolean wordNotFound = false;
    for(String word : words){
      word = trimSpecialCharacters(word);
      Boolean value = dict_map.get(word);
      if(value == null){
        wordNotFound = true;
        break;
      }
    }
    
    return !wordNotFound;
  }
  
  // takes a string and replaces any special characters
  //
  private String trimSpecialCharacters(String str){
    StringBuilder result = new StringBuilder(str);
    for(char c : special){
      int start = str.indexOf(c);
      if(start < 0){
        continue;
      }
      int end = start + 1;
      result = result.replace(start, end, "");
    }
    return result.toString();
  }
  
  
}