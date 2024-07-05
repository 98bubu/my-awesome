package com.tynu.domain.vo;

import com.tynu.enums.CameraStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraVo {
	private Integer id;

	//摄像头id
	private String cameraId;
	//设备名称
	private String name;
	//摄像头状态是否在线0正常
	private CameraStatusEnum status;
	//设备类型
	private String type;
	//摄像头所属组织
	private String organization;
	//所属视频服务器
	private String server;
	// 可播放的url
	private String url;
}
