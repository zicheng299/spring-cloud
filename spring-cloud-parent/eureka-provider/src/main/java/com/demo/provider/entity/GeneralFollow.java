package com.demo.provider.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;
@TableName("t_general_follow")
@Data
public class GeneralFollow {
    private String id;
    private String resourceId;
    private String resourceType;
    private String docLibraryId;
    private String tenantCode;
    private String createdBy;
    private LocalDateTime createdTime;
}
