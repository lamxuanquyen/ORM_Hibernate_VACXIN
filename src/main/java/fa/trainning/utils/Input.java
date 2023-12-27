package fa.trainning.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	}

	public static String inputString(String myPrint) {
		System.out.println(myPrint);
		String input = sc.nextLine().trim();
		while (input.equals("")) {
			System.out.println("Nhập sai định dạng chuỗi. Vui lòng nhập lại");
			return inputString(myPrint);
		}
		return input;
	}

	public static int inputInt(String myPrint) {
		try {
			System.out.println(myPrint);
			return Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Nhập sai định dạng số. Vui lòng nhập lại");
			return inputInt(myPrint);
		}
	}

	public static double inputDouble(String myPrint) {
		try {
			System.out.println(myPrint);
			return Double.parseDouble(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Nhập sai định dạng số. Vui lòng nhập lại");
			return inputDouble(myPrint);
		}
	}

	public static long inputLong(String myPrint) {
		try {
			System.out.println(myPrint);
			return Long.parseLong(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Nhập sai định dạng số. Vui lòng nhập lại");
			return inputLong(myPrint);
		}
	}

	/**
	 * Nhập email
	 */
	public static String inputEmail(String myPrint) {
		System.out.println(myPrint);
		String email = sc.nextLine();
		email = email.trim();
		if (!email.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {

			System.out.println("Nhập sai định dạng email. Vui lòng nhập lại");
			return inputEmail(myPrint);
		}
		return email;
	}

	/**
	 * Nhập Tour ID
	 */
	public static String inputTourID(String myPrint) {
		System.out.println(myPrint);
		String input = sc.nextLine();
		input = input.trim();

		// Kiểm tra xem mã tour có đúng 10 chữ số hay không
		if (input.length() != 10) {
			System.out.println("Nhập sai định dạng mã tour. Vui lòng nhập lại");
			return inputTourID(myPrint);
		}

		// Kiểm tra xem tất cả các ký tự trong số điện thoại có phải là chữ số hay không
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				System.out.println("Nhập sai định dạng mã tour. Vui lòng nhập lại");
				return inputTourID(myPrint);
			}
		}
		return input;
	}

	/**
	 * Nhập số tài khoản
	 */

	public static String inputSTK(String myPrint) {
		System.out.println(myPrint);
		String input = sc.nextLine();
		input = input.trim().toUpperCase();

		// Kiểm tra xem có đúng 7 chữ số hay không
		if (input.length() != 7) {
			System.out.println("Nhập sai định dạng số tài khoản. Vui lòng nhập lại");
			return inputSTK(myPrint);
		}

		if (input.charAt(0) != 'S') {
			System.out.println("Nhập sai định dạng số tài khoản. Vui lòng nhập lại");
			return inputSTK(myPrint);
		}

		if (input.charAt(1) != 'T') {
			System.out.println("Nhập sai định dạng số tài khoản. Vui lòng nhập lại");
			return inputSTK(myPrint);
		}

		if (input.charAt(2) != 'K') {
			System.out.println("Nhập sai định dạng số tài khoản. Vui lòng nhập lại");
			return inputSTK(myPrint);
		}

		for (int i = 3; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				System.out.println("Nhập sai định dạng số tài khoản. Vui lòng nhập lại");
				return inputSTK(myPrint);
			}
		}
		return input;
	}

	/**
	 * Nhập ngày tháng
	 */

	public static Date inputDate(String myPrint) {
		Date date = null;
		boolean flag = false;
		do {
			try {
				System.out.println(myPrint);
				// "Nhập hạn sử dụng (yyyy-MM-dd): "
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				// format ngày phải giống format yêu cầu người dùng nhập
				// MM: định dạng tháng trong java (nhớ ghi hoa, nếu không sẽ nhầm với minute)
				sdf.setLenient(false);
				// true: tự động covert ngày nhập sang 1 ngày khác hợp lệ, ví dụ 30/02 -> 02/03
				// false: bắt buộc nhập đúng
				try {
					String input = sc.nextLine();
					if (input.contains("-")) {
						sdf.applyPattern("MM-dd-yyyy");
					} else if (input.contains("/")) {
						sdf.applyPattern("MM/dd/yyyy");
					} else {
						throw new IllegalArgumentException();
					}
					date = sdf.parse(input);
					flag = true;
					return date;
				} catch (ParseException e) {
					System.out.println("Nhập không đúng định dạng vui lòng nhập lại");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Nhập không đúng định dạng vui lòng nhập lại");

			}
		} while (flag == false);
		return date;
	}

	public static double inputDoubleDoWhile(String myPrint) {
		double number = 0;
		boolean flag = false;
		do {
			try {
				System.out.println(myPrint);
				number = Double.parseDouble(sc.nextLine());
				flag = true;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai định dạng số. Vui lòng nhập lại");
			}
		} while (!flag);
		return number;
	}

	/**
	 * Nhập TourType
	 */
	public static String inputTourType(String myPrint) {
		String input;
		String[] array = { "Tour trong nước", "Tour nước ngoài" };
		boolean flag = false;
		do {
			System.out.println(myPrint + " (Chỉ được nhập các giá trị: " + String.join(", ", array) + ")");
			input = sc.nextLine();

			for (String string : array) {
				if (string.equalsIgnoreCase(input))
					return input;
			}

			System.out.println("Nhập sai yêu cầu. Vui lòng nhập lại");

		} while (!flag);
		return input;
	}

	/**
	 * Hàm lấy ngày tháng hiện tại (chỉ lấy ngày tháng, không lấy giờ)
	 */
	public static Date getCurrentDay() {
		Date currentDate = null;
		try {
			currentDate = getDateWithoutTimeUsingFormat();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentDate;
	}

	public static Date getDateWithoutTimeUsingFormat() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.parse(formatter.format(new Date()));
	}
}
