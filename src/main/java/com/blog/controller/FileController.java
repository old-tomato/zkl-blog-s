package com.blog.controller;

import com.blog.common.DataMessage;
import com.blog.model.FileInfo;
import com.blog.model.UserInfo;
import com.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 52426 on 2017/6/12.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/fileList")
    @ResponseBody
    public DataMessage fileList(@RequestBody UserInfo userInfo){
        // TODO 需要添加分页加载的功能
        List<FileInfo> fileInfoList = fileService.getFileList(userInfo);
        return new DataMessage(fileInfoList);
    }

    @RequestMapping("/saveFile")
    @ResponseBody
    public DataMessage saveFile(@RequestBody FileInfo fileInfo){
        int id = fileService.saveFile(fileInfo);
        return new DataMessage(id);
    }

    @RequestMapping("/readFile")
    @ResponseBody
    public DataMessage readFile(@RequestBody FileInfo fileInfo){
        fileInfo = fileService.readFile(fileInfo);
        return new DataMessage(fileInfo);
    }

    @RequestMapping("/updateFile")
    @ResponseBody
    public DataMessage updateFile(@RequestBody FileInfo fileInfo){
        fileService.updateFile(fileInfo);
        return DataMessage.SUCCESS;
    }

    @RequestMapping("/deleteFile")
    @ResponseBody
    public DataMessage deleteFile (@RequestBody FileInfo fileInfo){
        fileService.deleteFile(fileInfo);
        return DataMessage.SUCCESS;
    }
}
