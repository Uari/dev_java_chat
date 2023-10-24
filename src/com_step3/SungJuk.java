package com_step3;

public class SungJuk {

	private void insertJumsu(StudentInfo si) {

		si = new StudentInfo();
		insertSungjuk("나신입", 80, 95, 75, si);

		si = new StudentInfo();
		insertSungjuk("나일등", 94, 75, 75, si);

		si = new StudentInfo();
		insertSungjuk("나초보", 60, 100, 45, si);
	}
	void insertSungjuk(String name, int html, int css, int java, StudentInfo si) {
		si.setSname(name);
		si.setHtml(html);
		si.setCss(css);
		si.setJava(java);
		
		printSungjuk(si);
	}

	void printSungjuk(StudentInfo si) {
		Service sv = new Service();
		int total;
		double avg;
		total = sv.total(si);
		avg = sv.avg(total);

		System.out.println("|  " + si.getSname() + "   |   " + si.getHtml() + "   |   " + si.getCss() + "   |  " + si.getJava()
				+ "  |   " + total + "   |   " + avg + "   |   ");
	}

	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		StudentInfo si = null;

		System.out.println("================================1반 성적============================================");
		System.out.println("|  학생이름  |  html  |  css   |  java  |  총점  |           평균          |");
		sj.insertJumsu(si);
	}
}
