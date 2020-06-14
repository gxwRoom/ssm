package com.gxw.controller;

import com.gxw.pojo.User;
import com.gxw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 用户控制器
 * @author GXW工作室
 * @date 2020/6/14 0014 - 12:29
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping(path = "/findUser")
    public String findUser(Model model){
        List<User> list = userService.selectUser();
        model.addAttribute("list",list);
        System.out.println("controller查询用户："+list);
        return "userList";
    }

    /**
     * SpringMVC文件上传
     */
    @RequestMapping(path = "/fileUpload")
    public String fileUpload(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("执行SpringMVC文件上传...");
        //1.获取文件上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //2.判断该路径是否存在 创建文件流File
        File file = new File(path);
        if (!file.exists()) {
            //如果文件路径不存在，则创建新的文件路径
            file.mkdirs();
        }
        //3.获取原始上传文件的名称
        String filename = upload.getOriginalFilename();
        //4.通过uuid把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String fileUUidName = uuid+filename;
        //5.通过Multipart的接口方法，把上传的文件写到指定位置  文件位置和文件名称
        upload.transferTo(new File(path,fileUUidName));
        return "success";
    }
}
