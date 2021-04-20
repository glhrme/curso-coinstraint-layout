package br.com.guisantos.guilhermeviagens.main.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }

    private void setaPreco() {
        TextView textoPreco = findViewById(R.id.ac_pagamento_preco_compra);
        textoPreco.setText(MoedaUtil.formataParaBrasileiro(this.pacote.getPreco()));
    }
}