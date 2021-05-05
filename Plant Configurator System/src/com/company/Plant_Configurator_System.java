package com.company;

import java.util.*;


public class Plant_Configurator_System {
    public List<User> users;
    public List<Plant_Sensor> plant_sensors;
    public static TITLE titles = TITLE.NONE;
    public static boolean already_logged_in = false;

    public Plant_Configurator_System() {
        this.plant_sensors = new ArrayList<Plant_Sensor>();
        this.users = new ArrayList<User>();
    }

    public Plant_Configurator_System(List<User> users) {
        this.users = users;
        this.plant_sensors = new ArrayList<Plant_Sensor>();
    }

    public Plant_Configurator_System(List<User> users, List<Plant_Sensor> plant_sensors) {
        this.users = users;
        this.plant_sensors = plant_sensors;
    }

    public void log_in(String username, String password) {
        boolean exists = false;

        for (User user : users) {
            if (user.getUser_name().equals(username) && user.getPassword().equals(password)) {
                if (user.getUser_name().equals("ADMIN")) {
                    titles = TITLE.ADMIN;
                    already_logged_in = true;
                    System.out.println("Admin logged in!");
                    exists = true;
                } else {
                    titles = TITLE.USER;
                    already_logged_in = true;
                    System.out.println("User " + user.getUser_name() + " logged in!");
                    exists = true;
                }
            }
        }
        if (!exists) {
            System.out.println("Username or password is incorrect!");
        }

    }

    public void register_user(String username, String password) {
        boolean exists = false;

        if (check_Admin_Title()) {

            for (User user : users) {
                if (user.getUser_name().equals(username)) {
                    System.out.println("Username already exists!");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                users.add(new User(username, password));
                System.out.println("User added!");
            }

        }
    }

    public void remove_User(String username) {
        boolean exists = false;
        int index = 0;

        if (check_Admin_Title()) {
            for (User user : users) {
                if (user.getUser_name().equals(username)) {
                    index = users.indexOf(user);
                    exists = true;
                    System.out.println("User " + username + " removed!");
                    break;
                }
            }
            if (exists) {
                users.remove(index);
            } else {
                System.out.println("User does not exist!");
            }
        }
    }

    public void register_sensor(String id, String status) {
        boolean exists = false;

        if (plant_sensors.isEmpty()) {
            plant_sensors.add(new Plant_Sensor(id, status));
            System.out.println("New plant sensor added!");
        } else {
            for (Plant_Sensor plant_sensor : plant_sensors) {
                if (plant_sensor.getId().equals(id)) {
                    System.out.println("Plant sensor already exists!");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                plant_sensors.add(new Plant_Sensor(id, status));
                System.out.println("Plant sensor added!");
            }
        }


    }

    public void remove_Sensor(String id) {
        int index = 0;
        boolean exists = false;

        for (Plant_Sensor plant_sensor : plant_sensors) {
            if (plant_sensor.getId().equals(id)) {
                System.out.println("Plant sensor with id:" + id + " removed");
                index = plant_sensors.indexOf(plant_sensor);
                exists = true;
                break;
            }
        }
        if (exists) {
            plant_sensors.remove(index);
        } else {
            System.out.println("Plant sensor with id: " + id + " does not exist!");
        }

    }


    public void sensor_status_check(String id) {

        for (Plant_Sensor plant_sensor : plant_sensors) {
            if (plant_sensor.getId().equals(id)) {
                System.out.println("Status: " + plant_sensor.getStatus());
            } else {
                System.out.println("Sensor id does not match the id's in the list!");
            }
        }

    }

    public void sensor_status_update(String id, String update_status) {
        boolean exists = false;
        if (plant_sensors.isEmpty()) {
            System.out.println("There are no sensors!");
        }
        for (Plant_Sensor plant_sensor : plant_sensors) {
            if (plant_sensor.getId().equals(id)) {
                plant_sensor.setStatus(update_status);
                System.out.println("Status updated!");
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("Sensor id does not match the id's in the list!");
        }
    }


    public void show_users() {
        if (check_Admin_Title()) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println();
        }
    }

    public void show_sensors() {
        for (Plant_Sensor plant_sensor : plant_sensors) {
            System.out.println(plant_sensor.toString());
        }
    }

    public void log_Out() {
        titles = TITLE.NONE;
        already_logged_in = false;
    }

    public boolean check_If_LoggedIn() {
        return already_logged_in;
    }

    public boolean check_Admin_Title() {
        return titles.equals(TITLE.ADMIN);
    }
}
