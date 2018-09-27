package com.design.iterator_combination.iterator;

import java.util.Iterator;
import java.util.Stack;

import com.design.iterator_combination.menu.Menu;
import com.design.iterator_combination.menu.MenuComponent;
@SuppressWarnings("rawtypes")
public class CompositeIterator implements Iterator<MenuComponent>{
	
	private Stack<Iterator> stack = new Stack();
	
	public CompositeIterator(Iterator<MenuComponent> iterator) {
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		}else {
			Iterator iterator = stack.peek();
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			}else {
				return true;
			}
		}
	}

	@Override
	public MenuComponent next() {
		if(hasNext()) {
			Iterator iterator = stack.peek();
			MenuComponent next = (MenuComponent) iterator.next();
			if(next instanceof Menu) {
				//如果是菜单，则需要再继续迭代这个菜单
				stack.push(next.createIterator());
			}
			return next;
		}else {
			return null;
		}
	}

}
