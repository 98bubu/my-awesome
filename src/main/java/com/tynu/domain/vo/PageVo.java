package com.tynu.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DATE: 2022/11/3
 * Author: 李毫
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {

	private List rows;

	private Long total;
}
