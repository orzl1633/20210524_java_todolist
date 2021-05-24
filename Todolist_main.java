package todolist;

import java.util.List;
import java.util.Scanner;






public class Todolist_main {

	public static void main(String[] args) {
		
		TodomDAO tmdao = new TodomDAO();
		TodosDAO tsdao = new TodosDAO();
		int cnt;
		Scanner sc = new Scanner(System.in);
		boolean logincheck = false;
		String login_userid = "";
		
		
		
		
		while(true) {
			System.out.println("--------------------------");
			System.out.println("-----일정관리 프로그램----");
			System.out.println("--------------------------");
			System.out.println("0.회원가입");
			System.out.println("1.로그인");
			System.out.println("2.회원수정");
			System.out.println("3.회원삭제");
			System.out.println("4.선택회원조회");
			System.out.println("5.전체회원조회");
			System.out.println("9.종료");
			System.out.println("--------------------------");
			System.out.print("번호:");
			int no = sc.nextInt();
			
			//로그인
			if(no==1) {
				System.out.print("아이디:");
				String todoid = sc.next();
				System.out.print("패스워드:");
				String todopw = sc.next();
				TodomDTO tmdto = tmdao.selectOne(todoid);
				
				
				if (tmdto==null) {
					System.out.println("아이디가 존재하지 않습니다");
					logincheck = false;
					login_userid = "";
				}else {
					if(tmdto.getTodopw().equals(todopw)) {
						System.out.println("로그인 성공");
						logincheck = true;
						login_userid = todoid;
					}else {
						System.out.println("패스워드가 일치하지 않습니다");
						logincheck = false;
						login_userid = "";
						
					}
				
					if(tmdto.getTodopw().equals(todopw)) {	
						while(true) {
							System.out.println("--------------------------");
							System.out.println("[" +login_userid+ "]님의 일정관리");
							System.out.println("--------------------------");
							System.out.println("1.일정 조회");
							System.out.println("2.일정 등록");
							System.out.println("3.일정 수정");
							System.out.println("4.일정 삭제");
							System.out.println("9.종료");
							System.out.println("--------------------------");
							System.out.print("번호:");
							int todo = sc.nextInt();
				
							
							
							//선택아이디 
							if(todo==1) {
								System.out.print("조회 할 아이디:");
								todoid = sc.next();	
								String todolist = null;
								List<TodosDTO> tslist = tsdao.selectList(todoid);
								for(TodosDTO ts : tslist) {
									System.out.println(ts.getSeq() + " " + ts.getTodoid() + " " + ts.getTododate() + 
											" " + ts.getTodotime() + ts.getTodolist());
								}		
								
							}
							
							
							//등록
							else if(todo==2) {
								System.out.print("조회 할 아이디:");
								todoid = sc.next();	
								String todolist = null;
								List<TodosDTO> tslist = tsdao.selectList(todoid);
								for(TodosDTO ts : tslist) {
									System.out.println(ts.getSeq() + " " + ts.getTodoid() + " " + ts.getTododate() + 
											" " + ts.getTodotime() + ts.getTodolist());
								}		
								System.out.print("등록할번호:");
								int seq = sc.nextInt();
								System.out.print("등록할아이디:");
								todoid = sc.next();
//								TodosDTO tsdto = tsdao.selectOne(todoid);
								
								
								System.out.print("등록할 날짜:");
								String tododate = sc.next();
								System.out.print("등록할 시간:");
								String todotime = sc.next();
								System.out.print("할일:");
								todolist = sc.next();
							
								
								TodosDTO tsdto = new TodosDTO(seq,todoid,tododate,todotime,todolist);
								cnt = tsdao.insert(tsdto);
								if (cnt > 0) {
									System.out.println(todoid + "님 일정 등록");
								}else {
									System.out.println(todoid + "님 등록실패");
								}
								
								
							}
							
							//수정
							else if(todo==3) {
								
								System.out.print("조회 할 아이디:");
								todoid = sc.next();	
								String todolist = null;
								List<TodosDTO> tslist = tsdao.selectList(todoid);
								for(TodosDTO ts : tslist) {
									System.out.println(ts.getSeq() + " " + ts.getTodoid() + " " + ts.getTododate() + 
											" " + ts.getTodotime() + ts.getTodolist());
								}		
								
								System.out.print("수정할번호:");
								int seq = sc.nextInt();
//								System.out.print("수정할 아이디");
//								todoid = sc.next();
//								TodosDTO tsdto = tsdao.selectOne(todoid);
								
								System.out.print("날짜");
								String tododate = sc.next();
								System.out.print("시간:");
								String todotime = sc.next();
								System.out.print("할일:");
								todolist = sc.next();
								
								TodosDTO tsdto = new TodosDTO(seq,tododate,todotime,todolist);
								cnt = tsdao.update(tsdto);
								
								if (cnt > 0) {
									System.out.println(todoid  + "님 일정 수정");
								}else {
									System.out.println(todoid  + "님 일정 수정 실패");
								}
				
							}
							//삭제
							else if(todo==4) {
								System.out.print("조회 할 아이디:");
								todoid = sc.next();	
								String todolist = null;
								List<TodosDTO> tslist = tsdao.selectList(todoid);
								for(TodosDTO ts : tslist) {
									System.out.println(ts.getSeq() + " " + ts.getTodoid() + " " + ts.getTododate() + 
											" " + ts.getTodotime() + ts.getTodolist());
								}		
								System.out.print("삭제할번호:");
								int seq = sc.nextInt();
								cnt = tsdao.delete(seq);
								System.out.println(todoid + "님 일정 삭제");
								
								
							}else if(todo==9){
								System.out.println("로그인화면");break;
								
							}else {
								System.out.println("다시입력해주세요");
							}
					}
					
					
				
				}
				
				
				
				}
				
				
			}
			
			
			//회원가입
			else if(no==0) {
				
				String todoid;
				while (true) {
					System.out.print("새로운 아이디:");
					todoid = sc.next();
					
					TodomDTO tmdto = tmdao.selectOne(todoid);
					if (tmdto != null)  
						System.out.println("중복된 아이디입니다.");
					else break;	
				}
				
				
				System.out.print("새로운 닉네임:");
				String todoname = sc.next();
				System.out.print("새로운 비밀번호:");
				String todopw = sc.next();
				System.out.print("새로운 이메일:");
				String todoemail = sc.next();
				
				
				TodomDTO tmdto = new TodomDTO(todoid,todoname,todopw,todoemail);
				cnt = tmdao.insert(tmdto);
				
				if (cnt > 0) {
					System.out.println("회원가입완료");
				}else {
					System.out.println("회원가입실패");
				}
			}
				
			//아이디 수정
			else if(no==2) {
				if(!logincheck) {
					System.out.println("로그인후사용가능");
					continue;
				}
				System.out.print("수정 할 아이디:");
				String todoid = sc.next();
				TodomDTO tmdto = tmdao.selectOne(todoid);
				System.out.print("새로운 닉네임:");
				String todoname = sc.next();
				System.out.print("새로운 비밀번호:");
				String todopw = sc.next();
				System.out.print("새로운 이메일:");
				String todoemail = sc.next();
				tmdto = new TodomDTO(todoid, todoname, todopw, todoemail);
				cnt = tmdao.update(tmdto);
				System.out.println(todoid + "님 정보 수정");
			}
			
			
			//삭제
			else if(no==3) {
				if(!logincheck) {
					System.out.println("로그인후사용가능");
					continue;
				}
				
				System.out.print("아이디:");
				String todoid = sc.next();
				cnt = tmdao.delete(todoid);
				System.out.println(todoid + "님 정보 삭제");
			}
			
			
			//아이디 조회
			else if(no==4) {
				if(!logincheck) {
					System.out.println("로그인후사용가능");
					continue;
				}
				
				System.out.print("아이디:");
				String todoid = sc.next();
				TodomDTO tmdto = tmdao.selectOne(todoid);
				System.out.println(tmdto.getTodoid() + " " + tmdto.getTodoname() + 
						" " + tmdto.getTodopw() + " " + tmdto.getTodoemail());
				
			}
			
			
			//전체조회
			else if(no==5) {
				if(!logincheck) {
					System.out.println("로그인후사용가능");
					continue;
				}
				
				List<TodomDTO> tmlist = tmdao.selectList();
				for(TodomDTO tm : tmlist) {
					System.out.println(tm.getTodoid() + " " + tm.getTodoname() + 
							" " + tm.getTodopw() + " " + tm.getTodoemail());
				}
			}
			 else if(no==9){
				System.out.println("프로그램종료");break;
			}else {
				System.out.println("다시입력해주세요");
			}	
		}
	}
}