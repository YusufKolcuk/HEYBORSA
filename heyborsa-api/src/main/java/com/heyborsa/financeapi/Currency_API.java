package com.heyborsa.financeapi;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.heyborsa.entity.Currency;

import javax.xml.parsers.*;
import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Currency_API {
	
	 	private Money money;
	    private String currencyName;
	    private float currencySellingPrice;
	    private float currencyBuyingPrice;
	    private Date date;

	    public Currency_API(Money money){

	        this.money = money;

	        parse();

	    }


	    public void setCurrencies(Money money){

	        this.money = money;
	        parse();
	    }


	    public Currency getCurrency(){
	    	Currency currency = new Currency();
	    	currency.setDate(date);
	    	currency.setName(currencyName);
	    	currency.setBuying_price(currencyBuyingPrice);
	    	currency.setSelling_price(currencySellingPrice);
	        return currency;
	    }


	    /**
	     * get TCBM bank <a>http://www.tcmb.gov.tr/kurlar/today.xml</a> XML
	     *
	     * <p>Get source xml file and parse Currency Name, Date, Moneys info</p>
	     */
	    private void parse(){

	        try {


	    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = builderFactory.newDocumentBuilder();

	            /**
	             * Connecting <a>http://www.tcmb.gov.tr/kurlar/today.xml</a>
	             * and open
	             */
	    Document document = builder.parse(new  URL("http://www.tcmb.gov.tr/kurlar/today.xml").openStream());

	    // get Date
	    
	     date = new SimpleDateFormat("dd/MM/yyyy").parse(document.getDocumentElement().getAttribute("Date"));
	     // get Currency Tag
	     NodeList nodeList = document.getDocumentElement().getElementsByTagName("Currency");
	    Node node = nodeList.item(money.value);
	    if (node.getNodeType() == Node.ELEMENT_NODE){
	        Element element = (Element) node;
	        currencyName = element.getElementsByTagName("CurrencyName").item(0).getTextContent();
	        // money index > 12 is forex
	       if (money.value>12){

	            currencyBuyingPrice = Float.parseFloat(element.getElementsByTagName("ForexBuying").item(0).getTextContent());
	            currencySellingPrice = Float.parseFloat(element.getElementsByTagName("ForexSelling").item(0).getTextContent());
	        }
	        // money index < 12 is normal
	        else {

	           currencyBuyingPrice = Float.parseFloat(element.getElementsByTagName("BanknoteBuying").item(0).getTextContent());
	           currencySellingPrice = Float.parseFloat(element.getElementsByTagName("BanknoteSelling").item(0).getTextContent());
	       }
	    }

	}

	    catch (ParserConfigurationException parse){ parse.printStackTrace(); }
	    catch (SAXException e) { e.printStackTrace();}
	    catch (IOException e) { e.printStackTrace(); } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

