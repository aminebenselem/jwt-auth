package com.example.demo.controller;
import auth.AuthParams;
import auth.JwtResponse;
import auth.Password;
import com.example.demo.config.TokenGeneration;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    @Autowired
    private PasswordEncoder pe;
    @Autowired
    private TokenGeneration tokenGeneration;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/users")
    public String getUsers() {
        List<User> users = userService.getAllUsers();
        for (User user :
                users) {
            user.setMDP(null);
            user.setCOMPTE_DOMIC(null);
        }
        String jsonStr = JSONArray.toJSONString(users);
        return jsonStr;
    }

    @GetMapping(path = "/users/{Mat_Pers}")
    public User getUser(@PathVariable String Mat_Pers) {
        User user = userService.getUser(Mat_Pers);
        user.setMDP(null);
        return user;
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<JwtResponse> signIn(@RequestBody AuthParams authParams) throws Exception {
        UserDetails userDetails = userService.loadUserByUsername(authParams.Mat_Pers);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authParams.Mat_Pers, authParams.MDP));

        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        String token = tokenGeneration.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(token);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);

    }

    @GetMapping(value = "/users/{Mat_Pers}/role")
    public String getUserRole(@PathVariable String Mat_Pers) {
        User user = userService.getUser(Mat_Pers);
        Gson gson = new Gson();
        return gson.toJson(user.getRole());
    }

    @PutMapping(value = "/updateemail")
    public void UpdateUserEmail (@RequestBody AuthParams Authparam ){
        userService.UpdateUserEmail(Authparam.Mat_Pers,Authparam.MDP);

    }
    @PutMapping(value = "/updatephone")
    public void UpdateUserPhone (@RequestBody AuthParams Authparam ){
        userService.UpdateUserPhone(Authparam.Mat_Pers,Authparam.MDP);
    }

}


    @PostMapping(value = "/updatepassword")
    public void changePassword(@RequestBody Password p) {

        User user1 = userService.getUser(p.Mat_Pers);
        boolean k= Objects.equals(p.newPassword, p.newPassword2);
        boolean f = pe.matches(p.oldPassword,user1.getMDP());
        if(k){
        if (f) {
            System.out.println("old password is correct");
            user1.setMDP(pe.encode(p.newPassword));
            userService.updatePassword(user1);
        } else {
            System.out.println("old password is wrong");

        }
        }else{
            System.out.println("passwords dont match");
        }
    }
}









