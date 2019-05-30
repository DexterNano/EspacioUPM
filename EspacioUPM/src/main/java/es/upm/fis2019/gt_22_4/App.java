package es.upm.fis2019.gt_22_4;

//IMPORTAR CLASES NECESARIAS

import es.upm.fis2019.gt_22_4.Controllers.DatabaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;

public class App
{
    public static void main(String[] args) {
        IDataBaseController databaseController = new DatabaseController();
        DatabaseController.addDefaultTables(databaseController);


    }

}
