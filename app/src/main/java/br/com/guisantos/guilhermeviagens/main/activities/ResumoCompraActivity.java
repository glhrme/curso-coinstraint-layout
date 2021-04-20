package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;
import br.com.guisantos.guilhermeviagens.main.utils.MoedaUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        this.pacote = (Pacote) this.getIntent().getSerializableExtra("pacote");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setCidade();
        this.setaPreco();
        this.setData();
        this.setaImagem();
    }

    private void setCidade() {
        TextView textoCidade = findViewById(R.id.ac_resumo_compra_cidade_texto);
        textoCidade.setText(this.pacote.getLocal());
    }

    private void setData() {
        TextView textoData = findViewById(R.id.ac_resumo_compra_data_texto);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE,this.pacote.getDias());
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");

        textoData.setText(formatoBrasileiro.format(dataIda.getTime()) + " - " + formatoBrasileiro.format(dataVolta.getTime()) + " de " + dataVolta.get(Calendar.YEAR));
    }

    private void setaPreco() {
        TextView textoPreco = findViewById(R.id.ac_resumo_compra_valor_pago);
        textoPreco.setText(MoedaUtil.formataParaBrasileiro(this.pacote.getPreco()));
    }

    private void setaImagem() { //Seta imagem no header
        ImageView imagem = findViewById(R.id.ac_resumo_compra_imagem_cidade);
        Resources resources = this.getResources();
        int idImagem = resources.getIdentifier(this.pacote.getImagem(), "drawable", this.getPackageName());
        imagem.setImageResource(idImagem);
    }
}