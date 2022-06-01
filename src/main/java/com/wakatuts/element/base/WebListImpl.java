package com.wakatuts.element.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wakatuts.element.handler.ElementHandler;
import com.wakatuts.element.widget.CheckBoxImpl;
import com.wakatuts.element.widget.IFrameImpl;
import com.wakatuts.element.widget.LabelImpl;
import com.wakatuts.element.widget.SelectImpl;
import com.wakatuts.element.widget.TableImpl;
import com.wakatuts.element.widget.TextInputImpl;

public class WebListImpl<E> implements WebList<E> {
	
	private static ThreadLocal<List<Element>> elements = new ThreadLocal<List<Element>>();
	private static ThreadLocal<Element> element = new ThreadLocal<>();
	private Class<?> elementClass;
	private final By by;
	private final String elementsName;
	
	public WebListImpl(Class<?> elementClass, By by, String elementsName) {
		this.by = by;
		this.elementsName = elementsName;
		this.elementClass = elementClass;
	}
	
	private void initiateElements() {
		List<WebElement> listOfElements = ElementHandler.findElements(by);
		if(listOfElements == null) {
			Assert.fail(elementsName + " are not present");
		}
        List<Element> wrappedList = new ArrayList<Element>();
        for(WebElement element : listOfElements) {
        	wrappedList.add(wrapElement(element, listOfElements.indexOf(element)));
        }
        elements.set(wrappedList);
	}
	
	private void initiateElement(int index) {
		List<WebElement> listOfElements = ElementHandler.findElements(by);
		if(listOfElements == null) {
			Assert.fail(elementsName + " are not present");
		}
		element.set(wrapElement(listOfElements.get(index), index));
	}
	
	private void initiateElement(String text) {
		List<WebElement> listOfElements = ElementHandler.findElements(by);
		if(listOfElements == null) {
			Assert.fail(elementsName + " are not present");
		}
		WebElement e = listOfElements.stream()
								.filter(element -> element.getText().equals(text))
								.findAny()
								.orElse(null);
		element.set(wrapElement(e, listOfElements.indexOf(e)));
	}
	
	private Element wrapElement(WebElement elementToWrap, int index) {
        //TODO implement reflection
		switch (this.elementClass.getSimpleName()) {
		case "CheckBox":
			return new CheckBoxImpl(elementToWrap, elementsName + "index " + index);

		case "IFrame":
			return new IFrameImpl(elementToWrap, elementsName + "index " + index);
	
		case "Label":
			return new LabelImpl(elementToWrap, elementsName + "index " + index);

		case "Select":
			return new SelectImpl(elementToWrap, elementsName + "index " + index);
	
		case "Table":
			return new TableImpl(elementToWrap, elementsName + "index " + index);
	
		case "TextInput":
			return new TextInputImpl(elementToWrap, elementsName + "index " + index);

		case "Element":
			return new ElementImpl(elementToWrap, elementsName + "index " + index);
		default:
			Assert.fail("invalid element type!");
			return null;
		}
	}

	@Override
	public int size() {
		initiateElements();
		return elements.get().size();
	}

	@Override
	public boolean isEmpty() {
		initiateElements();
		return elements.get().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElementByIndex(int index) {
		initiateElement(index);
		return (E) element.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElementByText(String text) {
		initiateElement(text);
		return (E) element.get();
	}

	@Override
	public E getElementByValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getElementByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
