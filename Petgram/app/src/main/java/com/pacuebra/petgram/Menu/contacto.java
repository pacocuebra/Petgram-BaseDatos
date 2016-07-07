package com.pacuebra.petgram.Menu;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pacuebra.petgram.R;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto extends AppCompatActivity implements View.OnClickListener {

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText contacto, correo, mensaje;
    String con, cor, men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_contacto);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        Button enviar = (Button) findViewById(R.id.btenviarc);
        contacto = (EditText) findViewById(R.id.etnombrec);
        correo  = (EditText) findViewById(R.id.etcorreoc);
        mensaje  = (EditText) findViewById(R.id.etmensajec);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        con = contacto.getText().toString();
        cor = correo.getText().toString();
        men = mensaje.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        session = Session.getDefaultInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication("test1234@gmail.com","password");
        }
        });

        pdialog = ProgressDialog.show(context,"","Sending Mail...", true);

       RetreiveFeedTask task = new RetreiveFeedTask();
       task.execute();

    }

    class RetreiveFeedTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("fcbravo91@gmail.com"));
                //message.setRecipient(Message.RecipientType.TO, Address(cor));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(cor));
                message.setSubject(con);
                message.setContent(men,"text/html; charset=utf-8");
                Transport.send(message);

            } catch (MessagingException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            contacto.setText("");
            correo.setText("");
            mensaje.setText("");

            Toast.makeText(getApplicationContext(),"Mensaje Enviado",Toast.LENGTH_SHORT).show();
        }
    }
}
