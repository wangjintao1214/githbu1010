package com.kgc.springssm.controller;

import com.kgc.springssm.pojo.Standard;
import com.kgc.springssm.service.StandardService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author shkstart
 * @create 2020-10-10 20:17
 */
@Controller
public class StandardController {
    @Resource
    StandardService standardService;
    @RequestMapping("/")
    public String toindex(){
        return "index";
    }
    @RequestMapping("/toadd")
    public  String toadd(){
        return "add";
    }
    @RequestMapping("/doadd")
    public String doadd(Standard standard, HttpSession session, MultipartFile packagePath){
        //文件上传
        String realPath = session.getServletContext().getRealPath("/static/uploadfiles/");
        String originalFilename = packagePath.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newFileName=System.currentTimeMillis()+"_"+ RandomUtils.nextInt(1000000)+"_."+extension;
        File file=new File(realPath,newFileName);
        try {
            packagePath.transferTo(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        standard.setPackagePath(realPath+newFileName);
        int i = standardService.add(standard);
        if(i>0){
            session.setAttribute("msg","添加成功！！！");
            return "redirect:/";
        }else {
            session.setAttribute("msg","添加失败！！！");
            return "redirect:/toadd";
        }

    }
}
