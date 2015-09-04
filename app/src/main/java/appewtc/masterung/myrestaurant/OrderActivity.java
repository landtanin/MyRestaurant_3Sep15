package appewtc.masterung.myrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    //Explicit
    private TextView officerTextView;
    private Spinner deskSpinner;
    private ListView foodListView;
    private String officerString, deskString, foodString, itemString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Bind Widget
        bindWidget();

        //Show officer
        showOfficer();

        //Create Desk Spinner
        createDeskSpinner();

        //Create ListView
        createListView();

    }   // onCreate

    private void createListView() {

        FoodTABLE objFoodTABLE = new FoodTABLE(this);
        String[] strSource = objFoodTABLE.readAllSource();
        String[] strFood = objFoodTABLE.readAllFood();
        String[] strPrice = objFoodTABLE.readAllPrice();

        MyAdapter objMyAdapter = new MyAdapter(OrderActivity.this, strSource, strFood, strPrice);
        foodListView.setAdapter(objMyAdapter);


    }   // createListView

    private void createDeskSpinner() {
        final String[] strDeskArray = {"1A", "2A", "3A", "4A", "5A"};
        ArrayAdapter<String> deskAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strDeskArray);
        deskSpinner.setAdapter(deskAdapter);

        deskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deskString = strDeskArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                deskString = strDeskArray[0];
            }
        });

    }

    private void showOfficer() {
        officerString = getIntent().getStringExtra("Officer");
        officerTextView.setText(officerString);
    }

    private void bindWidget() {
        officerTextView = (TextView) findViewById(R.id.txtShowOfficer);
        deskSpinner = (Spinner) findViewById(R.id.spinner);
        foodListView = (ListView) findViewById(R.id.listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
