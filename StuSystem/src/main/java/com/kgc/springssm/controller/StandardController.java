package com.kgc.springssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.springssm.pojo.Standard;
import com.kgc.springssm.pojo.StandardExample;
import com.kgc.springssm.service.StandardService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-10 20:17
 */
@Controller
public class StandardController {
    @Resource
    StandardService standardService;
    @RequestMapping("/")
    public String toindex(Model model, String pageIndex,String title){
        int pageNum=1;
        if(pageIndex!=null){
            pageNum=Integer.parseInt(pageIndex);
        }
        int pageSize=3;
        PageHelper.startPage(pageNum,pageSize);
        if(title != null && title.isEmpty() == false){
            StandardExample example=new StandardExample();
            StandardExample.Criteria criteria = example.createCriteria();
            criteria.andZhnameLike("%"+title+"%");
            List<Standard> standards = standardService.selectByExample(example);
            PageInfo pageInfo=new PageInfo(standards);
            model.addAttribute("pageInfo",pageInfo);
            return "index";
        }else{
            PageHelper.startPage(pageNum,pageSize);
            List<Standard> standards = standardService.selectByExample(null);
            PageInfo pageInfo=new PageInfo(standards);
            model.addAttribute("pageInfo",pageInfo);
            return "index";
        }
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
