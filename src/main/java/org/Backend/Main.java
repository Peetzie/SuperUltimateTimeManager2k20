package org.Backend;

import org.Visuals.Launcher;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Project> projects = new ArrayList<Project>();
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static Scanner sc = new Scanner(System.in);
    static int currentUser;

    public static void main(String [] args){
        employees.add(new Employee(true));
        signIn(0);

        Launcher launcher = new Launcher();
        launcher.launchThis();

        while(true){
            command(sc.nextLine());
        }
    }

    public static void command(String str){

        String[] input = str.split(" ");

        switch(input[0]){
            case "signin":
                signIn(Integer.parseInt(input[1]));
                break;
            case "newemployee":
                if(input.length > 1){
                    if (input[1].equals("admin")){
                        employees.get(currentUser).createNewEmployee(true);
                    }
                    else{
                            employees.get(currentUser).createNewEmployee(false);
                    }
                }
                else{
                    employees.get(currentUser).createNewEmployee(false);
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

    private static void signIn(int id){
        if (employees.size() <= id){
            System.out.println("User "+id+" don't exist");
        }
        else if(employees.get(id).isAdmin()){
            System.out.println("Signed in as "+id+" (Admin)");
            currentUser = id;
        }
        else    {
            System.out.println("Signed in as "+id);
            currentUser = id;
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
}
