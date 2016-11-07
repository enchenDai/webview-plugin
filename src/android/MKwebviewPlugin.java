package hand.activity;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class MKwebviewPlugin extends CordovaPlugin{

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    if("load".equals(action)){
      String url = args.getString(0);
      Intent intent = new Intent(cordova.getActivity(),LoadWebviewActivity.class);
      intent.putExtra("url",url);
      cordova.getActivity().startActivity(intent);
      return true;
    }
    callbackContext.error("error");
    return false;
  }
}
