package com.example.MailSender.controller;


import com.example.MailSender.model.User;
import com.example.MailSender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping(path="/users")
public class MainController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/new")
    public String addNewUser(@RequestParam String username, @RequestParam String email, Model model) {
        User post = new User(username, email);

        userRepository.save(post);
        return "redirect:/added";
    }
    @PostMapping(path="/") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getOne(@PathVariable String id) {
        return userRepository.findById(Integer.valueOf(id));
    }

    @DeleteMapping("/{id}")
    public Optional<User> deleteOne(@PathVariable String id) {

        return userRepository.deleteById(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public String putOne(@PathVariable String id, @RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setId(Integer.parseInt(id));
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }
}
      @Controller // This means that this class is a Controller
//    @RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
      class MController {
      @GetMapping("/users/new")
      public String home( Model model) {
          model.addAttribute("title", "Главная страница");
          return "home";
      }

      @GetMapping("/added")
      public String addedUser( Model model) {
          model.addAttribute("title", "Thank you!");
          return "addedUser";
      }

}
/*
        @Autowired // This means to get the bean called userRepository
        // Which is auto-generated by Spring, we will use it to handle the data
        private UserRepository userRepository;
        @Autowired
        private JavaMailSender emailSender;
       *//* @PostMapping("/")
    public String addNewUser(@RequestParam String username,@RequestParam String email, Model model) {
        User post = new User(username, email);
        userRepository.save(post);
        return "redirect:/added";
    }*//*
     *//*@PostMapping(path="/add") // Map ONLY POST Requests
        public @ResponseBody
        String addNewUser (@RequestParam String name
                , @RequestParam String email) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
            return "Saved";
        }*//*
        @GetMapping(path="/all")
        public @ResponseBody Iterable<User> getAllUsers() {
            // This returns a JSON or XML with the users
            return userRepository.findAll();
        }
        @GetMapping(path="/find")
        public @ResponseBody
        Optional<User> findUser(@RequestParam Integer id) {
            // This returns a JSON or XML with the users
            return userRepository.findById(id);
        }
        @GetMapping(path="/send")
        public @ResponseBody
        String sendEmail(@RequestParam Integer id) {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userRepository.findById(id).get().getEmail());
            message.setSubject("Test Simple Email");
            message.setText("Hello, Im testing Simple Email");
            // Send Message!
            this.emailSender.send(message);
            return "Email Sent!";
        }
    }*/
