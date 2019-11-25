package ca.ubc.cs304.controller;

/***
    Page for selecting customer or clerk
 */
public class PageController1 extends PageController {

    public void onCustomerButtonClick() {
        setPage(PageController2a.class, "2a");
    }

    public void onClerkButtonClick() {
        setPage(PageController1_1b.class, "1_1b");
    }
}
