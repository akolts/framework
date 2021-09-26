/*
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.tests.components.ui;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WebBrowser;
import com.vaadin.tests.components.AbstractReindeerTestUI;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class UIInitBrowserDetails extends AbstractReindeerTestUI {

    static final String EXPECTED_MPR_UI_ID_LABEL_ID =
            "expected-mpr-ui-id-label-id";
    static final String ACTUAL_MPR_UI_ID_LABEL_ID =
            "actual-mpr-ui-id-label-id";
    static final String POPULATE_MPR_UI_BUTTON_ID = "populate-mpr-ui-button-id";
    static final String TRIGGER_MPR_UI_BUTTON_ID = "trigger-mpr-ui-button-id";

    private GridLayout l = new GridLayout(3, 1);
    private VaadinRequest r;

    @Override
    protected void setup(VaadinRequest request) {
        r = request;
        l.setWidth("100%");
        addComponent(l);

        Page p = getPage();
        WebBrowser wb = p.getWebBrowser();

        addDetail("location", "v-loc", p.getLocation());

        addDetail("browser window width", "v-cw", p.getBrowserWindowWidth());
        addDetail("browser window height", "v-ch", p.getBrowserWindowHeight());
        addDetail("screen width", "v-sw", wb.getScreenWidth());
        addDetail("screen height", "v-sh", wb.getScreenHeight());

        addDetail("timezone offset", "v-tzo", wb.getTimezoneOffset());
        addDetail("raw timezone offset", "v-rtzo", wb.getRawTimezoneOffset());
        addDetail("dst saving", "v-dstd", wb.getDSTSavings());
        addDetail("dst in effect", "v-dston", wb.isDSTInEffect());
        addDetail("current date", "v-curdate", wb.getCurrentDate());
        addDetail("mpr ui id", "v-mui", "");
    }

    private void addDetail(String name, String param, Object value) {
        Label requestLabel = new Label(r.getParameter(param));
        requestLabel.setId(param);
        Label browserLabel = new Label("" + value);
        browserLabel.setId(name);
        l.addComponents(new Label(name), requestLabel, browserLabel);
    }

    @Override
    public String getTestDescription() {
        return "Browser details should be available in UI init";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(9037);
    }
}
