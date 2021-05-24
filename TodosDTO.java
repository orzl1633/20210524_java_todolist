package todolist;

import java.util.Date;

public class TodosDTO {
	private int seq;
	private String todoid;
	private String tododate;
	private String todotime;
	private String todolist;
	private Date regdate;
	
	
	public TodosDTO() {
		super();
	}

	
	

	
	public TodosDTO(int seq, String tododate, String todotime, String todolist) {
		super();
		this.seq = seq;
		this.tododate = tododate;
		this.todotime = todotime;
		this.todolist = todolist;
	}


	public TodosDTO(int seq, String todoid, String tododate, String todotime, String todolist) {
		super();
		this.seq = seq;
		this.todoid = todoid;
		this.tododate = tododate;
		this.todotime = todotime;
		this.todolist = todolist;
	}



	public TodosDTO(int seq, String todoid, String tododate, String todotime, String todolist, Date regdate) {
		super();
		this.seq = seq;
		this.todoid = todoid;
		this.tododate = tododate;
		this.todotime = todotime;
		this.todolist = todolist;
		this.regdate = regdate;
	}


	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getTodoid() {
		return todoid;
	}



	public void setTodoid(String todoid) {
		this.todoid = todoid;
	}



	public String getTododate() {
		return tododate;
	}



	public void setTododate(String tododate) {
		this.tododate = tododate;
	}



	public String getTodotime() {
		return todotime;
	}



	public void setTodotime(String todotime) {
		this.todotime = todotime;
	}



	public String getTodolist() {
		return todolist;
	}



	public void setTodolist(String todolist) {
		this.todolist = todolist;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}





	@Override
	public String toString() {
		return "TodosDTO [ID =" + todoid + ", 날짜 =" + tododate + ", 시간 =" + todotime + ", 일정 ="
				+ todolist + ", 일정등록일자 =" + regdate + "]";
	}

	
	
}
