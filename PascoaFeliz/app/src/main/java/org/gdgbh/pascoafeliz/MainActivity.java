package org.gdgbh.pascoafeliz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextQuantidade;
    private ImageView imageViewOvos;
    private TextView textViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    //Recuperar os elementos do XML
    private void initViews() {

        //O metodo findViewById() recupera a referencia do EditText que se encontra no XML.
        editTextQuantidade = (EditText) findViewById(R.id.edittext_quantidade);
        imageViewOvos = (ImageView) findViewById(R.id.imageview_ovos);
        textViewTotal = (TextView) findViewById(R.id.textview_total);
    }

    public void calcular(View view) {

        //Recuperamos o valor que o usuario digitou e usamos o valueOf da
        // classe Integer, para converter o valor em inteiro
        int quilos = Integer.valueOf(editTextQuantidade.getText().toString());
        int total = (quilos *1000)/500;
        
        String message  = "Com " + quilos + "kg de chocolate da para fazer " + total +  " ovos de 500g.";
        textViewTotal.setText(message);
    }
}
