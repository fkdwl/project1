package JDB;

import java.util.ArrayList;

public class Vo {
	private String dept_id;
	private String dept_password;
	private String dept_name;
	private String dept_address;
	private String dept_number;

	public Vo() {

	}

	public Vo(String dept_id, String dept_password, String dept_name, String dept_address, String dept_number) {
		this.dept_id = dept_id;
		this.dept_password = dept_password;
		this.dept_name = dept_name;
		this.dept_address = dept_address;
		this.dept_number = dept_number;
	}

	public String getDept_id() {
		return dept_id;
	}

	public String getDept_password() {
		return dept_password;
	}

	public String getDept_name() {
		return dept_name;
	}

	public String getDept_address() {
		return dept_address;
	}

	public String getDept_number() {
		return dept_number;

	}



}
