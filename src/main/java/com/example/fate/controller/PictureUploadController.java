package com.example.fate.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PictureUploadController {
    public static final Resource PICTURES_DIR = new FileSystemResource("./pictures");
    
    @RequestMapping(value="/upload")
    public String uploadPage() {
        
        return "/profile/uploadPage";
    }
    
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String onUpload(MultipartFile file, RedirectAttributes redirectAttrs) throws IOException {
        if (file.isEmpty() || !isImage(file)) {
            redirectAttrs.addFlashAttribute("error", "Incorrect file. Please upload a picture.");
            return "redirect:/upload";
        }
        copyFileToPictures(file);
        
        return "/profile/uploadPage";
    }
    
    private Resource copyFileToPictures(MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("pic", getFileExtention(file.getOriginalFilename()), 
                PICTURES_DIR.getFile());
        // Java SE7新特性:try...with代码块将会自动关闭流 即使出现异常情况也会如此 这样我们就不用写finally这种样板式代码啦 
        //任何实现了 java.lang.AutoCloseable的对象, 包括所有实现了 java.io.Closeable 的对象, 都可以用作一个资源
        try (InputStream in = file.getInputStream();
                OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        
        return new FileSystemResource(tempFile);
    }
    
    @RequestMapping("/uploadedPicture")
    public void getUploadedPicture(HttpServletResponse response) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("/images/anoymous.png");
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(classPathResource.getFilename()));
        IOUtils.copy(classPathResource.getInputStream(), response.getOutputStream());
    }
    
    private boolean isImage(MultipartFile file) {
        
        return file.getContentType().startsWith("image");
    }
    
    /**
     * 获得文件扩展名
     * @param name
     * @return
     */
    private static String getFileExtention(String name) {
        
        return name.substring(name.lastIndexOf("."));
    }
}
