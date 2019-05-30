package es.upm.fis2019.gt_22_4;

//IMPORTAR CLASES NECESARIAS

import es.upm.fis2019.gt_22_4.Controllers.DatabaseController;
import es.upm.fis2019.gt_22_4.Controllers.RegisterController;
import es.upm.fis2019.gt_22_4.Controllers.SessionController;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IRegistrerController;
import es.upm.fis2019.gt_22_4.Interfaces.ISessionController;
import es.upm.fis2019.gt_22_4.System.PassSecurity;
import es.upm.fis2019.gt_22_4.System.UsuarioSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        IDataBaseController databaseController = new DatabaseController();
        DatabaseController.addDefaultTables(databaseController);

        IRegistrerController regCont = new RegisterController(databaseController, new PassSecurity());
        ISessionController sesh = new SessionController(databaseController, new PassSecurity());

        UsuarioSystem userSys = new UsuarioSystem(regCont, sesh);

        //CREAR GESTION USUARIOS EN SYSTEM

        //DEMO
        databaseController.connect();
        databaseController.ensureCreated();
        Usuario user = null;

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1: user = userSys.login();
                        if(user != null) salir=true; else System.out.println("Inicio de sesión no valido.");
                        break;
                    case 2: userSys.register();
                        break;
                    case 3: salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
