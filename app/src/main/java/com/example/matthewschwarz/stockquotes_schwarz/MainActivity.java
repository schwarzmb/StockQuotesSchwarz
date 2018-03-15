package com.example.matthewschwarz.stockquotes_schwarz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView stockSymbol, stockName, stockPrice, stockTime, stockChange, stockRange;
    private EditText stockInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stockSymbol = findViewById(R.id.symbolShow);
        stockName = findViewById(R.id.nameShow);
        stockPrice = findViewById(R.id.priceShow);
        stockTime = findViewById(R.id.timeShow);
        stockChange = findViewById(R.id.changeShow);
        stockRange = findViewById(R.id.rangeShow);
        stockInput = findViewById(R.id.editText);

        //give handler for enter press on keyboard
        stockInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //if(actionId = EditorInfo.IME_ACTION_DONE && event.getAction() == KeyEvent.ACTION_UP)
                //if((actionId & EditorInfo.IME_MASK_ACTION)  != 0){
                if(actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    asyncTask currTask = new asyncTask(stockSymbol, stockName, stockPrice, stockTime, stockChange, stockRange, getApplicationContext());
                    String currInput = String.valueOf(stockInput.getText()).trim();
                    currTask.execute(currInput);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("stockSymbol", stockSymbol.getText().toString());
        savedInstanceState.putString("stockName", stockName.getText().toString());
        savedInstanceState.putString("stockPrice", stockPrice.getText().toString());
        savedInstanceState.putString("stockTime", stockTime.getText().toString());
        savedInstanceState.putString("stockChange", stockChange.getText().toString());
        savedInstanceState.putString("stockRange", stockRange.getText().toString());
        savedInstanceState.putString("editText", stockInput.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        stockSymbol.setText(savedInstanceState.getString("stockSymbol"));
        stockName.setText(savedInstanceState.getString("stockName"));
        stockPrice.setText(savedInstanceState.getString("stockPrice"));
        stockTime.setText(savedInstanceState.getString("stockTime"));
        stockChange.setText(savedInstanceState.getString("stockChange"));
        stockRange.setText(savedInstanceState.getString("stockChange"));
        stockInput.setText(savedInstanceState.getString("editText"));
    }
}
