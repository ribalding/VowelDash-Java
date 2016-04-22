public class VowelDash {
  public String convertVowels(String input){
    input = input.replace("A", "-");
    input = input.replace("a", "-");
    input = input.replace("E", "-");
    input = input.replace("e", "-");
    input = input.replace("I", "-");
    input = input.replace("i", "-");
    input = input.replace("O", "-");
    input = input.replace("o", "-");
    input = input.replace("U", "-");
    input = input.replace("u", "-");
    return input;
  }

  public Boolean compareAnswers(String guess, String answer){
    if (guess.equals(answer)){
      return true;
    } else {
      return false;
    }
  }
}
