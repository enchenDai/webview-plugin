package hand.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by cool on 2016/11/6.
 */

public class LoadWebviewActivity extends Activity {

  private WebView mWebView;
  private String url;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(getLayoutId("activity_webview"));
    initData();
    initView();

  }

  private void initData() {
    url = getIntent().getStringExtra("url");
  }


  private void initView() {
    mWebView = (WebView) findViewById(getId("webview"));
    mWebView.loadUrl(url);
    //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
    mWebView.setWebViewClient(new WebViewClient(){
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
        view.loadUrl(url);
        return true;
      }
    });
    //启用支持javascript
    WebSettings settings = mWebView.getSettings();
    settings.setJavaScriptEnabled(true);
  }

  @Override
  public void onBackPressed() {
    if(mWebView.canGoBack()){
      mWebView.goBack();
    }else {
      super.onBackPressed();
    }
  }

  private int getLayoutId(String layoutName){
    return getResources().getIdentifier(layoutName,"layout",getPackageName());
  }
  private int getId(String id){
    return getResources().getIdentifier(id,"id",getPackageName());
  }
}
