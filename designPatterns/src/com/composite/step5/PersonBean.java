package com.composite.step5;

import com.composite.step1.Duck;

public class PersonBean implements Observer {

	@Override
	public void update(Duck duck) {
		System.out.println("�۲��ߣ���ǰ��Ѽ�ӣ�" + duck);
	}

}
