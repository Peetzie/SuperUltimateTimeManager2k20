package org.Backend;

import org.Visuals.Launcher;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {//this is the central main function for running the program
    //variable initiation
    private static ArrayList<Project> projects;
    private static ArrayList<Employee> employees;
    private static Scanner sc;
    private static int currentUser;
    private static BlockingQueue<InterfaceMessage> interfaceMessages;
    private static boolean printProjectInformationOnProjectEmployeeRelations;

    public static void main(String [] args){
        System.out.println(">>>Welcome to SUPER ULTIMATE TIME MANAGER 2K20: Fuld kaos pilot edition<<<");
        setup();


        if (true){//for debugging change true to false to use console mode
            Launcher launcher = new Launcher();
            launcher.launchThis();
        }
        else {
            while (true) {
                command(sc.nextLine());
            }
        }


    }

    public static void setup(){
        projects = new ArrayList<Project>();
        employees = new ArrayList<Employee>();
        sc = new Scanner(System.in);
        currentUser = -1;
        interfaceMessages = new ArrayBlockingQueue<InterfaceMessage>(128);
        printProjectInformationOnProjectEmployeeRelations = true;

        employees.add(new Employee("password","admin",true));
    }

    public static boolean command(String str){//this function is in charge of taking commands/inputs from the interface
        System.out.println("> "+str);

        String[] input = str.split(" ");

        if(currentUser == -1 && !input[0].equals("signin") && !input[0].equals("help")){
            System.out.println("Sign in before doing anything else");
            return false;
        }

        try {
            switch(input[0]){//checks the first word to determine the type of input
                case "signin":
                    return signIn(Integer.parseInt(input[1]),input[2]);
                case "signout":
                    signOut();
                    return true;
                case "newemployee":
                    if(input.length > 3){
                        if (input[3].equals("admin")){
                            return employees.get(currentUser).createNewEmployee(input[1],input[2],true);
                        }
                        else{
                            return employees.get(currentUser).createNewEmployee(input[1],input[2],false);
                        }
                    }
                    else{
                        return employees.get(currentUser).createNewEmployee(input[1],input[2],false);
                    }
                case "newproject":
                    return employees.get(currentUser).createNewProject(input[1],input[2],Integer.parseInt(input[3]), Long.parseLong(input[4]));
                case "newactivity":
                    return employees.get(currentUser).createActivity(Integer.parseInt(input[1]),input[2], input[3], Integer.parseInt(input[4]), Integer.parseInt(input[5]));
                case "assignactivity":
                    return employees.get(currentUser).assignActivity(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                case "joinactivity":
                    employees.get(currentUser).joinActivity(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    return true;
                case "leaveproject":
                    employees.get(currentUser).leaveProject(Integer.parseInt(input[1]));
                    return true;
                case "joinproject":
                    employees.get(currentUser).joinProject(projects.get(Integer.parseInt(input[1])));
                    return true;
                case "assignpm":
                    return employees.get(currentUser).assignProjectManager(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                case "assignhours":
                    employees.get(currentUser).assignHours(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                    return true;
                case "edithours":
                    employees.get(currentUser).editHours(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
                    return true;
                case "help":
                    printHelp();
                    break;

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private static void printHelp(){//for console mode you can use this function to get a list of viable options
        System.out.println("signin [employee]");
        System.out.println("signout");
        System.out.println("newemployee [password] [name] (admin)");
        System.out.println("newproject [name] [description] [estimated time] [deadline]");
        System.out.println("newactivity [projact] [title] [description] [estimated time] [deadline]");
        System.out.println("assignactivity [projact] [activity] [employee]");
        System.out.println("joinactivity [projact] [activity]");
        System.out.println("assignpm [project] [employee]");
        System.out.println("leaveproject [project]");
        System.out.println("joinproject [project]");
        System.out.println("assignhours [project]] [start time] [duration]");
        System.out.println("edithours [project] [entry index] [start time] [duration]");
    }

    private static boolean signIn(int id, String password){//handles login inputs
        if (employees.size() <= id){
            System.out.println("Employee "+id+" don't exist");
        }
        if (password.equals(employees.get(id).getPassword())){
            if(employees.get(id).isAdmin()){
                System.out.println("Signed in as "+id+" (Admin)");
                currentUser = id;
            }
            else    {
                System.out.println("Signed in as "+id);
                currentUser = id;
            }
            return true;
        }
        else{
            System.out.println("Password was incorrect");
            return false;
        }
    }

    public static void signOut(){//handles logout inputs
        currentUser = -1;
        System.out.println("Employee has signed out");
    }

    static boolean projectEmployeeRelationExist(Project project, Employee employee){//checks if the employee is assigned to the project
        for(int i = 0; i < project.getEmployeeRelations().size(); i++){
            if (project.getEmployeeRelations().get(i).getEmployee().equals(employee)){
                return true;
            }
        }
        return false;
    }

    static ProjectEmployeeRelation findProjectEmployeeRelation(Project project, Employee employee){//returns the specific relation or null
        for(int i = 0; i < project.getEmployeeRelations().size(); i++){
            if (project.getEmployeeRelations().get(i).getEmployee().equals(employee)){
                return project.getEmployeeRelations().get(i);
            }
        }
        return null;
    }

    //getters and setters
    public static ArrayList<Employee> getEmployees(){
        return employees;
    }
    public static ArrayList<Project> getProjects(){
        return projects;
    }
    public static int getCurrentUser(){
        return currentUser;
    }

    public static boolean isPrintProjectInformationOnProjectEmployeeRelations() {
        return printProjectInformationOnProjectEmployeeRelations;
    }

    public static void setPrintProjectInformationOnProjectEmployeeRelations(boolean printProjectInformationOnProjectEmployeeRelations) {
        Main.printProjectInformationOnProjectEmployeeRelations = printProjectInformationOnProjectEmployeeRelations;
    }
}
