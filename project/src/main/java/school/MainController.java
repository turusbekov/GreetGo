package school;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.h2.util.IOUtils;
import org.springframework.web.servlet.ModelAndView;
import school.UserMapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

@Controller
public class MainController {

    SqlSessionFactory sqlSessionFactory;



    public UserMapper userMapper;

    String resourse = "mybatis-config.xml";
    Reader inputStream;

    @GetMapping("/")
    public String auto_page(AutoUser user){
        return "auto";
    }

    @PostMapping("/")
    public String main_page(AutoUser user,Model model)
    {
        String s = "";
        try {
            inputStream = Resources.getResourceAsReader(resourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
            AutoUser n = userMapper.findByEmail(user.getEmail());
            if (user.getEmail().equals("admin") && user.getPassword().equals("admin")){
                List<AutoUser> t = userMapper.findAll();
                model.addAttribute("users",t);
                s = "index";
            }
            else {
                model.addAttribute("error","Something wrong with login or password!");
                s="auto";
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }
    @PostMapping("/delete")
    public String delete_data(AutoUser user,Model model){
        System.out.println(user.getName());

            userMapper.deleteUser(user.getSurname());
            List<AutoUser> t = userMapper.findAll();
            model.addAttribute("users",t);

        return "index";
    }

    @PostMapping("/register")
    public String regis_page(AutoUser user){
        return "regis";
    }
    @PostMapping("/right")
    public String user_form(AutoUser user,Model model){
            userMapper.saveUser(user);
            List<AutoUser> t = userMapper.findAll();
            model.addAttribute("users",t);
        return "index";
    }


}
