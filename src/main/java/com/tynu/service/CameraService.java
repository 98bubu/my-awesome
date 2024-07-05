package com.tynu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tynu.domain.ResponseResult;
import com.tynu.domain.entity.Camera;

/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description:
 */
public interface CameraService extends IService<Camera> {

	ResponseResult listCamera();
}
