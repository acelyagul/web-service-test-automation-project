package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardResponse {
    private String id;
    private String name;
    private String desc;
    private boolean closed;
    private String idOrganization;
} 