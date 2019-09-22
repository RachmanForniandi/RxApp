package id.com.rxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tv_1)
    TextView tV1;

    @BindView(R.id.list_data)
    RecyclerView listData;

    private LinearLayoutManager layoutManager;
    private RxAdapter rxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        layoutManager = new LinearLayoutManager(this);
        rxAdapter = new RxAdapter();

        listData.setLayoutManager(layoutManager);
        listData.setAdapter(rxAdapter);
        Observable.just("List products & Prices").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tV1.setText(s);
            }
        });

        Entry entry1 = new Entry("Playstation 4", BigDecimal.valueOf(1500),new Date());
        Entry entry2 = new Entry("Xbox One", BigDecimal.valueOf(2000),new Date());
        Entry entry3 = new Entry("Xbox One S", BigDecimal.valueOf(2500),new Date());
        Entry entry4 = new Entry("Xbox One X", BigDecimal.valueOf(3500),new Date());
        Entry entry5 = new Entry("Sony Xperia XZ", BigDecimal.valueOf(2500),new Date());
        Observable.just(entry1,entry2,entry3,entry4,entry5).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Exception {
                rxAdapter.addStringToList(entry);
            }
        });

    }
}
