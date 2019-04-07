import java.io.*;
import java.math.MathContext;
import java.util.Scanner;

class StudInfo {

   public static DataInputStream d = new DataInputStream(System.in);
   public static String matricNo[] = new String[100];
   public static String name[] = new String[100];
   public static int courseWorkMark []= new int[100];
   public static int finalExamMark[] = new int [100];
   public static String grade[] = new String[100];
   public static double mark1;
   public static double mark2;
   public static int x = 1;
   public static String sgrade;
   public static int scourseWorkMark;
   public static int sfinalExamMark;

   //MENU
   public static void main(String[] args)throws IOException {
        menu();

   }




    public static void menu()throws IOException {

      System.out.println("<<<-- MAIN MENU -->>>");
      System.out.println("");
      System.out.println("[1] Add\n[2] Edit\n[3] Delete\n[4] Search\n[5] View\n[6] Exit");

      System.out.println("");
      System.out.print("Select a menu: ");
      int m = Integer.parseInt(d.readLine());

        switch(m) {

            case 1: //ADD DATA
                addData();
                break;
            case 2: //EDIT DATA
                editData();
                break;
            case 3: //DELETE DATA
                DeleteData();
                break;
            case 4: //SEARCH DATA
                SearchData();
                break;
            case 5: //VIEW DATA
                viewData();
                break;
            case 6: //EXIT SYSTEM
                break;
            default:
                break;  
        }
    }

    //DELETE
    public static void DeleteData()throws IOException {

    boolean result = false;
    int index = 0;

        spacing();
        System.out.print("<<<-- DELETE RECORDS -->>>\n\n");
        System.out.print("Search Student Matric Number: ");
        String smatricNo = d.readLine();

        for(int i=1;i<matricNo.length;i++) {
            if(matricNo[i] !=null) {    

                if(smatricNo.equalsIgnoreCase(matricNo[i])) {   
                    result = true;
                    index = i;
                }
            }       
        }

        if(result == true) {

            System.out.print("Matric: "+matricNo[index].toUpperCase()+ "          ");
            System.out.print("Name: "+name[index].toUpperCase()+ "          ");
            System.out.print("Course Work: "+courseWorkMark[index]+ "          ");
            System.out.print("Final Exam: "+finalExamMark[index]+ "          ");
            System.out.print("Grade: "+grade[index].toUpperCase()+ "          ");
            System.out.println("");

            System.out.print("Are you sure to save this record?[y]-y/[n]-no: ");
            String Ques = d.readLine();

            if(Ques.equalsIgnoreCase("y")) {

                matricNo[index] = null;
                name[index] = null;
                courseWorkMark[index] = 0;
                finalExamMark[index] = 0;
                grade[index] = null;


                for(int j=index+1;j<matricNo.length;j++)
                {   
                    matricNo[j-1] = matricNo[j];
                                    name[j-1] = name[j];
                                    courseWorkMark[j-1] = courseWorkMark[j];
                                    finalExamMark[j-1] = finalExamMark[j];
                                    grade[j-1] = grade[j];
                }       

                System.out.println("Record succesfully deleted!");
                System.out.println("\n\n<Press Enter>");
                String Ques1 = d.readLine();
                spacing();
                menu();

            } else{
                spacing();
                menu();
            }

        } else{

            System.out.print("Matric Number not found!");
            System.out.println("\n\n<Press Enter>");
            String Ques = d.readLine();
            spacing();
            menu(); 
        }
    }

    //SEARCH
    public static void SearchData()throws IOException {
    boolean result = false;
    int index=0;    

        spacing();
        System.out.print("<<<-- SEARCH DATA -->>>\n\n");
        System.out.print("Search Student Matric Number: ");
        String smatricNo = d.readLine();

        for(int i=1;i<matricNo.length;i++) {
            if(matricNo[i] !=null) {    

                if(smatricNo.equalsIgnoreCase(matricNo[i])) {   
                    result = true;
                    index = i;
                }
            }       
        }

        if(result==true) {

        System.out.print("Matric: " + matricNo[index].toUpperCase() + "          ");
        System.out.print("Name: " + name[index].toUpperCase() + "          ");
        System.out.print("Course Work: " + courseWorkMark[index] + "          ");   
        System.out.print("Final Exam: " + finalExamMark[index] + "          ");
        System.out.print("Grade: " + grade[index].toUpperCase() + "          ");
        System.out.println("");

            System.out.println("\n\n<Press Enter>");
            String Ques = d.readLine();
            spacing();
            menu();

        }else {

            System.out.print("Matric Number not found!");
            System.out.println("\n\n<Press Enter>");
            String Ques = d.readLine();
            spacing();
            menu(); 
        }       
    }

