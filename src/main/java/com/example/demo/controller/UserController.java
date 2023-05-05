package com.example.demo.controller;

import auth.AuthParams;
import auth.JwtResponse;
import auth.Password;
import auth.UserFormation;
import com.example.demo.config.TokenGeneration;
import com.example.demo.entity.*;
import com.example.demo.repository.UserDao;
import com.example.demo.service.UserService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;


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
    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getAllUsers();
        for (User user :
                users) {
            user.setMDP(null);
            user.setCOMPTE_DOMIC(null);
            user.setCIN(null);
            user.setMesFormation(null);
            user.setNUM_ASS(null);
        }

        return users;
    }

    @GetMapping(path = "/user")
    public User getUser() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setMDP(null);
        user.setGRADE_ADM(user.getGrade().getLIB_ADM());
        return user;
    }

    @GetMapping({"/users/tasks"})
    public List<Agenda> getalltasks() {
        User user = this.userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.getAgenda();
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

    @GetMapping(value = "/users/role")
    public String getUserRole() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.getRole();
    }

    @PutMapping(value = "/updateemail")
    public void UpdateUserEmail(@RequestBody AuthParams Authparam) {
        if(Objects.equals(Authparam.Mat_Pers, SecurityContextHolder.getContext().getAuthentication().getName())){
            userService.UpdateUserEmail(Authparam.Mat_Pers, Authparam.MDP);
        }
    }

    @PutMapping(value = "/updatephone")
    public void UpdateUserPhone(@RequestBody AuthParams Authparam) {
        userService.UpdateUserPhone(Authparam.Mat_Pers, Authparam.MDP);
    }


    @PostMapping(value = "/updatepassword")
    public String changePassword(@RequestBody Password p) {

        User user1 = userService.getUser(p.Mat_Pers);
        boolean k = Objects.equals(p.newPassword, p.newPassword2);
        boolean f = pe.matches(p.oldPassword, user1.getMDP());
        if (k) {
            if (f) {

                user1.setMDP(pe.encode(p.newPassword));
                userService.updatePassword(user1);
                return "old password is correct";
            } else {
                return "old password is wrong";

            }
        } else {
            return "saisir le méme mot de passe";
        }
    }

    @PutMapping(value = "/updatephoto")
    public void UpdateUserPhoto(@RequestBody AuthParams Authparam) {
        userService.UpdateUserPhoto(Authparam.Mat_Pers, Authparam.MDP);
    }

    public String getDest() {
        String home = System.getProperty("user.home");
        String dir = home + File.separator + "Downloads" + File.separator + "AttestationDeTravail.pdf";
        return dir;
    }

    @GetMapping(value = "/attestation")
    public ResponseEntity<byte[]> generateAttestation(HttpServletResponse response) throws IOException {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        String username=user.getMat_Pers();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        // open the document for writing
        document.open();

        // add content to the document
        Image image = Image.getInstance("src/main/resources/static/headerpdfattestation.jpg");
        image.setAlignment(Element.ALIGN_CENTER);
        image.scaleToFit(200, 200);
        document.add(image);
        Paragraph  title=new Paragraph(" Attestation de travail",font1);
        Paragraph  o=new Paragraph(" ............o.........",font1);
        title.setSpacingBefore(20);
        title.setAlignment(Element.ALIGN_CENTER);
        o.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(o);
        document.setMargins(36, 72, 108, 144);

        Paragraph body=new Paragraph("Le Président, Directeur Général du Bureau National de la Radiodiffusion et de la Télévision, certifie que Monsieur "+user.getNOM_PERS().toLowerCase()+" "+user.getPREN_PERS().toLowerCase()+" occupe un plan de "+user.getGrade().getLIB_ADM().toLowerCase()+", apprenti, au Centre de Transmission de la Radio et de la Télévision, étrangement.",font);
        body.setSpacingBefore(60);

        document.add(body);
        // close the document
        document.close();

        // set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "attestation.pdf");
        headers.setContentLength(baos.size());

        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);

    }

    @GetMapping(value = "/famille")
    public List<Famille> getUserFamily() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        return user.getFamille();
    }
    @PostMapping({"/addformationUser"})
    public ResponseEntity<HttpStatus> userFormation(@RequestBody UserFormation userFormation) {
        User x;
        for (String user:
                userFormation.users) {
            x= userService.getUser(user);
            x.getMesFormation().add(userFormation.formation);
            userDao.save(x);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping(value = "/mesformation")
    public Set<Formation> getUserFormation() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        return user.getMesFormation();
    }
    @GetMapping(value = "/mesnotification")
    public List<Notification> getUserNotif() {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        return user.getNotification();
    }
    @GetMapping(value = "/getdemandebyuser")
    public Set<DemandesAdministratif> getUserDemande(){
        User user=userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.getDemande();
    }

}





