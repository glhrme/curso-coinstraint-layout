package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;
import br.com.guisantos.guilhermeviagens.main.utils.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        this.pacote = (Pacote) this.getIntent().getSerializableExtra("pacote");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setaPreco();
        this.setaOnClickListener();
    }

    private void setaPreco() {
        TextView textoPreco = findViewById(R.id.ac_pagamento_preco_compra);
        textoPreco.setText(MoedaUtil.formataParaBrasileiro(this.pacote.getPreco()));
    }


    private void setaOnClickListener() {
        Button botaoFinalizarCompra = findViewById(R.id.ac_pagamento_botao_finalizar_compra);
        botaoFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarPagamento();
            }
        });
    }

    private void finalizarPagamento() {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra("pacote", this.pacote);
        startActivity(intent);
        this.finish();
    }
}