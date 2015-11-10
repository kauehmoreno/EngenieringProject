package rkj.com.engenieringproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText comprimento;
    private EditText largura;
    private EditText altura;

    private Button calcularBtn;

    private TextView volumeTextView;
    private TextView pedraTextView;
    private TextView areiaTextView;
    private TextView aguaTextView;
    private TextView cimentoTextView;
    /*
        Metodo oncreat, principal metodo do mainAcitivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
            Associando editText, button and textView
         */
        comprimento = (EditText) findViewById(R.id.comprimetoField);
        largura =(EditText) findViewById(R.id.larguraField);
        altura = (EditText) findViewById(R.id.alturaField);

        calcularBtn = (Button) findViewById(R.id.calcular);

        volumeTextView = (TextView) findViewById(R.id.volumeTextView);
        pedraTextView = (TextView) findViewById(R.id.pedraTextView);
        areiaTextView = (TextView) findViewById(R.id.areiaTextView);
        aguaTextView = (TextView) findViewById(R.id.aguaTextView);
        cimentoTextView = (TextView) findViewById(R.id.cimentoTextView);

        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comprimento.getText().length()>0 && largura.getText().length()>0 &&
                        altura.getText().length()>0) {

                    Double compri = Double.parseDouble(comprimento.getText().toString());
                    Double width = Double.parseDouble(largura.getText().toString());
                    Double height = Double.parseDouble(altura.getText().toString());

                    Double resultadoVolume = Math.ceil(compri * width * height);
                    Double resultadoPedra = Math.ceil((resultadoVolume * 0.09) / 0.23);
                    Double resultadoAreia = Math.ceil((resultadoVolume * 0.072) / 0.23);
                    Double resultadoAgua = Math.ceil((resultadoVolume * 22.5) / 0.23);
                    Double resultadoCimento = Math.ceil(resultadoVolume / 0.23);

                    volumeTextView.setText(Double.toString(resultadoVolume));
                    pedraTextView.setText(Double.toString(resultadoPedra));
                    areiaTextView.setText(Double.toString(resultadoAreia));
                    aguaTextView.setText(Double.toString(resultadoAgua));
                    cimentoTextView.setText(Double.toString(resultadoCimento));
                }else{
                    Toast.makeText(MainActivity.this,"Por favor insira todos os campos ",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
