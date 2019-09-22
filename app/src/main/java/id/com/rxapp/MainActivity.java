package id.com.rxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

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
        Observable.just("What's up dude?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tV1.setText(s);
            }
        });

        Observable.just("Mordecai","Rigby","Skips","Muscle Man","Benson","Hi 5 Ghost","Thomas").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                rxAdapter.addStringToList(s);
            }
        });

    }
}
