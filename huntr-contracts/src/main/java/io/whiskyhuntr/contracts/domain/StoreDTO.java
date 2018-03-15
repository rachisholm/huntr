package io.whiskyhuntr.contracts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private long id;
    private String name;
    private String baseUrl;
    private String searchUrl;

}
