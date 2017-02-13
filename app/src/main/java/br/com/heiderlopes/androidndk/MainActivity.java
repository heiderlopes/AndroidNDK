package br.com.heiderlopes.androidndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private TextView tvDataAtual;
    private EditText etValor1;
    private EditText etValor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvDataAtual = (TextView) findViewById(R.id.tvDataAtual);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);

        //Chamado o método para exibir a data atual
        tvDataAtual.setText(getDataAtualJNI());
    }

    public void somar(View v) {
        tvResultado.setText(String.valueOf(somaJNI(
                Integer.parseInt(etValor1.getText().toString()),
                Integer.parseInt(etValor2.getText().toString()))));
    }

    static {
        System.loadLibrary("hello-jni");
    }

    public native String getDataAtualJNI();

    public native int somaJNI(int i, int j);
}
