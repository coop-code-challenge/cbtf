package org.cbtf.f2f.common;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

public class F2FMediaTypes {
    public static final MediaType JSON_CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
}
