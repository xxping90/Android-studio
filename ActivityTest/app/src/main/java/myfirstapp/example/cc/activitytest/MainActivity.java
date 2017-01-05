package myfirstapp.example.cc.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d("firstActivity","Task id is " + getTaskId());

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "You click Button 1", Toast.LENGTH_SHORT).show();
//                finish();
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent("myfirstapp.example.cc.activitytest.ACTION_START");
//                intent.addCategory("myfirstapp.example.cc.activitytest.MY_CATEGORY");
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//                startActivityForResult(intent,1);

                SecondActivity.actionStart(MainActivity.this,"data1","data2");
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
       // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You click Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You click Remove",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return  true;
        //return super.onOptionsItemSelected(item);



        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String  returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);

                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
