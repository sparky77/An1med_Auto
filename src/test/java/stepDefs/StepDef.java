package stepDefs;

import com.qascript.FirstTest;
import io.cucumber.java.en.Given;

public class StepDef {
    @Given("I have {int} cats in my house, and need to buy more food")
    public void I_have_cats_and_need_food(int cats) {
        FirstTest firstTest = new FirstTest();
        firstTest.OpenBrowserTest();
        //System.out.println("Number of CATS  : " + cats);
    }
}
