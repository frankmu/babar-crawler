package com.babar.crawler.selector;

import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;
import java.util.List;

public class JsonPathSelector implements Selector {

    private String jsonPathStr;

    private JsonPath jsonPath;

    public JsonPathSelector(String jsonPathStr) {
        this.jsonPathStr = jsonPathStr;
        this.jsonPath = JsonPath.compile(this.jsonPathStr);
    }

    @SuppressWarnings("rawtypes")
	@Override
    public String select(String text) {
        Object object = jsonPath.read(text);
        if (object == null) {
            return null;
        }
        if (object instanceof List) {
            List list = (List) object;
            if (list != null && list.size() > 0) {
                return list.iterator().next().toString();
            }
        }
        return object.toString();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<String> selectList(String text) {
        List<String> list = new ArrayList<String>();
        Object object = jsonPath.read(text);
        if (object == null) {
            return list;
        }
        if (object instanceof List) {
            List<Object> items = (List<Object>) object;
            for (Object item : items) {
                list.add(String.valueOf(item));
            }
        } else {
            list.add(String.valueOf(object));
        }
        return list;
    }
}
