package com.pb.mvc.controller;

import com.pb.entity.User;
import com.pb.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author haohan
 * 12/25/2018 - 02:59 下午
 */
//@SessionAttributes(value = {"names", "age"}, types = String.class)
@Controller
public class HelloWorld {

    private static final String SUCCESS = "success";

    @Autowired
    UserDao ud;

    @Autowired
    ResourceBundleMessageSource resourceBundleMessageSource;

    @RequestMapping(value = "/requestparam")
    public String testRequestParam(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "age", required = false) Integer age) {
        System.out.println(username + age);
        return SUCCESS;
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        System.out.println("Hello World！！！" + request);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        int[] i = {1, 2, 3};
        map.put("age", Arrays.asList(i));
        map.put("names", Arrays.asList("jay", "join", "jj"));
        return SUCCESS;
    }

    @ModelAttribute
    public void getCar(@RequestParam(value = "id", required = false) Integer id,Map<String, User> map) {
        if(id != null) {
            User user = new User(1, "jay", 18, "五道口");
            map.put("user", user);
        }
    }

    /**
     * 若ModelAttribute指定了值，则该方法入参时也可以用@ModelAttribute来指定传入对应的参数
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("修改后的用户对象" + user);
        return SUCCESS;
    }

    @RequestMapping("/testBeanNameView")
    public String testBeanNameView() {
        return "helloView";
    }

    @ResponseBody
    @RequestMapping("/getUsers")
    public Collection<User> getUsers() {
        return ud.getList();
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadfile")
    public String getText(@RequestBody String file) {
        System.out.println(file);
        return  "Hello" + new Date();
    }

    /**
     * 下载指定文件
     * @param session 用来获取ServletConetxt对象
     * @return
     */
    @RequestMapping("/downloadfile")
    public ResponseEntity<byte[]> download(HttpSession session) {
        byte[] body = null;
        ResponseEntity<byte[]> responseEntity = null;
        try {
//            //获取类路径下文件
//            getClass().getClassLoader().getResourceAsStream("");
            ServletContext servletContext = session.getServletContext();
            InputStream is = servletContext.getResourceAsStream("files/abc.txt");
            //创建下载文件字节流大小的存储对象
            body = new byte[is.available()];
            is.read(body);

            //创建文件头
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition", "attachment;filename=abc.txt");

            //创建文件编码
            HttpStatus httpStatus = HttpStatus.OK;

            responseEntity = new ResponseEntity<>(body, httpHeaders, httpStatus);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    public String messageResource(Locale locale) {
        String user = resourceBundleMessageSource.getMessage("i18n.user", null, locale);

        return SUCCESS;
    }

    @RequestMapping("/fileupload")
    public String fileupload(@RequestParam(value = "desc") String desc,
                             @RequestParam("file") MultipartFile file) {
        System.out.println("desc" + desc);
        System.out.println("fileName" + file.getOriginalFilename());
        return SUCCESS;
    }


}
