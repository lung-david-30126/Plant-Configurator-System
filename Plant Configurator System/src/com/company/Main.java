package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        User admin = new User("ADMIN", "ADMIN");
        Plant_Sensor plant_sensor =new Plant_Sensor("1","1234");

        List<User> users = new ArrayList<User>();
        List<Plant_Sensor> sensors = new ArrayList<Plant_Sensor>();
        users.add(admin);
        sensors.add(plant_sensor);
        Plant_Configurator_System plant_configurator_system = new Plant_Configurator_System(users,sensors);
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1-Log In\n2-Register new user\n3-Delete user\n4-Register new plant sensor\n" +
                    "5-Remove plant sensor\n6-Update " +
                    "a sensor status\n7-Check a sensor status\n8-Show data\n9-Log out\n10-Exit\nOption:");
            int option = s.nextInt();

            switch (option) {
                case 1: {
                    if (!plant_configurator_system.check_If_LoggedIn()) {
                        Scanner x = new Scanner(System.in);
                        System.out.println("Username: ");
                        String user_name = x.nextLine();
                        System.out.println("Password: ");
                        String password = x.nextLine();
                        plant_configurator_system.log_in(user_name, password);
                        break;
                    } else {
                        System.out.println("Someone is already logged in!");
                        break;
                    }
                }
                case 2: {
                    if (plant_configurator_system.check_If_LoggedIn() && plant_configurator_system.check_Admin_Title()){
                        Scanner x = new Scanner(System.in);
                        System.out.println("Username: ");
                        String user_name = x.nextLine();
                        System.out.println("Password: ");
                        String password = x.nextLine();
                        plant_configurator_system.register_user(user_name, password);
                    } else if (!plant_configurator_system.check_If_LoggedIn()) {
                        System.out.println("You are not logged in!");
                    } else if(!plant_configurator_system.check_Admin_Title()){
                        System.out.println("You do not have the right to do this!");
                    }
                    break;
                }
                case 3: {
                    if (plant_configurator_system.check_If_LoggedIn() && plant_configurator_system.check_Admin_Title()){
                        Scanner x = new Scanner(System.in);
                        System.out.println("Username to be deleted: ");
                        String user_name = x.nextLine();
                        plant_configurator_system.remove_User(user_name);
                    } else if (!plant_configurator_system.check_If_LoggedIn()) {
                        System.out.println("You are not logged in!");
                    } else if(!plant_configurator_system.check_Admin_Title()){
                        System.out.println("You do not have the right to do this!");
                    }
                    break;
                }

                case 4: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        Scanner x = new Scanner(System.in);
                        Scanner y = new Scanner(System.in);
                        System.out.println("Id: ");
                        String id = x.nextLine();
                        System.out.println("Status: ");
                        String status = y.nextLine();
                        plant_configurator_system.register_sensor(id, status);
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }
                case 5: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        Scanner x = new Scanner(System.in);
                        System.out.println("Id: ");
                        String id = x.nextLine();
                        plant_configurator_system.remove_Sensor(id);
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }

                case 6: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        Scanner x = new Scanner(System.in);
                        Scanner y = new Scanner(System.in);
                        System.out.println("Id: ");
                        String id = x.nextLine();
                        System.out.println("Status: ");
                        String status = y.nextLine();
                        plant_configurator_system.sensor_status_update(id, status);
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }
                case 7: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        System.out.println("Id: ");
                        Scanner x = new Scanner(System.in);
                        String id = x.nextLine();
                        plant_configurator_system.sensor_status_check(id);
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }
                case 8: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        plant_configurator_system.show_sensors();
                        plant_configurator_system.show_users();
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }
                case 9: {
                    if (plant_configurator_system.check_If_LoggedIn()) {
                        plant_configurator_system.log_Out();
                        System.out.println("Logged out..!");
                    } else {
                        System.out.println("You are not logged in!");
                    }
                    break;
                }
                case 10: {
                    System.out.println("Good bye!");
                    System.exit(1);
                }
                default: {
                    System.out.println("Wrong option!");
                }
            }
        }
    }
}
