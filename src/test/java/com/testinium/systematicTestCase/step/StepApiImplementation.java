package com.testinium.systematicTestCase.step;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.testinium.systematicTestCase.driver.Driver;
import com.testinium.systematicTestCase.methods.ApiMethods;
import com.testinium.systematicTestCase.methods.MethodsUtil;
import com.testinium.systematicTestCase.methods.ReadJsonMethods;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepApiImplementation {

    private static final Logger logger = LogManager.getLogger(StepApiImplementation.class);
    MethodsUtil methodsUtil;
    ApiMethods apiMethods;
    ReadJsonMethods readJsonMethods;
    private static StepApiImplementation stepApiImplementation;

    public StepApiImplementation(){

        methodsUtil = new MethodsUtil();
        apiMethods = new ApiMethods();
        readJsonMethods = new ReadJsonMethods();

    }

    public static StepApiImplementation getInstance(){
        if(stepApiImplementation==null){
            stepApiImplementation = new StepApiImplementation();
        }
        return stepApiImplementation;
    }

    @Step("<apiMapKey> api testi için map key olustur")
    public void setKey(String apiMapKey){

        Driver.apiMap.put(apiMapKey, new ConcurrentHashMap<String, Object>());
    }

    @Step("<baseUri> baseUri ı <apiMapKey> e ekle")
    public void setKeyBaseUri(String baseUri, String apiMapKey){

        if(baseUri.endsWith("KeyValue")){
            baseUri = Driver.TestMap.get(baseUri).toString();
        }
        logger.info("BaseUri: " + baseUri);
        Driver.apiMap.get(apiMapKey).put("baseUri", baseUri);
    }

    @Step("<isRelaxedHTTPSValidation> relaxedHTTPSValidation ı <apiMapKey> e ekle")
    public void setRelaxedHTTPSValidation(Boolean isRelaxedHTTPSValidation, String apiMapKey){

        logger.info("isRelaxedHTTPSValidation: " + isRelaxedHTTPSValidation);
        Driver.apiMap.get(apiMapKey).put("isRelaxedHTTPSValidation", isRelaxedHTTPSValidation);
    }

    @Step("<acceptValue> accept degerini <apiMapKey> e ekle")
    public void setKeyAccept(String acceptValue, String apiMapKey){

        Driver.apiMap.get(apiMapKey).put("accept", acceptValue);
    }

    @Step("<contentType> contentType degerini <apiMapKey> e ekle")
    public void setKeyContentType(String contentType, String apiMapKey){

        if(contentType.endsWith("KeyValue")){
            contentType = Driver.TestMap.get(contentType).toString();
        }
        logger.info("Content-Type: " + contentType);
        Driver.apiMap.get(apiMapKey).put("contentType", contentType);
    }

    //unchecked
    @Step("<headerKey> <headerValue> header degerini <apiMapKey> e ekle")
    public void setKeyHeaders(String headerKey, String headerValue, String apiMapKey){

        if(headerKey.endsWith("KeyValue")){
            headerKey = Driver.TestMap.get(headerKey).toString();
        }
        if(headerValue.endsWith("KeyValue")){
            headerValue = Driver.TestMap.get(headerValue).toString();
        }
        headerValue = methodsUtil.setValueWithMapKey(headerValue);
        logger.info("**Headers** " + headerKey + " : " + headerValue);
        if (Driver.apiMap.get(apiMapKey).containsKey("headers")){

            ((ConcurrentHashMap<String, String>) Driver.apiMap.get(apiMapKey).get("headers"))
                    .put(headerKey, headerValue);
        }else {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
            map.put(headerKey, headerValue);
            Driver.apiMap.get(apiMapKey).put("headers", map);
        }
    }

    @Step("<headerKey> <headerValue> header degerini <apiMapKey> e ekle <condition>")
    public void setKeyHeaders(String headerKey, String headerValue, String apiMapKey, String condition){

        boolean value = condition.startsWith("!");
        condition = value ? condition.substring(1) : condition;
        boolean isTrue = condition.endsWith("KeyValue") ? Boolean.parseBoolean(Driver.TestMap.get(condition).toString())
                : Boolean.parseBoolean(condition);
        isTrue = value != isTrue;
        if (isTrue){
            setKeyHeaders(headerKey, headerValue, apiMapKey);
        }
    }

    @Step("<username> <password> basic auth degerini <apiMapKey> e ekle preemptive <preemptive>")
    public void setBasicAuth(String username, String password, String apiMapKey, Boolean preemptive) {

        if (username.endsWith("KeyValue")) {
            username = Driver.TestMap.get(username).toString();
        }
        if (password.endsWith("KeyValue")) {
            password = Driver.TestMap.get(password).toString();
        }
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        map.put("preemptive", preemptive);
        Driver.apiMap.get(apiMapKey).put("basicAuth", map);
    }

    @Step("<token> değerini auth2 için <apiMapKey> e ekle")
    public void setAuth2(String token, String apiMapKey) {

        if (token.endsWith("KeyValue")) {
            token = Driver.TestMap.get(token).toString();
        }
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("token", token);
        Driver.apiMap.get(apiMapKey).put("auth2", map);
    }

    @Step("<host> <port> <username> <password> yada <uri> degerleriyle proxy i <apiMapKey> e ekle")
    public void setProxy(String host, String port, String username, String password, String uri, String apiMapKey) {

            if (host.endsWith("KeyValue")) {
                host = Driver.TestMap.get(host).toString();
            }
            if (port.endsWith("KeyValue")) {
                port = Driver.TestMap.get(port).toString();
            }
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
            if (!host.equals("") && !port.equals("")) {
                map.put("host", host);
                map.put("port", port);
            }
            if (username.endsWith("KeyValue")) {
                username = Driver.TestMap.get(username).toString();
            }
            if (password.endsWith("KeyValue")) {
                password = Driver.TestMap.get(password).toString();
            }
            if (!username.equals("") && !password.equals("")) {
                map.put("username", username);
                map.put("password", password);
            }
            if (uri.endsWith("KeyValue")) {
                uri = Driver.TestMap.get(uri).toString();
            }
            if (!uri.equals("")) {
                map.put("uri", uri);
            }
            Driver.apiMap.get(apiMapKey).put("proxy", map);
    }

    @SuppressWarnings("unchecked")
    @Step("<cookiesKey> <cookiesValue> cookies degerini <apiMapKey> e ekle")
    public void setCookies(String cookiesKey, String cookiesValue, String apiMapKey){

        if(cookiesKey.endsWith("KeyValue")){
            cookiesKey = Driver.TestMap.get(cookiesKey).toString();
        }
        if(cookiesValue.endsWith("KeyValue")){
            cookiesValue = Driver.TestMap.get(cookiesValue).toString();
        }
        logger.info("**Cookies** " + cookiesKey + " : " + cookiesValue);
        if (Driver.apiMap.get(apiMapKey).containsKey("cookies")){

            ((ConcurrentHashMap<String, String>) Driver.apiMap.get(apiMapKey).get("cookies"))
                    .put(cookiesKey, cookiesValue);
        }else {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
            map.put(cookiesKey, cookiesValue);
            Driver.apiMap.get(apiMapKey).put("cookies", map);
        }
    }

    @Step("<cookiesKey> <cookiesValue> cookies degerini <apiMapKey> e ekle <condition>")
    public void setCookies(String cookiesKey, String cookiesValue, String apiMapKey, String condition) {

        boolean value = condition.startsWith("!");
        condition = value ? condition.substring(1) : condition;
        boolean isTrue = condition.endsWith("KeyValue") ? Boolean.parseBoolean(Driver.TestMap.get(condition).toString())
                : Boolean.parseBoolean(condition);
        isTrue = value != isTrue;
        if (isTrue) {
            setCookies(cookiesKey, cookiesValue, apiMapKey);
        }
    }

    @SuppressWarnings("unchecked")
    @Step("<paramKey> <paramValue> parametre degerini <apiMapKey> e ekle")
    public void setKeyParams(String paramKey, String paramValue, String apiMapKey){

        if(paramValue.endsWith("KeyValue")){
            paramValue = Driver.TestMap.get(paramValue).toString();
        }
        logger.info(paramKey + " " + paramValue);
        if (Driver.apiMap.get(apiMapKey).containsKey("params")){

            ((ConcurrentHashMap<String, Object>) Driver.apiMap.get(apiMapKey).get("params"))
                    .put(paramKey, paramValue);
        }else {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
            map.put(paramKey, paramValue);
            Driver.apiMap.get(apiMapKey).put("params", map);
        }
    }

    @Step("<paramKey> <paramValue> parametre degerini <apiMapKey> e ekle <condition>")
    public void setKeyParams(String paramKey, String paramValue, String apiMapKey, String condition){

        boolean value = condition.startsWith("!");
        condition = value ? condition.substring(1) : condition;
        boolean isTrue = condition.endsWith("KeyValue") ? Boolean.parseBoolean(Driver.TestMap.get(condition).toString())
                : Boolean.parseBoolean(condition);
        isTrue = value != isTrue;
        if (isTrue){
            setKeyParams(paramKey, paramValue, apiMapKey);
        }
    }

    @SuppressWarnings("unchecked")
    @Step("<paramKey> <paramValue> query parametre degerini <apiMapKey> e ekle")
    public void setKeyQueryParams(String paramKey, String paramValue, String apiMapKey){

        if(paramValue.endsWith("KeyValue")){
            paramValue = Driver.TestMap.get(paramValue).toString();
        }
        logger.info(paramKey + " " + paramValue);
        if (Driver.apiMap.get(apiMapKey).containsKey("queryParams")){

            ((ConcurrentHashMap<String, Object>) Driver.apiMap.get(apiMapKey).get("queryParams"))
                    .put(paramKey, paramValue);
        }else {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
            map.put(paramKey, paramValue);
            Driver.apiMap.get(apiMapKey).put("queryParams", map);
        }
    }

    @SuppressWarnings("unchecked")
    @Step("<paramKey> <paramValue> form parametre degerini <apiMapKey> e ekle")
    public void setKeyFormParams(String paramKey, String paramValue, String apiMapKey){

        if(paramValue.endsWith("KeyValue")){
            paramValue = Driver.TestMap.get(paramValue).toString();
        }
        logger.info(paramKey + " " + paramValue);
        if (Driver.apiMap.get(apiMapKey).containsKey("formParams")){

            ((ConcurrentHashMap<String, Object>) Driver.apiMap.get(apiMapKey).get("formParams"))
                    .put(paramKey, paramValue);
        }else {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
            map.put(paramKey, paramValue);
            Driver.apiMap.get(apiMapKey).put("formParams", map);
        }
    }

    @Step("<body> body degerini <bodyType> tipiyle <apiMapKey> e ekle")
    public void setKeyBody(String body, String bodyType, String apiMapKey){

        if(bodyType.equals("String") && body.endsWith("KeyValue")){
            body = Driver.TestMap.get(body).toString();
        }
        Driver.apiMap.get(apiMapKey).put("body", body);
        Driver.apiMap.get(apiMapKey).put("bodyType", "body" + bodyType);
        logger.info(body);
    }

    @Step("<requestType> requestType ve <requestPath> i <apiMapKey> e ekle <requestPathType>")
    public void setKeyRequestType(String requestType, String requestPath, String apiMapKey, String requestPathType){

        requestPath = methodsUtil.setValueWithMap(requestPath);

        if(requestPath.endsWith("KeyValue")){
            requestPath = Driver.TestMap.get(requestPath).toString();
        }

        logger.info(requestPath);
        Driver.apiMap.get(apiMapKey).put("requestType", requestType);
        Driver.apiMap.get(apiMapKey).put("requestPathType", requestPathType);
        Driver.apiMap.get(apiMapKey).put("requestPath", requestPath);
    }

    @Step("<apiMapKey> api testi için istek at, log=<logActive> if <ifCondition>")
    public void sendRequest(String apiMapKey, boolean logActive, String ifCondition){

        if(ifCondition.endsWith("KeyValue")){
            ifCondition = Driver.TestMap.get(ifCondition).toString();
        }
        boolean condition = Boolean.parseBoolean(ifCondition);
        if(condition) {
            sendRequest(apiMapKey, logActive);
        }else {
            logger.info(condition + " durumu sebebiyle api isteği atılmadı");
        }
    }

    @Step("<apiMapKey> api testi statusCode değeri <statusCode> değerine eşit mi if <ifCondition>")
    public void statusCodeControl(String apiMapKey, String statusCode, String ifCondition){

        if(ifCondition.endsWith("KeyValue")){
            ifCondition = Driver.TestMap.get(ifCondition).toString();
        }
        boolean condition = Boolean.parseBoolean(ifCondition);
        if(condition) {
            statusCodeControl(apiMapKey, statusCode);
        }
    }

    @Step("<apiMapKey> api testi için istek at")
    public void sendRequest(String apiMapKey){

        sendRequest(apiMapKey,false);
    }

    @Step("<apiMapKey> api testi için istek at, log=<logActive>")
    public void sendRequest(String apiMapKey, boolean logActive){

        Response response = apiMethods.getResponse(Driver.apiMap.get(apiMapKey));
        logger.info(response.statusLine());
        if (logActive) {
            logger.info("" + response.statusCode());
            logger.info(apiMapKey + "Response:\n" + "" + response.asPrettyString());
            logger.info("" + response.getTime());
            //logger.info("" + response.getCookies().toString());
            //logger.info(response.getHeaders().toString());
        }
        Driver.apiMap.get(apiMapKey).put("response", response);
    }

    @Step("<apiMapKey> api testi statusCode değeri <statusCode> değerine eşit mi")
    public void statusCodeControl(String apiMapKey, String statusCode){

        statusCode = statusCode.endsWith("KeyValue") ? Driver.TestMap.get(statusCode).toString() : statusCode;
        Response response = (Response) Driver.apiMap.get(apiMapKey).get("response");
        assertEquals(Integer.parseInt(statusCode), response.statusCode());
    }

    @Step("<property> <value> json objesi değeri olarak <mapJsonObjectKey> e ekle <valueType>")
    public void addJsonObject(String property, String value, String mapKey, String valueType){

        if(Driver.TestMap.containsKey(mapKey)){
            JsonObject jsonObject = (JsonObject) Driver.TestMap.get(mapKey);
            methodsUtil.setStepJsonObjectValue(jsonObject, property, value, valueType);
            logger.info("" + Driver.TestMap.get(mapKey).toString());
        }else {
            JsonObject jsonObject = new JsonObject();
            methodsUtil.setStepJsonObjectValue(jsonObject, property, value, valueType);
            Driver.TestMap.put(mapKey, jsonObject);
            logger.info("" + Driver.TestMap.get(mapKey).toString());
        }
    }

    @Step("<mapJsonObjectKey> json array olustur <isOverwrite>")
    public void createJsonArray(String mapKey, Boolean isOverwrite){

        if(isOverwrite || !Driver.TestMap.containsKey(mapKey)) {
            JsonArray jsonArray = new JsonArray();
            Driver.TestMap.put(mapKey, jsonArray);
        }
    }

    @Step("<mapJsonObjectKey> json object olustur <isOverwrite>")
    public void createJsonObject(String mapKey, Boolean isOverwrite){

        if(isOverwrite || !Driver.TestMap.containsKey(mapKey)) {
            JsonObject jsonObject = new JsonObject();
            Driver.TestMap.put(mapKey, jsonObject);
        }
    }

    @Step("<value> json dizisi değerini <mapJsonObjectKey> e ekle <valueType>")
    public void addJsonArray(String value, String mapKey, String valueType){

        if(Driver.TestMap.containsKey(mapKey)){
            JsonArray jsonArray = (JsonArray) Driver.TestMap.get(mapKey);
            methodsUtil.setStepJsonArrayValue(jsonArray, value, valueType);
        }else {
            JsonArray jsonArray = new JsonArray();
            methodsUtil.setStepJsonArrayValue(jsonArray, value, valueType);
            Driver.TestMap.put(mapKey, jsonArray);
        }
    }

    @Step("<mapJsonObjectKey> de tutulan json objesini text olarak tut")
    public void saveJsonObjectToString(String mapKey){

        JsonObject jsonObject = (JsonObject) Driver.TestMap.get(mapKey);
        String jsonObjectString = jsonObject.toString();
        logger.info(jsonObjectString);
        Driver.TestMap.put(mapKey, jsonObjectString);
    }

    @Step("<mapJsonObjectKey> de tutulan json dizisini text olarak tut")
    public void saveJsonArrayToString(String mapKey){

        JsonArray jsonArray = (JsonArray) Driver.TestMap.get(mapKey);
        String jsonArrayString = jsonArray.toString();
        logger.info(jsonArrayString);
        Driver.TestMap.put(mapKey, jsonArrayString);
    }

    @Step("<mapKey> için bearer token ekle")
    public void setBearerToken(String mapKey){

        setKeyHeaders("Authorization","Bearer "
                + Driver.TestMap.get("token").toString(), mapKey);
    }

    @Step("<mapKey> keyini map ten sil")
    public void removeMapKey(String mapKey){

        logger.info("" + Driver.TestMap.containsKey(mapKey));
        Driver.TestMap.remove(mapKey);
        logger.info("" + Driver.TestMap.containsKey(mapKey));
    }

    @Step("Map i temizle")
    public void clearMap(){

        Driver.TestMap.clear();
        logger.info("" + Driver.TestMap.size());
    }

    @Step("<apiMapKey> keyini api map ten sil")
    public void removeApiMapKey(String apiMapKey){

        logger.info("" + Driver.apiMap.containsKey(apiMapKey));
        Driver.apiMap.remove(apiMapKey);
        logger.info("" + Driver.apiMap.containsKey(apiMapKey));
    }

    @Step("Api map i temizle")
    public void clearApiMap(){

        Driver.apiMap.clear();
        logger.info("" + Driver.apiMap.size());
    }

    @Step("<number> sayısından rastgele <count> kadar sayıyı listele <mapKey> keyinde tut")
    public void getRamdomNumberList(String number, String count, String mapKey){

        number = number.endsWith("KeyValue") ? Driver.TestMap.get(number).toString() : number;
        count = count.endsWith("KeyValue") ? Driver.TestMap.get(count).toString() : count;
        List<Integer> integerList = methodsUtil.getRandomNumberList(Integer.parseInt(number), Integer.parseInt(count));
        Driver.TestMap.put(mapKey, integerList);
        Driver.TestMap.put("size_" + mapKey, integerList.size());
    }

    @Step("<property> <valueListMapKey> json objesi değeri olarak <mapJsonObjectKeySuffix> e ekle <valueType> loop")
    public void addJsonObjectLoopForArray(String property, String valueListMapKey, String mapJsonObjectKeySuffix, String valueType){

        boolean trimActive = Driver.TestMap.containsKey("trimOptionsKeyValue")
                && Driver.TestMap.get("trimOptionsKeyValue").toString().equals("true");
        List<String> list = (List<String>) Driver.TestMap.get(valueListMapKey);
        for(int i = 0; i < list.size(); i++) {
            String value = trimActive ? list.get(i).trim() : list.get(i);
            if (Driver.TestMap.containsKey(i + mapJsonObjectKeySuffix)) {
                JsonObject jsonObject = (JsonObject) Driver.TestMap.get(i + mapJsonObjectKeySuffix);
                methodsUtil.setStepJsonObjectValue(jsonObject, property, value, valueType);
            } else {
                JsonObject jsonObject = new JsonObject();
                methodsUtil.setStepJsonObjectValue(jsonObject, property, value, valueType);
                Driver.TestMap.put(i + mapJsonObjectKeySuffix, jsonObject);
            }
        }
    }

    @Step("<mapJsonObjectKeySuffix> json dizisi değerini <mapJsonArrayKey> e ekle <valueType> loop <number>")
    public void setJsonArrayWithJsonObjectLoop(String mapJsonObjectKeySuffix, String mapJsonArrayKey, String valueType, String number){

        number = number.endsWith("KeyValue") ? Driver.TestMap.get(number).toString() : number;
        JsonArray jsonArray = new JsonArray();
        if (valueType.equals("JsonObject")) {
            for (int i = 0; i < Integer.parseInt(number); i++) {
                methodsUtil.setStepJsonArrayValue(jsonArray,i + mapJsonObjectKeySuffix,"JsonObject");
                Driver.TestMap.put(mapJsonArrayKey, jsonArray);
                Driver.TestMap.remove(i + mapJsonObjectKeySuffix);
            }
        }else {
            List<String> list = (List<String>) Driver.TestMap.get(mapJsonObjectKeySuffix);
            for (int i = 0; i < Integer.parseInt(number); i++) {
                methodsUtil.setStepJsonArrayValue(jsonArray, list.get(i), valueType);
                Driver.TestMap.put(mapJsonArrayKey, jsonArray);
            }
        }
    }

    @Step("<jsonMapKey> json üzerindeki <jsonPath> json yolunu oku <type> tipindeki degeri <mapKey> keyinde tut")
    public void readJsonPath(String jsonMapKey, String jsonPath, String type, String mapKey){

        jsonPath = methodsUtil.setValueWithMapKey(jsonPath);
        readJsonMethods.readJsonPath(readJsonMethods.getJsonElementByMap(jsonMapKey)
                , readJsonMethods.getJsonPathAsList(jsonPath,"|?"), type, mapKey);
    }

    @Step("<jsonPath> json path <value> value <type> type ve <id> degerini <mapKey> keyinde tut")
    public void setJsonPathMultipleValue(String jsonPath, String value, String type, String id, String mapKey){

        setJsonPathMultipleValue(jsonPath, value, type, id, mapKey,"equal",false);
    }

    @Step("<jsonPath> json path <value> value <type> type ve <id> degerini <mapKey> keyinde tut <valueControlType>")
    public void setJsonPathMultipleValue(String jsonPath, String value, String type, String id, String mapKey, String valueControlType){

        setJsonPathMultipleValue(jsonPath, value, type, id, mapKey, valueControlType,false);
    }

    @Step("<jsonPath> json path <value> value <type> type ve <id> degerini <mapKey> keyinde tut <valueControlType> OrActive <OrActive>")
    public void setJsonPathMultipleValue(String jsonPath, String value, String type, String id, String mapKey, String valueControlType, boolean OrActive){

        readJsonMethods.setJsonPathMultipleValue(jsonPath, value, type, id, mapKey, valueControlType, OrActive);
    }

    @Step("<jsonMapKey> json üzerinden <jsonPathKey> json degerlerini al ve <mapKeySuffix> keyinde tut")
    public void getMultipleValue(String jsonMapKey, String jsonPathKey, String mapKeySuffix){

        readJsonMethods.getMultipleValue(jsonPathKey, readJsonMethods.getJsonElementByMap(jsonMapKey),"|?", mapKeySuffix);
    }

    @Step("<jsonMapKey> json listesi üzerinden <controlJsonPathKey> varsa degerleri kontrol et <jsonPathKey> json degerlerini listele ve <mapKeySuffix> keyinde tut")
    public void getMultipleListValue(String jsonMapKey, String controlJsonPathKey, String jsonPathKey, String mapKeySuffix){

        readJsonMethods.getMultipleListValue(controlJsonPathKey, jsonPathKey
                , readJsonMethods.getJsonElementByMap(jsonMapKey),"|?", mapKeySuffix);
    }

    @Step("<jsonString> json textini <fileLocation> dosya yoluna yaz")
    public void writeJson(String jsonString, String fileLocation){

        String json = readJsonMethods.getJsonElementByMap(jsonString).toString();
        methodsUtil.writeJson(json, fileLocation,true,true,false);
    }

    @Step("<mapJsonKey> json liste sayısını <mapKey> degerinde tut")
    public void getJsonListSize(String mapJsonKey, String mapKey){

        int i = readJsonMethods.getJsonListSize((JsonArray) Driver.TestMap.get(mapJsonKey));
        Driver.TestMap.put(mapKey,i);
        logger.info("JsonListSize: " + i);
    }

}