    //ADD
    public static void addData()throws IOException {

        spacing();
        System.out.print("<<<-- ADD DATA -->>>\n\n");
        System.out.print("Student Matric Number: ");
        String smatricNo = d.readLine();

        System.out.print("Student Name: ");
        String sname = d.readLine();

        System.out.print("Course Work: ");
        scourseWorkMark = Integer.parseInt(d.readLine());

        System.out.print("Final Exam: ");
        sfinalExamMark = Integer.parseInt(d.readLine());


      Calculate();


        System.out.print("Grade: " + sgrade);
        String sgrade = d.readLine();

        System.out.print("Are you sure to save this record?[y]-y/[n]-no: ");
        String Ques = d.readLine();

        if(Ques.equalsIgnoreCase("y")) {

            matricNo[x] = smatricNo;
            name[x] = sname;
            courseWorkMark[x] = scourseWorkMark;
            finalExamMark[x] = sfinalExamMark;
            grade[x] = sgrade;
            x++;
            spacing();
            menu();

        }else if(Ques.equalsIgnoreCase("n")) {
            spacing();
            menu();
        }
    }

    public static void spacing() {
        System.out.print("\n\n\n"); 
    }

    //VIEW
    public static void viewData()throws IOException {
        boolean center = false;

        spacing();
        System.out.print("<<<-- VIEW DATA -->>>\n\n");

        for(int i=1;i<matricNo.length;i++) {

            if(matricNo[i] != null) {

                System.out.print("Matric Number: " + matricNo[i].toUpperCase()+ "          ");
                System.out.print("Name: " + name[i].toUpperCase()+ "          ");
                System.out.print("Course Work: " + courseWorkMark[i]+ "          ");
                System.out.print("Final Exam: " + finalExamMark[i]+ "          ");
                System.out.print("Grade: " + grade[i].toUpperCase()+ "          ");     
                System.out.println("");
                center=true;
            }
        }

        if(center == false) {

            System.out.print("\nEMPTY DATABASE. NO RECORDS FOUND!");

        }

        System.out.println("\n\n<Press Enter>");
        String Ques = d.readLine();
        spacing();
        menu();

    }

    //EDIT
    public static void editData()throws IOException {
    boolean result = false;
    int index=0;

        spacing();
        System.out.print("<<<-- EDIT DATA -->>>\n\n");
        System.out.print("Search Matric Number: ");
        String smatricNo = d.readLine();

        for(int i=1;i<matricNo.length;i++) {
            if(matricNo[i] !=null) {    

                if(smatricNo.equalsIgnoreCase(matricNo[i])) {   
                    result = true;
                    index = i;
                }
            }       
        }

        if(result == true) {

            System.out.print(matric no[index] + "           " +name[index]+ "           " +courseWorkMark[index]+ "          " +finalExamMark[index]+ "           " +grade[index]+ "           \n\n");   



            System.out.print("Student Matric Number: ");
            String smatricNoedit = d.readLine();

            System.out.print("Student Name: ");
            String snameedit = d.readLine();

            System.out.print("Course Work: ");
            scourseWorkMark = Integer.parseInt(d.readLine());

            System.out.print("Final Exam: ");
            sfinalExamMark = Integer.parseInt(d.readLine());

         Calculate();

         System.out.print("Grade: " + sgrade);
           String sgrade = d.readLine();


            System.out.print("Are you sure to update this record?[y]-y/[n]-no: ");
            String Ques = d.readLine();

            if(Ques.equalsIgnoreCase("y")) {

                matricNo[index] = smatricNoedit;
                name[index] = snameedit;
                courseWorkMark[index] = scourseWorkMark;
                finalExamMark[index] = sfinalExamMark;
                    grade[index] = sgrade;
                spacing();
                menu();
            }

         else if(Ques.equalsIgnoreCase("n"))
         {
            spacing();
            menu();

           }

        }else {

            System.out.print("Matric Number not found!");
            System.out.println("\n\n<Press Enter>");
            String Ques = d.readLine();
            spacing();
            menu(); 
        }

    }

   //CALCULATION PART
   public static String Calculate()
   {
        double mark1 = scourseWorkMark * 60 / 100;
        double mark2 = sfinalExamMark * 40 / 100;
        double totalMark = mark1 + mark2;


            if (totalMark >= 90)
            {
                    sgrade = "A+";
            }
            else if (totalMark >= 80)
            {
                    sgrade = "A";
            }
             else if (totalMark >= 70)
            {
                    sgrade = "A-";
            }
            else if (totalMark >= 65)
            {
                    sgrade = "B+";
            }
            else if (totalMark >= 60)
            {
                    sgrade = "B";
            }
            else if (totalMark >= 55)
            {
                    sgrade = "C+";
            }
            else if (totalMark >= 50)
            {
                    sgrade = "C";
            }
            else if (totalMark >= 45)
               {
                    sgrade = "D";
            }
            else if (totalMark >= 40)
            {
                    sgrade = "E";
            }
            else
            {
                    sgrade = "F";
            }
            return sgrade;
   }
}
