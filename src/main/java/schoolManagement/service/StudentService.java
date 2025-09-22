package schoolManagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Student;

public class StudentService {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "zeeshan";
	private static Connection connection;
	private static Scanner sc = new Scanner(System.in);

	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int save() {
		int res = 0;
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter age");
		int age = sc.nextInt();

		String sql = "insert into student values(?,?,?)";

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	public int update() {
		int res = 0;

		String sql = "update student set age=? where id=?";

		System.out.println("enter age");
		int age = sc.nextInt();
		System.out.println("enter id");
		int id = sc.nextInt();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, age);
			pstm.setInt(2, id);
			res = pstm.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}

	public int delete() {
		int res = 0;

		String sql = "delete from student where id=?";
		System.out.println("enter id you want to delete");
		int id = sc.nextInt();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	public List<Student> fetchAll() {
		List<Student> list = new ArrayList<>();
		String sql = "select * from student";

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public void exist() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
