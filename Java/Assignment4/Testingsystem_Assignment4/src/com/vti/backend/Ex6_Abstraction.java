package com.vti.backend;
import com.vti.entity.Abstraction.VietNamesePhone;
import com.vti.entity.Abstraction.Phone;;
public class Ex6_Abstraction {
	public void Q1() {
		Phone phone = new VietNamesePhone();
		phone.insertContact("Nguyen Van A", "0946381919");
		phone.removeContact("Nguyen Van B");
		phone.updateContact("Nguyen Van C", "0946321243");
		phone.searchContact("Nguyen Van D");
	}
}
