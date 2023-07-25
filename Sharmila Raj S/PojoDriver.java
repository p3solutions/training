package Prgm;

public class PojoDriver {
	public static void main(String[] args) {
		PojoClass p=new PojoClass("Sharmi",500.0);
		System.out.println(p.getBankBal());
		p.setBankBal(600.0);
		System.out.println(p.getBankBal());
		System.out.println(p.getUserName());
		p.setUserName("SelvaRaju");
		System.out.println(p.getUserName());
	}

}
