package com.tynu.controller;

import com.tynu.domain.ResponseResult;
import com.tynu.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description:
 */

@RestController
@RequestMapping("/camera")
public class CameraController {

	@Autowired
	private CameraService cameraService;


	@GetMapping("/list")
	public ResponseResult getCamera(){
		ResponseResult result = cameraService.listCamera();
		return result;
	}
}
