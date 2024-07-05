package com.tynu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tynu.constants.SystemConstants;
import com.tynu.domain.ResponseResult;
import com.tynu.domain.entity.Camera;
import com.tynu.domain.vo.CameraVo;
import com.tynu.enums.CameraStatusEnum;
import com.tynu.mapper.CameraMapper;
import com.tynu.service.CameraService;
import com.tynu.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description:
 */
@Service
public class CameraServiceImpl extends ServiceImpl<CameraMapper, Camera> implements CameraService {


	@Override
	public ResponseResult listCamera() {
		LambdaQueryWrapper<Camera> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(Camera::getStatus, SystemConstants.STATUS_NORMAL);
		List<Camera> cameraList = list(wrapper);
		List<CameraVo> cameraVos = cameraList2voList(cameraList);
		for (CameraVo vo : cameraVos) {
			vo.setUrl(SystemConstants.URL_PREFIX + vo.getCameraId() + SystemConstants.URL_SUFFIX);
		}
		return ResponseResult.okResult(cameraVos);
	}

	private CameraVo camera2VO(Camera camera){
		CameraVo cameraVo = new CameraVo();
		BeanUtils.copyProperties(camera,cameraVo);
		cameraVo.setStatus(CameraStatusEnum.getInstance(camera.getStatus()));
		return cameraVo;
	}

	private List<CameraVo> cameraList2voList(List<Camera> cameraList){
		List<CameraVo> cameraVoList = new ArrayList<>();
		for (Camera camera : cameraList){
			cameraVoList.add(camera2VO(camera));
		}
		return cameraVoList;
	}


}
