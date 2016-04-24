import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/quiz", (request,response) ->{
      HashMap model = new HashMap();
      model.put("template", "templates/quiz.vtl");
      String phrase = request.queryParams("inputText");
      VowelDash newVowelDash = new VowelDash();
      String newPhrase = newVowelDash.convertVowels(phrase);
      model.put("answer", phrase);
      model.put("clue", newPhrase);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/answer", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/answer.vtl");
      VowelDash newerVowelDash = new VowelDash();
      String answer = request.queryParams("answer");
      String guess = request.queryParams("quizInput");
      Boolean guessResult = newerVowelDash.compareAnswers(guess, answer);
      model.put("guessResult", guessResult);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
