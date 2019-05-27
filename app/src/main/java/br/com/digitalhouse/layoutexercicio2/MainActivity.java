package br.com.digitalhouse.layoutexercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edCompra;
    private EditText edDesconto;
    private Button btnCalcular;
    private double calcular;
    private double desconto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCompra = (EditText) findViewById(R.id.editCompra);
        edDesconto = (EditText) findViewById(R.id.editDesconto);
        btnCalcular = (Button) findViewById(R.id.btCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edCompra.getText().toString().equals("") || edDesconto.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Preenncha o campo.",Toast.LENGTH_SHORT).show();
                    edDesconto.requestFocus();
                    edCompra.requestFocus();
                    return;
                }
                calcular = Double.parseDouble(edCompra.getText().toString());
                desconto = Double.parseDouble(edDesconto.getText().toString());

                calcular = calcular - ((calcular * desconto) / 100);

                Toast.makeText(MainActivity.this,"O valor a ser pago é R$ " + calcular, Toast.LENGTH_SHORT).show();


            }
        });

    }
}
