package fi.unju.farmajuy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.unju.farmajuy.adaptadores.AdaptadorDetalleProducto;
import fi.unju.farmajuy.entidades.Farmacia;

public class FarmaciasConStockActivity extends AppCompatActivity {

    RecyclerView recyclerViewFarmacias;
    ArrayList<Farmacia> farmaciasConStock;
    //Double precioProducto;
    ArrayList<Double> preciosProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle activityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_farmacia);

        if (activityBundle != null){

            farmaciasConStock = (ArrayList<Farmacia>) activityBundle.getSerializable("listaFarmaciasConStock");
            //precioProducto = activityBundle.getDouble("precioProducto");
            preciosProducto = (ArrayList<Double>) activityBundle.getSerializable("preciosProducto");

            recyclerViewFarmacias = (RecyclerView) findViewById(R.id.recyclerViewFarmaciasConStock);
            recyclerViewFarmacias.setLayoutManager( new LinearLayoutManager(this));

            //AdaptadorDetalleProducto adaptadorDetalleProducto = new AdaptadorDetalleProducto(this, farmaciasConStock, precioProducto);
            AdaptadorDetalleProducto adaptadorDetalleProducto = new AdaptadorDetalleProducto(this, farmaciasConStock, preciosProducto);
            recyclerViewFarmacias.setAdapter(adaptadorDetalleProducto);
        }

    }
}
