package BYT9;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class WebsiteTest {
    Website web;
    Memento memento;
    URL address;

    @Before
    public void before() {
        web = mock(Website.class);
        memento = mock(Memento.class);
    }

    @Test
    public void TestUpdateModifiedDate() throws IOException, InterruptedException {
        doAnswer((i) -> {

            web.modifiedDate = new Date(System.currentTimeMillis());
            verify(web).modifiedDate.equals(System.currentTimeMillis());
            return null;
        }).when(web).updateModifiedDate();
    }

    @Test
    public void TestSaveStateToMemento() throws IOException {
        Date date = mock(Date.class);
        Mockito.when(web.saveStateToMemento()).thenReturn(memento);
        Assert.assertNotEquals(memento.getState(), System.currentTimeMillis() );


    }
}

