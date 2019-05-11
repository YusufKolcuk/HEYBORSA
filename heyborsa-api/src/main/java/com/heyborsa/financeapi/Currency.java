package com.heyborsa.financeapi;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.heyborsa.entity.Doviz;

import javax.xml.parsers.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Currency {
	private static final String URL_SOURCE = null;
	
	private String url = "http://www.tcmb.gov.tr/kurlar/today.xml";
	
	
	
	
	/*public void SendRequest()
	{
		URL url;
		try {
			url = new URL("http://data.fixer.io/api/latest?access_key=f08d0093cd3ad8cccffdce05027bcbab");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StringBuffer ReadResponse() {
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
			con.disconnect();
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
	}*/
	
	 	private Moneys money;
	    private String currencyName;
	    private float currencySellingPrice;
	    private float currencyBuyingPrice;
	    private boolean isForex;

	    private String date;
	    
	    private Currency(){ }

	    /**
	     *
	     * @param money Enum Moneys
	     */
	    public Currency(Moneys money){

	        this.money = money;

	        parse();

	    }


	    /**
	     *  set default money name
	     * @param money Enum Moneys
	     */
	    public void setCurrencies(Moneys money){

	        this.money = money;
	        parse();
	    }

	    /**
	     * <p>return Currency interface for selected money name, buying and selling price</p>
	     * @return Currency
	     */
	    public Doviz getCurrency(){

	    	Doviz doviz = new Doviz();
	    	doviz.setTarih(date);
	    	doviz.setIsim(currencyName);
	    	doviz.setAlis_deger(currencyBuyingPrice);
	    	doviz.setSatis_deger(currencySellingPrice);
	    
	        return doviz;

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
	     date = document.getDocumentElement().getAttribute("Date");

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
	            isForex=true;
	        }

	        // money index < 12 is normal
	        else {

	           currencyBuyingPrice = Float.parseFloat(element.getElementsByTagName("BanknoteBuying").item(0).getTextContent());
	           currencySellingPrice = Float.parseFloat(element.getElementsByTagName("BanknoteSelling").item(0).getTextContent());
	           isForex =false;
	       }


	    }

	}

	                //Exceptions
	    catch (ParserConfigurationException parse){ parse.printStackTrace(); }
	    catch (SAXException e) { e.printStackTrace();}
	    catch (IOException e) { e.printStackTrace(); }
	}
	
}

