package Messenger;

import java.util.ArrayList;
import java.util.List;

public class Re {
	static List<MDto> mlist = new ArrayList<>();
	static List<FDto> flist = new ArrayList<>();
	static List<TDto> tlist = new ArrayList<>();
	Integer fcount = 0;

	//////////////////////////////////////////////////

	boolean addmlist(MDto mem) {
		return mlist.add(mem);
	}

	boolean addflist(FDto mem) {
		return flist.add(mem);
	}

	boolean addtlist(TDto mem) {
		return tlist.add(mem);
	}

	/////////////////////////////////////

	Integer idc(int sn, String id) {
		Integer index = null;
		for (int i = 0; i < mlist.size(); i++) {
			String mid = mlist.get(i).getId();
			if (id.equals(mid)) {
				index = i;
			}

			if (sn == 0 && index != null) {
				System.out.println();
				System.out.println("중복된 아이디 입니다.");
				System.out.println();
			} else if (sn == 2 && index == null) {
				System.out.println();
				System.out.println("아이디가 존재하지 않습니다.");
				System.out.println();
			}
		}
		return index;

	}

	////////////////////////////////////////////////////////////////////
	List<FDto> frc(int sn, String myid, String fid) {
		List<FDto> frlist = new ArrayList<>();
		for (int i = 0; i < flist.size(); i++) {
			String pf = flist.get(i).getPlzfr();
			String yf = flist.get(i).getYesfr();
			Boolean fr = flist.get(i).getFr();

			if (sn == 1) {
				if ((myid.equals(pf) || myid.equals(yf)) && fr == true) {
					frlist.add(flist.get(i));
				}
			} else if (sn == 2) {
				if (myid.equals(pf) && fr == null) {
					frlist.add(flist.get(i));
				}
			} else if (sn == 3) {
				if (myid.equals(yf) && fr == null) {
					frlist.add(flist.get(i));
				}
			} else if (sn == 11) {
				if (myid.equals(yf) && fr == null) {
					frlist = null;
				}
			} else if (sn == 6) {
				if (fid.equals(pf) && myid.equals(yf) && fr == null) {
					flist.get(i).setFr(true);
					System.out.println("친구수락이 완료 되었습니다.");
				}else {
					System.out.println("아이디를 확인 해주세요~");
				}
			} else if (sn == 7) {

				if (fid.equals(pf) && myid.equals(yf) && fr == null) {
					flist.get(i).setFr(false);
				}
			} else if (sn == 10) {
				if (myid.equals(pf) && fid.equals(yf)) {
					if (fr == null) {
						System.out.println();
						System.out.println(fid + " 님에게 친구신청을 이미 하셨어요.");
					} else if (fr == true) {
						System.out.println();
						System.out.println(fid + " 님과 이미 친구 사이입니다.");
						
					}

					frlist = null;
				}

			}else if(sn==21 && (myid.equals(pf)&&fid.equals(yf)) &&( myid.equals(yf)||fid.equals(pf)) && fr==true ){
				frlist=null;
			}else if(sn==22 && (myid.equals(pf)&&fid.equals(yf)) &&( myid.equals(yf)||fid.equals(pf)) && fr!=true ){
				frlist=null;
			}

		}
		return frlist;
	}

	/*List<FDto> frc(int sn, String myid, String fid) {
		List<FDto> frlist = new ArrayList<>();
		for (int i = 0; i < flist.size(); i++) {
			String pf = flist.get(i).getPlzfr();
			String yf = flist.get(i).getYesfr();
			Boolean fr = flist.get(i).getFr();

			if ((myid.equals(pf) || myid.equals(yf)) && fr == true) {
				if (sn == 1) {
					frlist.add(flist.get(i));
				}
			} else if (myid.equals(pf) && fr == null) {
				if (sn == 2) {
					frlist.add(flist.get(i));
				}
			} else if (myid.equals(yf) && fr == null) {
				if (sn == 2) {
					frlist.add(flist.get(i));
				} else if (sn == 11) {
					frlist = null;
				}
			} else if (fid.equals(pf) && myid.equals(yf)) {
				if (fr == null) {
					if (sn == 6) {
						flist.get(i).setFr(true);
					} else if (sn == 7) {
						flist.get(i).setFr(false);
					} else if (sn == 10) {
						System.out.println();
						System.out.println(fid + " 님 에게한 친구신청이 이미 존재합니다.");
						frlist = null;
					}
				} else if (fr == true) {
					if (sn == 10) {
						System.out.println();
						System.out.println(fid + " 님과 이미 친구 사이입니다.");
						frlist = null;
					}else if(sn==21) {
						frlist=null;
					}
				}
			}

		}
		return frlist;
	}*/
	//////////////////////////////////////////////////////////////////
	
	List<TDto> ttc(int sn,String sid,String tid){
		List<TDto>trlist=new ArrayList<>();
		for (int i=0 ; i<tlist.size();i++) {
			String s=tlist.get(i).getSendid();
			String t=tlist.get(i).getTakeid();
			Boolean b=tlist.get(i).getTt();
			
			if (sid.equals(s) || sid.equals(t)) {
				if(sn==1) {trlist.add(tlist.get(i));}
			}else if (sid.equals(s)) {
				if(sn==2){trlist.add(tlist.get(i));}
			}else if (sid.equals(t)) {
				if(b==null) {
					if(sn==4) {
						trlist.add(tlist.get(i));
					}
				}
				if(sn==3){trlist.add(tlist.get(i));}
			}
		}return trlist;
	}
	
	
	
	
	
	
	
	
}