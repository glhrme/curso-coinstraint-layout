package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;
import br.com.guisantos.guilhermeviagens.main.utils.MoedaUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do Pacote");
        this.pacote = (Pacote) this.getIntent().getSerializableExtra("pacote");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setaImagem(); //Seta imagem no header
        this.setaTitleCidade();
        this.setaDias();
        this.setaPreco();
    }

    private void setaImagem() { //Seta imagem no header
        ImageView imagem = findViewById(R.id.resumo_pacote_header_cidade);
        Resources resources = this.getResources();
        int idImagem = resources.getIdentifier(this.pacote.getImagem(), "drawable", this.getPackageName());
        imagem.setImageResource(idImagem);
    }

    private void setaTitleCidade() {
        TextView textoCidade = findViewById(R.id.resumo_pacote_cidade_title);
        textoCidade.setText(this.pacote.getLocal());
    }

    private void setaDias() {
        TextView textoDias = findViewById(R.id.resumo_pacote_quantidade_dias);
        if(this.pacote.getDias() > 1)
            textoDias.setText(this.pacote.getDias() + "dias");
        else
            textoDias.setText(this.pacote.getDias() + "dias");
    }

    private void setaPreco() {
        TextView textoPreco = findViewById(R.id.resumo_pacote_preco);
        textoPreco.setText(MoedaUtil.formataParaBrasileiro(this.pacote.getPreco()));
    }
}