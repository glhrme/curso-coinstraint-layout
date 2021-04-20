package br.com.guisantos.guilhermeviagens.main.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.guisantos.guilhermeviagens.R;
import br.com.guisantos.guilhermeviagens.main.models.Pacote;
import br.com.guisantos.guilhermeviagens.main.utils.MoedaUtil;

public class PacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public PacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return this.pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pacote pacote = this.pacotes.get(position);
        View viewGerada = LayoutInflater.from(this.context).inflate(R.layout.item_pacote_viagem, parent, false);
        mostraPreco(viewGerada, pacote);
        monstraCidade(viewGerada, pacote);
        monstraDias(viewGerada, pacote);
        mostraCidade(viewGerada, pacote);
        return viewGerada;
    }

    private void mostraCidade(View viewGerada, Pacote pacote) {
        ImageView imagem = viewGerada.findViewById(R.id.item_image_background_cidade);
        Resources resources = this.context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(),  "drawable", this.context.getPackageName());
        imagem.setImageResource(idDoDrawable);
    }

    private void monstraDias(View viewGerada, Pacote pacote) {
        TextView dias = viewGerada.findViewById(R.id.item_texto_dias);
        if(pacote.getDias() > 1) {
            dias.setText(pacote.getDias() + " dias");
        } else {
            dias.setText(pacote.getDias() + " dia");
        }
    }

    private void monstraCidade(View viewGerada, Pacote pacote) {
        TextView preco = viewGerada.findViewById(R.id.item_title_cidade_viagem);
        preco.setText(pacote.getLocal());
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_text_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
