
package schoolManagement.Driver;

import java.util.List;
import java.util.Scanner;

import entity.Student;
import schoolManagement.service.StudentService;

public class StudentDriver {
	static Scanner sc;

	public static void main(String[] args) {
		StudentService service = new StudentService();

		System.out.println("---WELCOME TO STUDENT MANAGEMENT APPLICATION---");
		boolean flag = true;

		while (flag) {

			System.out.println("\n--WELCOME TO STUDENT DASHbOARD--");
			System.out.println("Enter 1 to add student data");
			System.out.println("Enter 2 to update student data");
			System.out.println("Enter 3 to delete student data");
			System.out.println("Enter 4 to fetch student data");
			System.out.println("Enter 5 to close student data");

			sc = new Scanner(System.in);
			System.out.println("enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				int res = service.save();
				if (res != 0)
					System.out.println("data saved");
			}
				break;

			case 2: {
				int res = service.update();
				if (res != 0)
					System.out.println("query updated");
			}
				break;

			case 3: {
				int res = service.delete();
				if (res != 0)
					System.out.println("row deleted");
			}
				break;

			case 4: {
				List<Student> list = service.fetchAll();

				for (Student student : list)
					System.out.println(student);
			}
				break;
			case 5: {
				service.exist();
				flag = false;
			}
				break;

			default:
				System.out.println("invalid choice entered");
				break;
			}
		}
		sc.close();
	}

}
