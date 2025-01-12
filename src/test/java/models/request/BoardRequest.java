package models.request;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String name;
    private String desc;
    private String idOrganization;
    private String defaultLists;
    private String prefs_permissionLevel;
} 