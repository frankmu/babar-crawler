package com.babar.crawler.selector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import us.codecraft.xsoup.XTokenQueue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Json extends PlainText {

    public Json(List<String> strings) {
        super(strings);
    }

    public Json(String text) {
        super(text);
    }

    /**
     * remove padding for JSONP
     * @param padding padding
     * @return json after padding removed
     */
    public Json removePadding(String padding) {
        String text = getFirstSourceText();
        XTokenQueue tokenQueue = new XTokenQueue(text);
        tokenQueue.consumeWhitespace();
        tokenQueue.consume(padding);
        tokenQueue.consumeWhitespace();
        String chompBalanced = tokenQueue.chompBalancedNotInQuotes('(', ')');
        return new Json(chompBalanced);
    }

    public <T> T toObject(Class<T> clazz) {
        if (getFirstSourceText() == null) {
            return null;
        }
        return new Gson().fromJson(getFirstSourceText(), clazz);
    }

    public <T> List<T> toList(Class<T> clazz) {
        if (getFirstSourceText() == null) {
            return null;
        }
        Type userListType = new TypeToken<ArrayList<T>>(){}.getType();
        return new Gson().fromJson(getFirstSourceText(), userListType);
    }

    @Override
    public Selectable jsonPath(String jsonPath) {
        JsonPathSelector jsonPathSelector = new JsonPathSelector(jsonPath);
        return selectList(jsonPathSelector,getSourceTexts());
    }
}
