package act3.app.com.evidencia1act4_android;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import act3.app.com.evidencia1act4_android.Models.Cliente_CURP;

public class lista_persona_curp extends RecyclerView.Adapter<lista_persona_curp.ViewHolderInfo>{
    private ArrayList<Cliente_CURP> listaCurp;
    public TextView codigo, nombre, apellidop, apellidom, entidadF, sexo, fechaD, fechaM, fechaA, curp;
    public class ViewHolderInfo extends RecyclerView.ViewHolder{
        public ViewHolderInfo(@NonNull View view){
            super(view);
             codigo = view.findViewById(R.id.v_Codigo);
             apellidop = view.findViewById(R.id.v_ApellidoP);
             apellidom = view.findViewById(R.id.v_ApellidoM);
             nombre= view.findViewById(R.id.v_Nombre);
             sexo = view.findViewById(R.id.v_Sexo);
             fechaD = view.findViewById(R.id.v_FechaD);
             fechaM = view.findViewById(R.id.v_FechaM);
             fechaA = view.findViewById(R.id.v_FechaA);
             entidadF = view.findViewById(R.id.v_EntidadF);
             curp = view.findViewById(R.id.v_CURPGeneradaText);
        }
    }
    public lista_persona_curp(ArrayList<Cliente_CURP> listaCurp) {
        this.listaCurp = listaCurp;
    }
    @NonNull
    @Override
    public lista_persona_curp.ViewHolderInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_lista_persona_curp, viewGroup, false);
        return new ViewHolderInfo(view);
    }
    @Override
    public void onBindViewHolder(@NonNull lista_persona_curp.ViewHolderInfo viewHolderInfo, int i){
        Cliente_CURP c = listaCurp.get(i);

        codigo.setText(c.getCodigo());
        apellidop.setText(c.getApellidop());
        apellidom.setText(c.Appellidom());
        nombre.setText(c.getNombre());
        sexo.setText(c.getSex());
        fechaD.setText(c.getFechaD());
        fechaM.setText(c.getFechaM());
        fechaA.setText(c.getFechaA());
        entidadF.setText(c.getEntidadF());
        curp.setText(c.getCurp());
    }
    @Override
    public int getItemCount(){
        try{
            return listaCurp.size();
        }catch (Exception e) {
            return 0;
        }
    }



}
