import org.junit.*;
import static org.junit.Assert.*;

public class VowelDashTest{
  @Test
  public void convertVowels_wordWithNoVowels_sameString(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals("drgf", newVowelDash.convertVowels("drgf"));
  }

  @Test
  public void convertVowels_wordWithOneVowel_replacedString(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals("p-rty", newVowelDash.convertVowels("party"));
  }

  @Test
  public void convertVowels_wordWithMultipleVowels_replacedString(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals("h-ll-", newVowelDash.convertVowels("hello"));
  }

  @Test
  public void convertVowels_multipleWordsWithVowels_replacedString(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals("h-ll- w-rld, -'v- b--n w--t-ng f-r y--", newVowelDash.convertVowels("hello world, i've been waiting for you"));
  }

  @Test
    public void compareAnswers_match_true(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals(true, newVowelDash.compareAnswers("hello","hello"));
  }

  @Test
    public void compareAnswers_noMatch_false(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals(false, newVowelDash.compareAnswers("hello","heller"));
  }

  @Test
    public void compareAnswers_matchMultipleWords_true(){
    VowelDash newVowelDash = new VowelDash();
    assertEquals(true, newVowelDash.compareAnswers("hello world","hello world"));
  }
}
