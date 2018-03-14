package core.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationEntity {
    private String name;

    private String value;


    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getValue() {
        return value;
    }
}