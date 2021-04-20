package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.adapters.PacotesAdapter;
import br.com.guisantos.guilhermeviagens.main.dao.PacoteDAO;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.pacotes_app_title);

        ListView listaDePacotes = (ListView) findViewById(R.id.activity_main_lista_pacotes);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new PacotesAdapter(pacotes, this));
    }
}