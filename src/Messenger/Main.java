package Messenger;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sv sv = new Sv();

		int sn;

		////////////////////////////////////////////
		while (true) {
			sn = sv.menu1();
			System.out.println();
			if (sn == 111) {

			} else if (sn == 222) {

			} else if (sn == 1) {
				sv.msave();
			} else if (sn == 2) {
				if (sv.login() != null) {
					while (true) {
						sn = sv.menu2();
						if (sn == 1) {
							// 메시지보내기
								sv.sendmsg();
						} else if (sn == 2) {
							// 메시지함
						} else if (sn == 3) {
							// 친구관리
							while (true) {
								sn = sv.menu4();
								  if (sn == 4) {
									sv.addfr();
								}else if(sn==5) {
									break;
								}else {
									sv.printfr(sn);
								}
							}
						} else if (sn == 4) {
							sv.logout();
							break;
						}
					}
				}
			}
		}
	}
}
