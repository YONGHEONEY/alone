package management;

import java.io.*;
import java.util.*;

public class Employee implements Serializable {
                                 // emp정브들이 모두 입력이 완료되면 직렬화 가능을 구현하기 위해 선언
    int empno; // 직원번호
    String ename;  // 직원이름
    int salary; // 월급

    public Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public String toString() {
        return empno+" "+ename+" "+salary;
    }
}

class EmployeeDemo{
    static Scanner in = new Scanner(System.in); // 전역화
    public static void main(String[] args) throws Exception {
        int choice = -1; // 메뉴선택을 위한 변수
        File file = new File("D:\\employee.txt"); // al 객체들의 정보들을 저장할 txt파일 생성
        ArrayList<Employee> al = new ArrayList<Employee>();
        // 입력한 Employee 객체의 정보를 파일에 저장하여 출력을 위한 변수선언(객체 출력 스트림)
        ObjectOutputStream oos = null;
        // 초기값 null (해당지점부터 new OutputStream 을 선언할 경우 데이터를 저장되지않고 종료되기때문에
        // 사원 객체들의 정보들을 입력받고 저정하는 변수 다음 부분에 선언을 해줘야한다.
        ObjectInputStream ois = null;
        // inputstream을 선언해줘야 입력한 데이터들이 해당 txt파일안에 데이터가 존재하는지 여부를 if문으로 표현하여
        // 데이터가 들어있으면 해당 데이터들을 그대로 가져와준다.
        ListIterator li = null; // 반복자 Iterator 선언

        if(file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Employee>) ois.readObject();
            // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
            ois.close();
        }

        do {
            System.out.println("1.INSERT(추가)");
            System.out.println("2.DISPLAY(출력)");
            System.out.println("3.SEARCH(조회)");
            System.out.println("4.DELETE(삭제)");
            System.out.println("5.UPDATE(갱신)");
            System.out.println("6.SORT(정렬)-EmpNo On Screen");
            System.out.println("7.SORT(정렬)-EmpNo In File");
            System.out.println("8.SORT(정렬)-EmpName On Screen");
            System.out.println("9.SORT(정렬)-EmpName In File");
            System.out.println("10.SORT(정렬)-Salary Desc On Screen");
            System.out.println("11.SORT(정렬)-Salary Asc In File");
            System.out.println("0.EXIT(종료)");
            System.out.print("Enter Your Choice : ");
            choice = in.nextInt();

            switch (choice) {
                case 1: // INSERT
                    // 입력한 인원수만큼 for반복문을 통해 ArrayList al 객체에 저장
                    System.out.println("Enter how many employees you want : ");
                    int n = in.nextInt();

                    for (int i=0; i<n; i++) {
                        System.out.print("Enter Employee No : ");
                        int empno = in.nextInt();
                        System.out.print("Enter Employee Name : ");
                        String ename = in.next();
                        System.out.print("Enter Employee Salary : ");
                        int salary = in.nextInt();
                        in.nextLine();

                        // 입력받은 Employee 데이터들을 al 객체에 저장
                        al.add(new Employee(empno, ename, salary));
                    }
                    // 반복문 안에 넣을 경우 새로 시작할때마다 값들이 초기화되어 기존에 있던 데이터를 사용하지 못해
                    // 반복문이 종료되는 부분 다음에 선언을 해줘야 해당 입력한 데이터들이 지속적으로 저장된다.
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                break;
                // 각 구문 실행시 file.isFile() 메소드를 사용하여 유효성 검사를 실시 후 실행
                case 2: // DISPLAY
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                break;

                case 3: // SEARCH
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        boolean found = false;
                        System.out.print("Enter empno to SEARCH : ");
                        int empno = in.nextInt(); // 직원번호 입력
                        System.out.println("----------------");
                        li = al.listIterator();
                        // li 변수안에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
                                System.out.println(e);
                                found = true; // 유효성 검사
                            }
                        }
                        System.out.println("----------------");
                        if (!found) {
                            System.out.println("RECORD NOT FOUND");
                        }
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                break;
                case 4: // DELETE
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        boolean found = false;
                        System.out.print("Enter empno to Delete : ");
                        int empno = in.nextInt(); // 직원번호 입력
                        System.out.println("----------------");
                        li = al.listIterator();
                        // li 변수안에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
                                li.remove();
                                found = true; // 유효성 검사
                            }
                        }
                        System.out.println("----------------");
                        if (!found) {
                            System.out.println("RECORD NOT FOUND");
                        } else {
                            // 삭제 후 리스트를 업데이트
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("RECORD DELETED Successfully");
                        }
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;

                case 5:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        boolean found = false;
                        System.out.print("Enter empno to Update : ");
                        int empno = in.nextInt(); // 직원번호 입력
                        System.out.println("----------------");
                        li = al.listIterator();
                        // li 변수안에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
                                System.out.print("Enter New empName : ");
                                String ename = in.next();

                                System.out.print("Enter new Salary : ");
                                int salary = in.nextInt();
                                li.set(new Employee(empno, ename, salary));
                                found = true; // 유효성 검사
                            }
                        }
                        System.out.println("----------------");
                        if (!found) {
                            System.out.println("RECORD NOT FOUND");
                        } else {
                            // 삭제 후 리스트를 업데이트
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("RECORD Updated Successfully");
                        }
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 6:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e1.empno - e2.empno;
                            }
                        });

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 7:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e1.empno - e2.empno;
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 8:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e1.ename.compareTo(e2.ename);
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 9:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e1.ename.compareTo(e2.ename);
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 10:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e2.salary - e1.salary;
                            }
                        });

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
                case 11:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        // Unchecked cast: 'java.lang.Object' to -> 'java.util.ArrayList<management.Employee>'
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            @Override
                            public int compare(Employee e1, Employee e2) {
                                return e1.salary - e2.salary;
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------");
                        li = al.listIterator();
                        // li 반복자 변수에 al 객체의 데이터들을 저장
                        while (li.hasNext()) {
                            System.out.println(li.next());
                            // al 객체안에 있는 데이터들을 출력
                        }
                        System.out.println("------------------");
                    } else {
                        System.out.println("FILE NOT EXISTS");
                    }
                    break;
            }
        }while (choice != 0);
    }
}
