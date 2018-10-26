package act3.app.com.evidencia1act4_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import act3.app.com.evidencia1act4_android.Models.Cliente_CURP;

public class Activity_CURP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__curp);

        TextView codigoText = (TextView) findViewById(R.id.txt_Codigo);
        TextView apellidoPText = (TextView) findViewById(R.id.txt_ApellidoP);
        TextView apellidoMText = (TextView) findViewById(R.id.txt_ApellidoM);
        TextView nombreText = (TextView) findViewById(R.id.txt_Nombre);
        TextView sexoText = (TextView) findViewById(R.id.txt_Sexo);
        TextView fechaDText = (TextView) findViewById(R.id.txt_FechaD);
        TextView fechaMText = (TextView) findViewById(R.id.txt_FechaM);
        TextView fechaAText = (TextView) findViewById(R.id.txt_FechaA);
        TextView entidadFText = (TextView) findViewById(R.id.txt_EntidadF);
        TextView curpText = (TextView) findViewById(R.id.txt_CURPGeneradaText);

        Bundle extras = getIntent().getExtras();

        Cliente_CURP cliente_curp = extras.getParcelable("cliente_curp");

        if(cliente_curp != null){
            //String codigo = extras.getString("codigoText");
            codigoText.setText(cliente_curp.getCodigo());

            //String apellidop = extras.getString("apellidoPText");
            apellidoPText.setText(cliente_curp.getApellidop());

            //String apellidom = extras.getString("apellidoMText");
            apellidoMText.setText(cliente_curp.getApellidom());

            //String nombre = extras.getString("nombreText");
            nombreText.setText(cliente_curp.getNombre());

            //String sexo = extras.getString("sexoText");
            sexoText.setText(cliente_curp.getSexo());

            //String fechad = extras.getString("fechaDText");
            fechaDText.setText(cliente_curp.getFechanD());

            //String fecham = extras.getString("fechaMText");
            fechaMText.setText(cliente_curp.getFechanM());

            //String fechaa = extras.getString("fechaAText");
            fechaAText.setText(cliente_curp.getFechanA());

            //String entidadf = extras.getString("entidadFText");
            entidadFText.setText(cliente_curp.getEntidadf());

            //((TextView)findViewById(R.id.txt_CURPGeneradaText)).setText(cliente_curp.getCURP());
            curpText.setText(cliente_curp.getCurp());

        }
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
