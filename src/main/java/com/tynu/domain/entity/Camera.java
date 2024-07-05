package com.tynu.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description: 摄像头类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("camera")
public class Camera  {
	@TableId
	private Integer id;

	//摄像头id
	private String cameraId;
	//设备名称
	private String name;
	//摄像头状态是否在线0正常
	private Integer status;
	//设备类型
	private String type;
	//摄像头ip
	private String ip;
	//摄像头端口
	private String port;
	//摄像头所属组织
	private String organization;
	//所属视频服务器
	private String server;



}
