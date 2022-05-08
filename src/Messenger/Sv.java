package Messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sv extends Re {

	Scanner sc = new Scanner(System.in);
	String logid = null;
	Integer logindex = null;
	int sn = 0;
	///////////////////////////////////////////////////////////////

	void logo() {
		System.out.println("HSS Messenger Ver 1.0");
		System.out.println();
	}

	int menu1() {
		System.out.println();
		System.out.println("1. 회원가입    2. 로그인    3. 종료");
		return getsn();
	}

	int menu2() {
		System.out.println();
		System.out.println("1. 메시지보내기    2. 메시지함    3. 친구관리   4. 로그아웃");
		return getsn();
	}

	int menu3() {
		System.out.println();
		System.out.println("1. 수락하기    2. 거절하기    3. 다음에");
		return getsn();
	}

	int menu4() {
		System.out.println();
		System.out.println("1. 내 친구    2. 내가 신청한 친구    3. 나를 신청한 친구    4.친구신청    5.나가기");
		return getsn();
	}

	/////////////////////////////////////////////////////////////////////
	String getid() {
		System.out.println();
		System.out.print("아이디를 입력 하세요 > ");
		return sc.next();
	}

	String getpw() {
		System.out.println();
		System.out.print("비밀번호를 입력 하세요 > ");
		return sc.next();
	}

	String getname() {
		System.out.println();
		System.out.print("이름을 입력 하세요 > ");
		return sc.next();
	}

	int getsn() {
		System.out.println();
		System.out.print("선택 > ");
		return sc.nextInt();
	}

	String gettitle() {
		System.out.println();
		System.out.print("제목을 입력하세요 > ");
		return sc.next();
	}

	String gettext() {
		System.out.println();
		System.out.print("내용을 입력하세요 > ");
		return sc.nextLine();
	}

	////////////////////////////////////////////////////////////////////

	void msave() {
		String id = getid();
		if (idc(0, id) == null) {
			String pw = getpw();
			while (true) {
				System.out.println();
				System.out.println("한번 더 입력해주세요 ");
				System.out.println();
				if (getpw().equals(pw)) {
					String name = getname();
					MDto mem = new MDto(id, pw, name);
					if (addmlist(mem) == true) {
						System.out.println();
						System.out.println(name + "님 회원 가입을 축하드립니다.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("회원가입에 실패하였습니다.");
					}
					break;
				} else {
					System.out.println();
					System.out.println("비밀번호가 다릅니다. 다시 입력해 주세요.");
				}
			}
		}
	}

	String login() {
		if (mlist.size() != 0) {
			String id = getid();
			Integer index = idc(1, id);
			try {
				if (getpw().equals(mlist.get(index).getPw())) {
					logindex = index;
					logid = id;
					System.out.println();
					System.out.println("안녕하세요~ " + id + " 님 반갑습니다.");
					System.out.println();
					fcount();

				} else {
					System.out.println();
					System.out.println("아이디 또는 비밀번호를 확인해주세요 ");
					System.out.println();
				}

			} catch (NullPointerException e) {
				System.out.println();
				System.out.println("아이디 또는 비밀번호를 확인해주세요 ");
				System.out.println();
			}
		}

		else {
			System.out.println();
			System.out.println("가입을 먼저 해주세요~");
			System.out.println();
		}
		return logid;
	}

	void logout() {
		logid = null;
		logindex = null;
		System.out.println();
		System.out.println("로그아웃 되었습니다.");
		System.out.println();
	}
	/////////////////////////////////////////////////////////////////////

	void addfr() {
		System.out.print("친구 신청하실 ");
		String idd = getid();
		if (!idd.equals(logid) && idc(1, idd) != null) {
			if (frc(10, logid, idd) != null) {
				FDto ff = new FDto(logid, idd, null);
				if (addflist(ff) == true) {
					System.out.println(idd + "님에게 친구 신청이 완료되었습니다.");
				}
			}
		} else {
			System.out.println("아이디를 다시 확인해주세요");
		}

	}

	Boolean printfr(int sn) {
		List<FDto> list = new ArrayList<>();
		Boolean bool = null;
		try {
			if (sn == 1) {
				list = frc(1, logid, "aaaa");
			} else if (sn == 2) {
				list = frc(2, logid, "aaaa");
			} else if (sn == 3) {
				list = frc(3, logid, "aaaa");
			}

			if (list.size() != 0) {
				for (FDto a : list) {
					System.out.println(a);
					bool = true;
				}
				if (sn == 3) {
					choicefr();
					bool = true;
				} else {
					bool = true;
				}
			} else {
				if (sn == 1 || sn == 2) {
					System.out.println("친구를 먼저 만들어주세요~");
				} else if (sn == 3) {
					System.out.println("새롭게 받은 친구 신청이 없습니다~");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("친구를 먼저 만들어주세요~");
		}
		return bool;

	}

	void fcount() {

		List<FDto> a = frc(11, logid, "aaaa");
		if (a == null) {
			System.out.println();
			System.out.println("새로운 친구 요청이 있습니다.");
			System.out.println("1.지금 확인하기   2. 다음에 확인하기");
			int sn = getsn();
			if (sn == 1) {
				printfr(3);

			} else if (sn == 2) {
				delayfr();
			}

		}

	}

	void yesfr() {
		System.out.print("수락할 친구의");
		frc(6, logid, getid());

	}

	void nofr() {
		System.out.print("거절할 친구의");
		frc(7, logid, getid());
		System.out.println("친구거절이 완료 되었습니다.");
	}

	void delayfr() {
		System.out.println();
		System.out.println("다음 로그인 때에 다시 알려 드리겠습니다.");
	}

	void choicefr() {
		sn = menu3();
		if (sn == 1) {
			yesfr();
		} else if (sn == 2) {
			nofr();
		} else if (sn == 3) {
			delayfr();
		}
	}

	///////////////////////////////////////////////////////////////////////////

	void sendmsg() {
		Boolean bool = printfr(1);
		try {
			if (bool == true) {
				System.out.print("메시지 보낼 친구의");
				String fid = getid();
				if (!fid.equals(logid)) {
					if (frc(21, logid, fid) == null) {
						String title = gettitle();
						String text = gettext();
						TDto tt = new TDto(logid, fid, title, text);
						if (addtlist(tt) == true) {
							System.out.println();
							System.out.println("메시지 전송이 완료 되었습니다.");
						}
					} else {
						System.out.println();
						System.out.println("친구의 아이디를 확인해주세요.");
					}

				}else {
					System.out.println("본인의 아이디 말고 친구의 아이디를 입력해주세요~");
				}
			} 
		} catch (NullPointerException e) {
			System.out.println("친구가 생기면 메시지를 보낼수 있어요~");
		}

	}

}
