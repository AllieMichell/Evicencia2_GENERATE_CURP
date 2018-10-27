package act3.app.com.evidencia1act4_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class personaslistRecycler extends AppCompatActivity {
    ArrayList<persona> listapersona = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout);
    }
}
