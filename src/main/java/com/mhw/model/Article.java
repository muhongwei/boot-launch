package com.mhw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MuHongwei
 * @date 2019/9/10
 */
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class Article {
    private Long id;
    private String author;
}
