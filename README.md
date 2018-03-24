
### GetContentn Download and Maven
  * To use GetContent in Android
```gradle

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    compile 'compile 'com.github.MilanPithadia:GetContent:1.4''
}
```


  ```xml
<dependency>
	    <groupId>com.github.MilanPithadia</groupId>
	    <artifactId>GetContent</artifactId>
	    <version>1.4</version>
	</dependency>
```

### Listen event


```java
String url = "https://jsonplaceholder.typicode.com/posts";
        GetContent.fromURL(url).setOnResultListener(new GetContent.Result() {
            @Override
            public void Result(Boolean b, String result)
            {
                if(b)
                {
                    //success
                    Log.d("Result",result);
                }
                else {
                    //error
                    Log.d("EROOR",result);
                }
            }
        });
```
