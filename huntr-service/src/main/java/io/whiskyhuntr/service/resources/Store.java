package io.whiskyhuntr.service.resources;

import lombok.Data;

@Data
public class Store {

    private long id;
    private String name;
    private String baseUrl;
    private String searchUrl;

}
