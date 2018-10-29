package act3.app.com.evidencia1act4_android;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import act3.app.com.evidencia1act4_android.Models.Cliente_CURP;

public class persona_recycler extends Activity{
    private RecyclerView rRecyclerView;
    private RecyclerView.Adapter aAdapter;
    private RecyclerView.LayoutManager lLayoutManager;

    @Override
    protected void onCreate(Bundle saveBundle){
        super.onCreate(saveBundle);
        setContentView(R.layout.activity_persona_recycler);
        rRecyclerView = findViewById(R.id.recyclePersona);
        rRecyclerView.setHasFixedSize(true);

        lLayoutManager = new LinearLayoutManager(this);
        rRecyclerView.setLayoutManager(lLayoutManager);

        ArrayList<Cliente_CURP> curps.getCurps(this);
        aAdapter = new lista_persona_curp(curps);

        rRecyclerView.setAdapter(aAdapter);
    }


}
