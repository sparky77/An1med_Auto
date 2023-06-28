package Models;

import Helper.PageHelper;
import org.junit.Test;
import org.openqa.selenium.By;

public class  Customer extends PageHelper {

    enum CustomerActions{
    ADDTOCART, SEARCH
}

    CustomerActions actions;

    public void customerActions(String customerAction) {
        switch (actions) {
            case SEARCH:
                System.out.println("*******************************");
                System.out.println("Customer is performing a search");
                System.out.println("Customer is performing a search");
                System.out.println("Testing for ci");
                //search(customerAction);
                //click(By.cssSelector("testing"));

                System.out.println("*******************************");
                System.out.println("Customer is performing a search");
                break;
            case ADDTOCART:
                System.out.println("Customer is adding product to cart");
                break;
            default:
                System.out.println("** ERROR ** Customer action is not valid, please try again.");
                break;
        }
    }

/*    @Test
    public void enumTest(){
        actions = CustomerActions.SEARCH;
        //customerActions();
    }*/

    public void runSearch(String searchTerm){
        actions = CustomerActions.SEARCH;
        customerActions(searchTerm);
    }

}
