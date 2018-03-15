import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by matthewschwarz on 3/14/18.
 */

public class asyncTask extends AsyncTask<String, Void, String>{
    private TextView stockSymbol, stockName, stockPrice, stockTime, stockChange, stockRange;

    private Context myContext;
    ArrayList<String> stockList;

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
    protected void onPostExecute(String sting){

    }

    @Override
    protected String doInBackground(String... String){
        Stock myStock;
        stockList = new ArrayList<String>();

        String rtnValue = "";

    }

}
