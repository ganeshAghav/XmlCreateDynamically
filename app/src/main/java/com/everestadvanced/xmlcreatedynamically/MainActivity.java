package com.everestadvanced.xmlcreatedynamically;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    String MainTags[]={"<root>"};
    String MainTagsClose[]={"</root>"};

    String allMainTags[]={"<Float>"};
    String allMainTagsClose[]={"</Float>"};

    String allMainSubTags[]={"<Amount>","<CrDr>","<PaymentModeID>","<PaymentTypeID>","<IsDeposit>"
            ,"<Remark>","<RefNo>","<CreatedBy>","<IsAuto>"};
    String allMainSubTagsClose[]={"</Amount>","</CrDr>","</PaymentModeID>","</PaymentTypeID>","</IsDeposit>"
            ,"</Remark>","</RefNo>","</CreatedBy>","</IsAuto>"};

    String newLine="\n";
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearMain);
        txtResult=(TextView) findViewById(R.id.result);

        StringBuffer stringBuffer=new StringBuffer();

        //for loop for main tags
        for(int k=0;k<MainTags.length;k++) //<root>
        {
            //adding main tags <root>
            stringBuffer.append(newLine+MainTags[k]);

            //Create for loop for sub main tags
            for(int j=0;j<allMainTags.length;j++) //<Float>
            {
                //creating main tags <Float>
                stringBuffer.append(newLine+allMainTags[j]);

                //add sub tags
                if(allMainTags[j].equals("<Float>"))
                {
                    for(int i=0;i<allMainSubTags.length;i++) //<Amount>
                    {
                        //creating sub main tags <Amount>
                        stringBuffer.append(newLine+allMainSubTags[i]);

                        //add <Amount> values
                        if(allMainSubTags[i].equals("<Amount>"))
                        {
                            stringBuffer.append("Float Amount");
                        }
                        //add <CrDr> values
                        if(allMainSubTags[i].equals("<CrDr>"))
                        {
                            stringBuffer.append("CR");
                        }

                        //add <PaymentModeID> values
                        if(allMainSubTags[i].equals("<PaymentModeID>"))
                        {
                            stringBuffer.append("1");
                        }

                        //add <PaymentTypeID> values
                        if(allMainSubTags[i].equals("<PaymentTypeID>"))
                        {
                            stringBuffer.append("2");
                        }

                        //add <IsDeposit> values
                        if(allMainSubTags[i].equals("<IsDeposit>"))
                        {
                            stringBuffer.append("True");
                        }

                        //add <Remark> values
                        if(allMainSubTags[i].equals("<Remark>"))
                        {
                            stringBuffer.append("Tigo Pesa Float date: 29-11-2017 Sender Name GODFREY\n" +
                                    "MTEMA3");
                        }
                        //add <RefNo> values
                        if(allMainSubTags[i].equals("<RefNo>"))
                        {
                            stringBuffer.append("15055");
                        }
                        //add <CreatedBy> values
                        if(allMainSubTags[i].equals("<CreatedBy>"))
                        {
                            stringBuffer.append("1");
                        }
                        //add <IsAuto> values
                        if(allMainSubTags[i].equals("<IsAuto>"))
                        {
                            stringBuffer.append("True");
                        }

                        stringBuffer.append(allMainSubTagsClose[i]);

                    }

                }

                //closing main sub tags tags
                stringBuffer.append(newLine+allMainTagsClose[j]);
            }
            stringBuffer.append(newLine+MainTagsClose[k]);
            txtResult.setText(stringBuffer);
        }
    }
}
