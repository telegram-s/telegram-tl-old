package org.telegram.tl.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import org.telegram.api.*;
import org.telegram.tl.TLContext;

public class TestActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTest();
            }
        });
    }

    private void doTest() {
        String time = "";
        long start = System.currentTimeMillis();
        TLContext context = new TLApiContext();
        long duration = (System.currentTimeMillis() - start);
        time += "Context init: " + duration + " ms\n";

        TLUserContact[] contacts = new TLUserContact[1000 * 100];
        start = System.currentTimeMillis();
        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = new TLUserContact();
        }
        duration = (System.currentTimeMillis() - start);
        time += "Instance TLUserContact: " + duration + " ms\n";

        start = System.currentTimeMillis();
        for (int i = 0; i < contacts.length; i++) {
            // new TLDcOption();
            new Object();
        }
        duration = (System.currentTimeMillis() - start);
        time += "Instance Object: " + duration + " ms\n";

        start = System.currentTimeMillis();
        for (int i = 0; i < contacts.length; i++) {
            contacts[i].getClassId();
        }
        duration = (System.currentTimeMillis() - start);
        time += "getClassId: " + duration + " ms\n";

        start = System.currentTimeMillis();
        for (int i = 0; i < contacts.length; i++) {
            String a = contacts[i].getFirstName();
        }
        duration = (System.currentTimeMillis() - start);
        time += "getFirstName: " + duration + " ms\n";

        ((TextView) findViewById(R.id.debugText)).setText(time);
        Log.d("TLTEST", time);
    }
}
