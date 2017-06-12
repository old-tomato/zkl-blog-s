package com.blog.dao.file;

import com.blog.model.FileInfo;
import com.blog.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 52426 on 2017/6/12.
 */
public interface FileInfoMapper {

    int insertFile(FileInfo fileInfo);

    /**
     *  该方法只获取基本的文件数据信息
     * @param id
     * @param uid
     * @return
     */
    List<FileInfo> queryFileSimpleInfo(@Param("id") int id, @Param("uid")int uid);

    /**
     * 该方法可以获得所有的文件数据信息
     * @param id
     * @param uid
     * @return
     */
    List<FileInfo> queryFileFullInfo(@Param("id") int id, @Param("uid")int uid);

    /**
     * 更新文件信息，不需要更新的信息部分传空
     * @param fileInfo
     * @return
     */
    int updateFileInfo(FileInfo fileInfo);

    void deleteFile(FileInfo fileInfo);
}
