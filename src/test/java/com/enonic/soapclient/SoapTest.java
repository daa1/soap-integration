package com.enonic.soapclient;

import com.enonic.soapclient.SoapClient;
import org.jdom.Document;
import org.jdom.Element;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SoapTest {
    @Test
    public void test() {
        Document doc = new SoapClient().GetWeather();
        Element root = doc.getRootElement();
        Element cities = root.getChild("city");
        System.out.println(cities.getText());
        assertEquals(cities.getText(), "Menlo Park");
    }
}
