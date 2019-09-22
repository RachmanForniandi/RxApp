package id.com.rxapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RxAdapter extends RecyclerView.Adapter<RxAdapter.RxHolder> {


    private final List<String> stringValues=new ArrayList<>();


    @NonNull
    @Override
    public RxAdapter.RxHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myOwnView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rx_data,parent,false);
        return new RxHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull RxAdapter.RxHolder holder, int position) {
        holder.txtName.setText(stringValues.get(position));
    }

    @Override
    public int getItemCount() {
        return stringValues.size();
    }

    public void addStringToList(String value){
        stringValues.add(value);
        notifyItemInserted(stringValues.size()-1);
    }


    public class RxHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_name)
        TextView txtName;

        public RxHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
