##打开在线网页

###调用示例：

		    <Button onclick="cordova.plugins.MKwebviewPlugin.load(
            function(msg){
             alert(msg);
            },function(msg){
             alert(msg);
         },'http://baidu.com')">百度</button>
