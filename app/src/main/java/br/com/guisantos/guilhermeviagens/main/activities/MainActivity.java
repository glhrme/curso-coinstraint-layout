package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.adapters.PacotesAdapter;
import br.com.guisantos.guilhermeviagens.main.dao.PacoteDAO;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;

public class MainActivity extends AppCompatActivity {
    private ListView listaDePacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.pacotes_app_title);
        List<Pacote> pacotes = new PacoteDAO().lista();

        this.listaDePacotes = findViewById(R.id.activity_main_lista_pacotes);
        this.listaDePacotes.setAdapter(new PacotesAdapter(pacotes, this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.configuraClickItemListView();
    }

    private void configuraClickItemListView() {
        this.listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                abreResumoPacote((Pacote) adapterView.getItemAtPosition(position));
            }
        });
    }

    private void abreResumoPacote(Pacote pacoteSelecionado) {
        Intent vaiParaResumoDoPacote = new Intent(MainActivity.this, ResumoPacoteActivity.class);
        vaiParaResumoDoPacote.putExtra("pacote", pacoteSelecionado);
        startActivity(vaiParaResumoDoPacote);
    }
}