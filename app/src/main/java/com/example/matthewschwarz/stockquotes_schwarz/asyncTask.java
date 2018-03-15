package com.example.matthewschwarz.stockquotes_schwarz;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by matthewschwarz on 3/15/18.
 */

public class asyncTask extends AsyncTask<String, Void, Stock>{
    private TextView stockSymbol, stockName, stockPrice, stockTime, stockChange, stockRange;

    private Context myContext;

    public asyncTask(TextView symbol, TextView name, TextView price, TextView time, TextView change, TextView range, Context context){
        stockSymbol = symbol;
        stockName = name;
        stockPrice = price;
        stockTime = time;
        stockChange = change;
        stockRange = range;
        myContext = context;
    }

    @Override
    protected void onPostExecute(Stock currStock){
        if(currStock != null){
            stockSymbol.setText(currStock.getSymbol());
            stockName.setText(currStock.getName());
            stockPrice.setText(currStock.getLastTradePrice());
            stockTime.setText(currStock.getLastTradeTime());
            stockChange.setText(currStock.getChange());
            stockRange.setText(currStock.getRange());
        }else{
            Toast.makeText(myContext, myContext.getString(R.string.nullStockError), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected Stock doInBackground(String... strings){
        Stock myStock = new Stock(strings[0]);
        try{
            myStock.load();
            return myStock;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
