package com.mop.qa.test.bvt;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mop.qa.pageobject.BookStore_Cart_Page;
import com.mop.qa.pageobject.BookStore_Home_Page;
import com.mop.qa.testbase.TestBase;

/**
 *
 * @author Cognizant
 * @version 1.0
 * @since 2018-10-31
 */
//-------------------------------------Test Class for Book Store Application----------------------------------------//
public class Test_BookStore extends TestBase {
	// public static void main(String[] args) {
	@Test
	public void bookstoreTest() throws Exception {
		try {
			// Objects instantiation

			BookStore_Home_Page homePage_Obj = new BookStore_Home_Page(remoteDriver);
			BookStore_Cart_Page cartPage_Obj = new BookStore_Cart_Page(remoteDriver);

			//Calling Methods
			
			homePage_Obj.launchUrl(getPropertyValue("BookStoreUrl"));
			homePage_Obj.searchBook();
			cartPage_Obj.addCart();
			cartPage_Obj.billingInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, this.getClass().getSimpleName() + " Failed due to error " + e.toString());
		}
	}

}
