package es.upm.fis2019.gt_22_4.System;

import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IRegistrerController;
import es.upm.fis2019.gt_22_4.Interfaces.ISessionController;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioSystem {
    public UsuarioSystem(IRegistrerController regCont, ISessionController sesh) {
        registerController = regCont;
        sessionController = sesh;
    }

    private final static Pattern EMAIL_PATTERN
            = Pattern.compile("^[_A-Za-z0-9-.]+([A-Za-z0-9-_.]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$");
    private static Matcher match;
    private Scanner sc = new Scanner(System.in);
    private final IRegistrerController registerController;
    private final ISessionController sessionController;


    private static boolean checkEmail(String email){
        match = EMAIL_PATTERN.matcher(email);
        return !email.trim().equals("") && match.matches();
    }

    public boolean register() throws Exception
    {
        Usuario user;
        System.out.println("Introduce email:");
        String email = sc.nextLine();
        if(!checkEmail(email)) {
            System.out.println("EMAIL NO VALIDO!");
            return false;
        }
        System.out.println("Introduce contraseña:");
        String pwd = sc.nextLine();
        String alias;
        System.out.println("Introduzca un alias: ");
        alias = sc.nextLine();
        user = new Usuario(email, pwd,alias);
        return registerController.register(user);
    }
    public Usuario login()
    {
        System.out.println("Introduce email:");
        String usermail = sc.nextLine();
        System.out.println("Introduce contraseña:");
        String pwd = sc.nextLine();

        return sessionController.login(usermail,pwd);
    }

    public void logout() {
        sessionController.logout();
    }
}
