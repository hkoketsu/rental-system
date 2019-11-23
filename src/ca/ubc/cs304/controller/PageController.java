package ca.ubc.cs304.controller;

import ca.ubc.cs304.app.App;

public class PageController {
    private App application;

    public void setApp(App application) {
        if (application != null) {
            this.application = application;
        }
    }

    public void setPage(Class<? extends PageController> controller, String pageNumber, Object[]...params) {
        application.setPage(controller, pageNumber, params);
    }

    public void loadParameter(Object[]...params) {}
}
