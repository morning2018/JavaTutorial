package com.learning.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 功能描述：
 *  文件相关操作
 * @author morning
 * @date 2020/8/24 17:53
 * @version v0.0.1
 */
public final class FileTest {

    /**
     * 获取文件夹下的所有文件,不进行递归
     * @param dir
     * @return
     */
    public static List<String> getAllFileName(String dir) {

        File file = new File(dir);

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            List<String> fileNameList = new ArrayList<>(fileList.length);
            for (File file1 : fileList) {
                if (file1.isFile()) {
                    System.out.println(file1.getName());
                    fileNameList.add(file1.getName());
                }
            }
        }
        else {
            System.out.println("不是文件夹");
        }
        return null;
    }

    public static void main(String[] args) {
        String path = "classpath:cases";
        FileTest.getAllFileName(path);
    }

}
