package com.blog.service;

import com.blog.dao.file.FileInfoMapper;
import com.blog.exception.ServiceException;
import com.blog.model.FileInfo;
import com.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 52426 on 2017/6/12.
 */
@Service
public class FileService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    public List<FileInfo> getFileList(UserInfo userInfo) {
        return fileInfoMapper.queryFileSimpleInfo(0 , userInfo.getUid());
    }

    public int saveFile(FileInfo fileInfo) {
        if(fileInfo.getUid() == 0){
            throw new ServiceException("用户信息异常");
        }
        if(fileInfo.getFileName().isEmpty() || fileInfo.getContent().isEmpty()){
            throw new ServiceException("内容缺失");
        }
        fileInfoMapper.insertFile(fileInfo);
        return fileInfo.getId();
    }

    public FileInfo readFile(FileInfo fileInfo) {
        if(fileInfo == null || fileInfo.getId() <= 0){
            throw new ServiceException("文件ID异常");
        }
        List<FileInfo> fileInfoList = fileInfoMapper.queryFileFullInfo(fileInfo.getId(), 0);
        if (fileInfoList == null || fileInfoList.size() == 0){
            throw new ServiceException("读取文件异常");
        }
        return fileInfoList.get(0);
    }

    public void updateFile(FileInfo fileInfo) {
        fileInfoMapper.updateFileInfo(fileInfo);
    }

    public void deleteFile(FileInfo fileInfo) {
        fileInfoMapper.deleteFile(fileInfo);
    }
}
