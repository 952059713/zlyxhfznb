package com.zlyznbxhf.controller;

import com.zlyznbxhf.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class FileUploadController {
    @Autowired
    private UserService userService;

    /**
     * 文件上传，并更新用户头像
     * @param multipartFile
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/file/fileUploadTest.action")
    @ResponseBody
    public HashMap fileUpload(MultipartFile multipartFile, HttpServletRequest request, HttpSession session) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer id = (Integer) session.getAttribute("userid");
        try {
            String fileName = UUID.randomUUID().toString().replace( "-", "" );
            String path = request.getServletContext().getRealPath( "/img/" ); //C://xx/img
            //后缀名 jpg
            String extension = FilenameUtils.getExtension( multipartFile.getOriginalFilename() );
            // C://xx/img/aa.jpg  linux:/url/tomcat/webapp/AAA/13cd.png
            File file = new File( path + fileName + "." + extension );
            System.out.println(file.getPath());
            //访问路径request.getContextPath() +
            System.out.println("/img/" + fileName + "." + extension);
            //保存文件
            multipartFile.transferTo( file );
            userService.updateUserImg(id,request.getContextPath() + "/img/" + fileName + "." + extension);
            hashMap.put("code",0);
            hashMap.put("msg","上传成功");
            hashMap.put("data","../img/" + fileName + "." + extension);
        }catch (Exception e){
            e.printStackTrace();
            hashMap.put("code",1);
            hashMap.put("msg","上传失败");
        }
        return hashMap;
    }
}
