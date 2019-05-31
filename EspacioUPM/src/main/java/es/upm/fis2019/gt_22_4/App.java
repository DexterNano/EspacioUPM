package es.upm.fis2019.gt_22_4;

//IMPORTAR CLASES NECESARIAS

import es.upm.fis2019.gt_22_4.Controllers.DatabaseController;
import es.upm.fis2019.gt_22_4.Controllers.RegisterController;
import es.upm.fis2019.gt_22_4.Controllers.SessionController;
import es.upm.fis2019.gt_22_4.Controllers.UsuarioController;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.*;
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
        IUsuarioController userController;
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
                        if(user != null) {
                            salir=true;
                            System.out.println("------- Bienvenido @"+user.getAlias()+" -------");
                            System.out.println();
                        } else System.out.println("Inicio de sesión no valido.");
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

        opcion = 0;
        sn.reset();
        if(user!= null)
        {
            userController = new UsuarioController(databaseController);
            salir = false;
            while (!salir) {
                System.out.println("1. Mostrar timeline");
                System.out.println("2. Buscar Usuario");
                System.out.println("3. Realizar una publicacion");
                System.out.println("4. Ver Perfil");
                System.out.println("5. Desconectarse");
                try {
                    System.out.println("Elija una de las opciones: ");
                    opcion = sn.nextInt();
                    sn.nextLine();
                    switch (opcion) {
                        case 1:
                            userController.mostrar_timeline(user);
                            break;
                        case 2:
                            Usuario usuario;
                            String corr;
                            System.out.println("Ingrese el correo del usuario que desea buscar: ");
                            corr = sn.nextLine();
                            usuario = userController.buscarUser(corr);
                            if (usuario != null) {
                                int op;
                                boolean[] seguimiento = userController.checkSeguimiento(usuario, user);
                                System.out.println("-----------------------------");
                                System.out.println("           Perfil");
                                System.out.println("@" + usuario.getAlias());
                                if (seguimiento[0])
                                    System.out.println("Te sigue");
                                System.out.println();
                                System.out.println("1. Ver Publicaciones");
                                if (seguimiento[1])
                                    System.out.println("2.Dejar de seguir");
                                else
                                    System.out.println("2.Seguir");
                                System.out.println("3. Ir Al menu principal");
                                System.out.println();
                                System.out.println("-----------------------------");
                                System.out.println();
                                try {
                                    System.out.println("Escoja una opcion: ");
                                    op = sn.nextInt();
                                    switch (op) {
                                        case 1:
                                            userController.mostrar_publicaciones(usuario);
                                            break;
                                        case 2:
                                            if (seguimiento[1])
                                                userController.dejardeseguirUsuario(user, usuario);
                                            else
                                                userController.seguirUsuario(user, usuario);
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Opcion no valida");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Debes insertar un numero");
                                    sn.next();
                                }
                            } else
                                System.out.println("Usuario no encontrado, puede haberse cambiado de alias o haber borrado el perfil");
                            break;
                        //case 3: realizarPublicacion();
                        //    break;
                        //case 4: VerPerfil();
                        //    break;
                        case 5: userController.logOut();
                                salir=true;
                                break;
                        default:
                            System.out.println("Solo números entre el 1 y el 4");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un numero");
                    sn.next();
                }
            }
        }
    }

}
