package com.kurobarabenjamingeorge.mynavigationdrawer.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by George Benjamin on 8/2/2018.
 */

public class Utils {

    public  static  void makeToast(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
