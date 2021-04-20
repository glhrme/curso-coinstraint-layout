package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        this.setData();
        this.setOnClickListener();
    }

    private void setOnClickListener() {
        Button botaoFinalizaCompra = findViewById(R.id.resumo_pacote_botao_comprar);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaPagamento();
            }
        });
    }

    private void abreTelaPagamento() {
        Intent intentTelaPagamento = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intentTelaPagamento.putExtra("pacote", this.pacote);
        startActivity(intentTelaPagamento);
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
            textoDias.setText(this.pacote.getDias() + " dias");
        else
            textoDias.setText(this.pacote.getDias() + " dias");
    }

    private void setaPreco() {
        TextView textoPreco = findViewById(R.id.resumo_pacote_preco);
        textoPreco.setText(MoedaUtil.formataParaBrasileiro(this.pacote.getPreco()));
    }

    private void setData() {
        TextView textoData = findViewById(R.id.resumo_pacote_data_hora);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE,this.pacote.getDias());
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");

        textoData.setText(formatoBrasileiro.format(dataIda.getTime()) + " - " + formatoBrasileiro.format(dataVolta.getTime()) + " de " + dataVolta.get(Calendar.YEAR));
    }
}