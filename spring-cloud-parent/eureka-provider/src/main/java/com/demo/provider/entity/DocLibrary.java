package com.demo.provider.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;
@TableName("t_doc_library")
@Data
public class DocLibrary {
    private String id;
    private String name;
    private String type;
    private Integer size;
    private Integer uploadSizeLimit;
    private String uploadTypeLimit;
    private Integer clearDaysRemaining;
    private String projectId;
    private String tenantCode;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private Boolean isDelete;
}
