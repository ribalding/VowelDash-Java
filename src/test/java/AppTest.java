import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void indexContainsTitle(){
    goTo("http://localhost:4567");
    assertThat(pageSource()).contains("Guess the Phrase");
  }

  @Test
  public void convertVowelsReturnsCorrectly(){
    goTo("http://localhost:4567");
    fill("#inputText").with("hello world");
    submit(".btn");
    assertThat(pageSource()).contains("h-ll- w-rld");
  }

  @Test
  public void guessAnswerMatchReturnsCorrect(){
    goTo("http://localhost:4567");
    fill("#inputText").with("hello world");
    submit("#phraseSubmit");
    fill("#quizInput").with("hello world");
    submit("#quizSubmit");
    assertThat(pageSource()).contains("Correct!");
  }
}
