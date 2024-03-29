package com.activevideo.bookmarks;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
public class Main {
    public static void main(String[] args) throws IOException {
            final String baseUri = "http://localhost:"+(System.getenv("PORT")!=null?System.getenv("PORT"):"9998")+"/";
            final Map<String, String> initParams = new HashMap<String, String>();
            initParams.put("com.sun.jersey.config.property.packages","com.activevideo.bookmarks.resources");
            SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
    }
}
