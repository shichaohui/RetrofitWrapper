# RetrofitWrapper

Packing Retrofit and makes it easier to use.

## Feature

* Support url params.
* Support form params.
* Support raw params.
* Support multipart params.
* Support custom headers.

## Usage

[Java Example](https://github.com/shichaohui/RetrofitWrapper/tree/master/app/src/main/java/com/sch/example/java)
 and 
[Kotlin Example](https://github.com/shichaohui/RetrofitWrapper/tree/master/app/src/main/java/com/sch/example/kotlin)

### dependencies

```
implementation 'com.sch.retrofit:retrofit-wrapper:1.0.0'

implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'
implementation 'com.squareup.okhttp3:logging-interceptor:3.10.0'

implementation 'com.google.code.gson:gson:2.8.5'

implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'
implementation 'io.reactivex.rxjava2:rxjava:2.1.16'

implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
```

### Init

```
RetrofitWrapper.init("http://www.tngou.net/")

RetrofitWrapper.init("http://www.tngou.net/", Level.BODY)

RetrofitWrapper.init(retrofit)
```

### Create request body by extend [inner params](https://github.com/shichaohui/RetrofitWrapper/tree/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/params)

```
class Request(params: Int) : UrlParams<Response>("api") {

    /*
     * url：baseUrl/api?params=params
     */

    // Response type for Gson convert.
    override val responseType: Type = Response::class.java

    init {
        putUrlParams("params", params)
    }

}
```

```
class Request(urlParams: Int, formParams: Int) : FormParams<Response>("api") {

    /*
     * url：baseUrl/api?params=params
     * form params: params=params
     */

    // Response type for Gson convert.
    override val responseType: Type = Response::class.java

    init {

        putUrlParams("params", urlParams)

        putFormParams("params", formParams)
    }

}
```

```
class Request(urlParams: Int, rawParams: Int) : RawParams<Response>("api") {

    /*
     * url：baseUrl/api?params=params
     * raw params: {"params":"params"}
     */

    // Response type for Gson convert.
    override val responseType: Type = Response::class.java

    init {

        putUrlParams("params", urlParams)

        putRawParams("params", rawParams)
    }

}
```

[More usage about inner params.](https://github.com/shichaohui/RetrofitWrapper/tree/master/app/src/main/java/com/sch/example/kotlin/api)

### Create request body by [custom params](https://github.com/shichaohui/RetrofitWrapper/tree/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request)

Use interface (
[SupportUrlParams](https://github.com/shichaohui/RetrofitWrapper/blob/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/SupportUrlParams.kt) 
[SupportFormParams](https://github.com/shichaohui/RetrofitWrapper/blob/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/SupportFormParams.kt) 
[SupportRawParams](https://github.com/shichaohui/RetrofitWrapper/blob/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/SupportRawParams.kt) 
[SupportMultipartParams](https://github.com/shichaohui/RetrofitWrapper/blob/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/SupportMultipartParams.kt) 
[SupportHeaders](https://github.com/shichaohui/RetrofitWrapper/blob/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/SupportHeaders.kt) 
) just like [inner params](https://github.com/shichaohui/RetrofitWrapper/tree/master/retrofit_wrapper/src/main/java/com/sch/retrofit/wrapper/request/params) .

## Initiate a request

```
// Method: GET
ApiRequester.get(Request(params))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { response ->
            // do something
        }

// Method: POST, Params: Form, Raw, Multipart
ApiRequester.post(Request(params))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { response ->
            // do something
        }
```

[More usage about initiate a request.](https://github.com/shichaohui/RetrofitWrapper/blob/master/app/src/main/java/com/sch/example/kotlin/MainActivity.kt)

# License

```
Copyright (c) 2015-2018 Shi ChaoHui

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
