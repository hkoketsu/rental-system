package ca.ubc.cs304.controller;


public class PageController1 extends PageController {

    public void onCustomerButtonClick() {
        setPage(PageController2a.class, "2a");
    }

    public void onClerkButtonClick() {
        setPage(PageController2b.class, "2b");
    }
}
