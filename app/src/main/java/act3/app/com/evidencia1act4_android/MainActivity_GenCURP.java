package act3.app.com.evidencia1act4_android;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import act3.app.com.evidencia1act4_android.Models.Cliente_CURP;

public class MainActivity_GenCURP extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    Spinner estados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__gen_curp);

        final TextInputEditText codigo = (TextInputEditText) findViewById(R.id.in_codigo);
        final TextInputEditText apellidop = (TextInputEditText) findViewById(R.id.in_apellidop);
        final TextInputEditText apellidom = (TextInputEditText) findViewById(R.id.in_apellidom);
        final TextInputEditText nombre = (TextInputEditText) findViewById(R.id.in_nombre);
        final RadioGroup sexo = (RadioGroup) findViewById(R.id.radio_genero);
        final EditText fechanD = (EditText) findViewById(R.id.in_dia);
        final EditText fechanM = (EditText) findViewById(R.id.in_mes);
        final EditText fechanA = (EditText) findViewById(R.id.in_anio);
        final Spinner entidadf = (Spinner) findViewById(R.id.sp_estados);
        estados = (Spinner)findViewById(R.id.sp_estados);
        ArrayAdapter<CharSequence> eleccion = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_spinner_item);
        estados.setAdapter(eleccion);
        Button aceptar = (Button) findViewById(R.id.btn_cre);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity_GenCURP.this, Activity_CURP.class);


                Cliente_CURP cliente_curp =  new Cliente_CURP(codigo.getText().toString(),
                        apellidop.getText().toString(),
                        apellidom.getText().toString(),
                        nombre.getText().toString(),
                        ((RadioButton)findViewById(sexo.getCheckedRadioButtonId())).getText().toString(),
                        fechanD.getText().toString(),
                        fechanM.getText().toString(),
                        fechanA.getText().toString(),
                        entidadf.getSelectedItem().toString());

                intent.putExtra("cliente_curp", cliente_curp);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_back:
                Toast.makeText(this, "Regresar", Toast.LENGTH_SHORT).show();
                finish();
                return true;

            case R.id.menu_settings:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_codigo:
                Toast.makeText(this, "50EE6", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_logout:
                Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
