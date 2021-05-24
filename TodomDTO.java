package todolist;

public class TodomDTO {
	private String todoid;
	private String todoname;
	private String todopw;
	private String todoemail;
	
	
	public TodomDTO() {
		super();
	}
	
	
	public TodomDTO(String todoid) {
		super();
		this.todoid = todoid;
	}

	public TodomDTO(String todoname, String todopw, String todoemail) {
		super();
		this.todoname = todoname;
		this.todopw = todopw;
		this.todoemail = todoemail;
	}
	public TodomDTO(String todoid, String todoname, String todopw, String todoemail) {
		super();
		this.todoid = todoid;
		this.todoname = todoname;
		this.todopw = todopw;
		this.todoemail = todoemail;
	}
	public String getTodoid() {
		return todoid;
	}
	public void setTodoid(String todoid) {
		this.todoid = todoid;
	}
	public String getTodoname() {
		return todoname;
	}
	public void setTodoname(String todoname) {
		this.todoname = todoname;
	}
	public String getTodopw() {
		return todopw;
	}
	public void setTodopw(String todopw) {
		this.todopw = todopw;
	}
	public String getTodoemail() {
		return todoemail;
	}
	public void setTodoemail(String todoemail) {
		this.todoemail = todoemail;
	}
	@Override
	public String toString() {
		return "TodomDTO [ ID =" + todoid + ", 닉네임 =" + todoname + ", PW =" + todopw + ", Email ="
				+ todoemail + "]";
	}
	
	
	

}
