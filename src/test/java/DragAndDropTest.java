import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by anton on 21.11.2023
 */
public class DragAndDropTest {

    @BeforeAll
    public static void beforeAll(){
        Configuration.baseUrl="https://the-internet.herokuapp.com/";
    }



    @Test
    void dragAndDropTest(){
        open("drag_and_drop");

        $("#column-a").dragAndDropTo($("#column-b"));

        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));

        //второй вариант через action поменял обратно
        actions().dragAndDrop($("#column-b"),$("#column-a")).perform();

        $("#column-a").shouldHave(Condition.text("A"));
        $("#column-b").shouldHave(Condition.text("B"));

    }
}
