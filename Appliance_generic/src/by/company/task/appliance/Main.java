package by.company.task.appliance;

import static by.company.task.controller.SearchCriteria.*;

import by.company.task.bean.Appliance;
import by.company.task.bean.TabletPC;
import by.company.task.controller.Criteria;
import by.company.task.controller.SearchCriteria;
import by.company.task.service.ServiceException;
import by.company.task.service.WarehouseService;
import by.company.task.service.impl.WarehouseServiceImpl;
import by.company.task.view.ViewApp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Controller controller = (Controller) new ApplianceController();
//        String request;
//        String response;
//        request = "logination admin admin";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("вывод всего каталога");
//        request = "viewAll";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("сортировка планшетов по батарее");
//        request = "sortLaptop battery_capacity";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("сортировка планшетов по объему памяти");
//        request = "sortLaptop memory_rom";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("\nпоиск по категории Refrigerator");
//        request = "findbycategory Refrigerator";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("поиск по категории Computer");
//        request = "findbycategory Computer";
//        response = controller.doAction(request);
//        System.out.println(response);
//
//        System.out.println("изменить логин и пароль");
//        request = "changeprofile user user user superuser";
//        response = controller.doAction(request);
//        System.out.println(response);

        System.out.println("поиск по любому критерию");
        System.out.println("микроволновка");
        List<Appliance> appliance = new ArrayList<Appliance>();
        Criteria<Oven> criteriaOven = new Criteria<Oven>();
        criteriaOven.add(Oven.CAPACITY, 33);
        criteriaOven.add(Oven.HEIGHT, 45);
        criteriaOven.add(Oven.DEPTH, 60);

        WarehouseService warehouseService = new WarehouseServiceImpl();
        try {
            appliance = warehouseService.find(criteriaOven);
        } catch (ServiceException e) {
            System.out.println("что-то пошло не так");
        }
        ViewApp view = new ViewApp();
        if (appliance.isEmpty()){
            System.out.println("предметов, удовлетворяющих критерию поиска нет");
        } else {
            view.PrintAll(appliance);
        }

        System.out.println("планшет");
        Criteria<SearchCriteria.TabletPC> criteriaTabletPC = new Criteria<SearchCriteria.TabletPC>();
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR, "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM, 4);

         warehouseService = new WarehouseServiceImpl();
        try {
            appliance = warehouseService.find(criteriaTabletPC);
        } catch (ServiceException e) {
            System.out.println("что-то пошло не так");
        }
        view = new ViewApp();
        if (appliance.isEmpty()){
            System.out.println("предметов, удовлетворяющих критерию поиска нет");
        } else {
            view.PrintAll(appliance);
        }

    }
}
