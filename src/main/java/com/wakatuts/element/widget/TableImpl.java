package com.wakatuts.element.widget;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.core.TestLogger;
import com.wakatuts.element.base.ElementImpl;


public class TableImpl extends ElementImpl implements Table{

	/**
	 * Creates a Table for a given WebElement.
	 * 
	 * @param element
	 *            element to wrap up
	 */
	public TableImpl(WebElement element, String elementName) {
		super(element, elementName);
	}
	
	public TableImpl(By by, String elementName) {
		super(by, elementName);
	}

	@Override
	public int getRowCount() {
		return getRows().size();
	}

	@Override
	public int getColumnCount() {
		TestLogger.setInfo("ACTION", "Getting option count from " + this.elementName);
		return findElement(By.cssSelector("tr")).findElements(
				By.cssSelector("*")).size();
		// Would ideally do:
		// return findElements(By.cssSelector("tr:first-of-type > *"));
		// however HTMLUnitDriver does not support CSS3
	}

	@Override
	public WebElement getCellAtIndex(int rowIdx, int colIdx) {
		TestLogger.setInfo("ACTION", "Getting cell from " + this.elementName + " with row " + rowIdx + " and column " + colIdx);
		// Get the row at the specified index
		WebElement row = getBodyRows().get(rowIdx);

		List<WebElement> cells;

		// Cells are most likely to be td tags
		if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
			return cells.get(colIdx);
		}
		// Failing that try th tags
		else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
			return cells.get(colIdx);
		} else {
			final String error = String
					.format("Could not find cell at row: %s column: %s",
							rowIdx, colIdx);
			throw new RuntimeException(error);
		}
	}

	/**
	 * Gets all rows in the table in order header > body > footer
	 * 
	 * @return list of row WebElements
	 */
	private List<WebElement> getRows() {
		List<WebElement> rows = new ArrayList<WebElement>();
		
		//Header rows
		rows.addAll(findElements(By.cssSelector("thead tr")));
		
		//Body rows
		rows.addAll(findElements(By.cssSelector("tbody tr")));
		
		//Footer rows
		rows.addAll(findElements(By.cssSelector("tfoot tr")));

		return rows;
	}
	
	private List<WebElement> getBodyRows() {
		List<WebElement> rows = new ArrayList<WebElement>();
		
		//Body rows
		rows.addAll(findElements(By.cssSelector("tbody tr")));
		
		return rows;
	}
	
	//starts at 1
	private List<WebElement> getListOfColumnValues(int colNum) {
		List<WebElement> columnList = new ArrayList<WebElement>();
		
		//Body rows
		columnList.addAll(findElements(By.cssSelector("tbody tr td:nth-child(" + colNum + ")")));
		
		return columnList;
	}
	
	@Override
	public List<String> getAllTextsOfAColumn(int colNum) {
		List<String> columnValues = new ArrayList<String>();
		for(WebElement e : getListOfColumnValues(colNum)) {
			columnValues.add(e.getText());
		}
		return columnValues;
		
	}

	@Override
	public int getBodyRowCount() {
		return getBodyRows().size();
	}

}
