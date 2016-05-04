package eu.glyphe.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View.OnClickListener detectClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"Click sur nadal",Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.federer).setOnClickListener(this);
        this.findViewById(R.id.nadal).setOnClickListener(this);
        this.findViewById(R.id.schiavone).setOnClickListener(this);
        ;

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,infoActivity.class);
        intent.putExtra("NAME",v.getId());
        startActivity(intent);

    }
}
