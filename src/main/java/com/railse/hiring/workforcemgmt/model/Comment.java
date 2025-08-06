package com.railse.hiring.workforcemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long userId;
    private String text;
    private long timeStamp;
}
