package id.com.rxapp;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RxAdapter extends RecyclerView.Adapter<RxAdapter.RxHolder> {


    private final List<Entry> entries =new ArrayList<>();


    @NonNull
    @Override
    public RxAdapter.RxHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myOwnView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rx_data,parent,false);
        return new RxHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull RxAdapter.RxHolder holder, int position) {
        //holder.txtName.setText(entries.get(position));
        Entry entry = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setTxtPrice(entry.getEntryPrice());
        holder.setTxtDate(entry.getEntryDate());

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addStringToList(Entry entry){
        entries.add(entry);
        notifyItemInserted(entries.size()-1);
    }


    public class RxHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.txt_name)
        TextView txtName;

        @BindView(R.id.txt_price)
        TextView txtPrice;

        @BindView(R.id.txt_date)
        TextView txtDate;

        private final NumberFormat FORMAT_PRICE = new DecimalFormat("$#0.00");

        public RxHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public TextView getTxtName() {
            return txtName;
        }

        public void setTxtName(String en) {
            this.txtName.setText(en);
        }


        public void setTxtPrice(BigDecimal ep) {
            this.txtPrice.setText(FORMAT_PRICE.format(ep));
        }


        public void setTxtDate(Date ed) {
            this.txtDate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm",ed));
        }

    }
}
