package com.demo.provider.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocVO {
    private String id;
    private String name;
    private String type;
    private String projectId;
    private String displayName;
    private String projectName;
}
