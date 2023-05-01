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
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
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
    @GetMapping(value = "/fichedepaie")
    public void generatePdf(HttpServletResponse response) throws IOException, DocumentException {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        // create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // open the document for writing
        document.open();

        // create a table with two columns
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        // add the title to the first cell of the first row
        Image image = Image.getInstance("src/main/resources/static/ont.jpg");

        image.scaleToFit(90, 90);
        Phrase titleAndImage = new Phrase();
        titleAndImage.add(new Chunk(image, -70, -30, true));
        titleAndImage.add(new Chunk("OFFICE NATIONAL DE LA TELEDIFFUSION\n                           Adresse:CITE ENNASIM 1 - MONTPLAISIR -BP399 \n1080 TUNIS -TUNISIE"));
        PdfPCell titleAndImageCell = new PdfPCell(titleAndImage);
        titleAndImageCell.setBorder(Rectangle.BOX);
        titleAndImageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleAndImageCell.setVerticalAlignment(Element.ALIGN_TOP);
        titleAndImageCell.setPadding(50);
        table.addCell(titleAndImageCell);
        // add the table to the document
        document.add(table);



        PdfPTable table2 = new PdfPTable(2);
        table2.setWidthPercentage(100);



        PdfPCell titleCell = new PdfPCell(new Phrase("Bulletin de Paie: Saliare Mensuel"));
        titleCell.setBorder(Rectangle.BOX);
        titleCell.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell.setPadding(10);
        table2.addCell(titleCell);





        // add the customer information to the second row
        PdfPCell infoCell = new PdfPCell(new Paragraph("Mois:"));
        infoCell.setBorder(Rectangle.BOX);
        infoCell.setPadding(10);
        table2.addCell(infoCell);



        // add the table to the document
        document.add(table2);


        PdfPTable table3 = new PdfPTable(3);
        table3.setWidthPercentage(100);

        PdfPCell titleCell3 = new PdfPCell(new Phrase("MATRICULE:"+user.getMat_Pers()));
        titleCell3.setBorder(Rectangle.BOX);
        titleCell3.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell3.setPadding(10);
        table3.addCell(titleCell3);


        // add the customer information to the second row
        PdfPCell infoCell5 = new PdfPCell(new Paragraph("NOM ET PRENOM :"+user.getNOM_PERS()+" "+user.getPREN_PERS()));
        infoCell5.setBorder(Rectangle.BOX);
        infoCell5.setPadding(10);
        table3.addCell(infoCell5);
        PdfPCell infoCell6 = new PdfPCell(new Paragraph("Affectation:"));
        infoCell6.setBorder(Rectangle.BOX);
        infoCell6.setPadding(10);
        table3.addCell(infoCell6);


        // add the customer information to the second row
        PdfPCell infoCell3 = new PdfPCell(new Paragraph("Fonction :"));
        infoCell3.setBorder(Rectangle.BOX);
        infoCell3.setPadding(10);
        table3.addCell(infoCell3);
        PdfPCell infoCell4 = new PdfPCell(new Paragraph("Grade: " +user.getGRADE_ADM()));
        infoCell4.setBorder(Rectangle.BOX);
        infoCell4.setPadding(10);
        table3.addCell(infoCell4);



        PdfPCell titleCell4 = new PdfPCell(new Phrase("Qualification :"));
        titleCell4.setBorder(Rectangle.BOX);
        titleCell4.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell4.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell4.setPadding(10);
        table3.addCell(titleCell4);



        // add the customer information to the second row
        PdfPCell infoCell7 = new PdfPCell(new Paragraph("LU CNRPS :"));
        infoCell7.setBorder(Rectangle.BOX);
        infoCell7.setPadding(10);
        table3.addCell(infoCell7);
        PdfPCell infoCell8 = new PdfPCell(new Paragraph("MATR CNSS: "));
        infoCell8.setBorder(Rectangle.BOX);
        infoCell8.setPadding(10);
        table3.addCell(infoCell8);



        PdfPCell titleCell9 = new PdfPCell(new Phrase("N ASS Group:"+user.getNUM_ASS()));
        titleCell9.setBorder(Rectangle.BOX);
        titleCell9.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell9.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell9.setPadding(10);
        table3.addCell(titleCell9);









        // add the table to the document
        document.add(table3);
        PdfPTable table4 = new PdfPTable(2);
        table4.setWidthPercentage(100);



        PdfPCell titleCell8 = new PdfPCell(new Phrase("Situation famille : "));
        titleCell8.setBorder(Rectangle.BOX);
        titleCell8.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell8.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell8.setPadding(10);
        table4.addCell(titleCell8);





        // add the customer information to the second row
        PdfPCell infoCell9 = new PdfPCell(new Paragraph("nombre d'enfant:"));
        infoCell9.setBorder(Rectangle.BOX);
        infoCell9.setPadding(10);
        table4.addCell(infoCell9);



        // add the table to the document
        document.add(table4);





        PdfPTable table5 = new PdfPTable(3);
        table5.setWidthPercentage(100);

        PdfPCell titleCell5 = new PdfPCell(new Phrase("MATRICULE:"+user.getMat_Pers()));
        titleCell5.setBorder(Rectangle.BOX);
        titleCell5.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell5.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell5.setPadding(10);
        table5.addCell(titleCell3);


        // add the customer information to the second row
        PdfPCell infoCell10= new PdfPCell(new Paragraph("Categorie:"+user.getCOD_CAT()));
        infoCell10.setBorder(Rectangle.BOX);
        infoCell10.setPadding(10);
        table5.addCell(infoCell5);
        PdfPCell infoCell11 = new PdfPCell(new Paragraph("Echelle:"+user.getECH_EMB()));
        infoCell11.setBorder(Rectangle.BOX);
        infoCell11.setPadding(10);
        table5.addCell(infoCell11);


        // add the customer information to the second row
        PdfPCell infoCell12 = new PdfPCell(new Paragraph("POST/paie: " +user.getPOSTE_TRAV()));
        infoCell12.setBorder(Rectangle.BOX);
        infoCell12.setPadding(10);
        table5.addCell(infoCell12);
        PdfPCell infoCell13 = new PdfPCell(new Paragraph("POST/ADM: " ));
        infoCell13.setBorder(Rectangle.BOX);
        infoCell13.setPadding(10);
        table5.addCell(infoCell13);



        PdfPCell titleCell14 = new PdfPCell(new Phrase("Solde Congé:"));
        titleCell14.setBorder(Rectangle.BOX);
        titleCell14.setVerticalAlignment(Element.ALIGN_TOP);
        titleCell14.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell14.setPadding(10);
        table5.addCell(titleCell14);









        // add the table to the document
        document.add(table5);



        // close the document
        document.close();

        // set the response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"FicheDePaie.pdf\"");
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
}





