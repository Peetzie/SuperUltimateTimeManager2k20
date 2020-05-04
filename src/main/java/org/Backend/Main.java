package org.Backend;

import org.Visuals.Launcher;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Project> projects = new ArrayList<Project>();
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static Scanner sc = new Scanner(System.in);
    static int currentUser = -1;

    public static void main(String [] args){
        employees.add(new Employee("password","admin",true));

        Launcher launcher = new Launcher();
        launcher.launchThis();

        while(true){
            command(sc.nextLine());
        }
    }

    public static void command(String str){

        String[] input = str.split(" ");

        if(currentUser == -1 && !input[0].equals("signin")){
            System.out.println("Sign in before doing anything else");
            return;
        }

        switch(input[0]){
            case "signin":
                signIn(Integer.parseInt(input[1]),input[2]);
                break;
            case "newemployee":
                if(input.length > 3){
                    if (input[3].equals("admin")){
                        employees.get(currentUser).createNewEmployee(input[1],input[2],true);
                    }
                    else{
                            employees.get(currentUser).createNewEmployee(input[1],input[2],false);
                    }
                }
                else{
                    employees.get(currentUser).createNewEmployee(input[1],input[2],false);
                }
                break;
            case "newproject":
                employees.get(currentUser).createNewProject();
                break;
            case "assignpm":
                employees.get(currentUser).assignProjectManager(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                break;
            case "leaveproject":
                employees.get(currentUser).leaveProject(Integer.parseInt(input[1]));
                break;
            case "joinproject":
                employees.get(currentUser).joinProject(projects.get(Integer.parseInt(input[1])));
                break;
            case "assignhours":
                employees.get(currentUser).assignHours(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                break;
            case "edithours":
                employees.get(currentUser).editHours(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
                break;

        }
    }

    private static void signIn(int id, String password){
        if (employees.size() <= id){
            System.out.println("User "+id+" don't exist");
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
        }
        else{
            System.out.println("Password was incorrect");
        }
    }

    static boolean projectEmployeeRelationExist(Project project, Employee employee){
        for(int i = 0; i < project.getEmployeeRelations().size(); i++){
            if (project.getEmployeeRelations().get(i).getEmployee().equals(employee)){
                return true;
            }
        }
        return false;
    }

    static ProjectEmployeeRelation findProjectEmployeeRelation(Project project, Employee employee){
        for(int i = 0; i < project.getEmployeeRelations().size(); i++){
            if (project.getEmployeeRelations().get(i).getEmployee().equals(employee)){
                return project.getEmployeeRelations().get(i);
            }
        }
        return null;
    }

    public static ArrayList<Employee> getEmployees(){
        return employees;
    }
    public static ArrayList<Project> getProjects(){
        return projects;
    }
    public static int getCurrentUser(){
        return currentUser;
    }
}
