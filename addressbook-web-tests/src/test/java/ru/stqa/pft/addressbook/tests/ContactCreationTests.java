package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
    app.goTo().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", "Москва, Пресненская набережная, 10", "test@test.com", "+79202001234", "+74951230987", "Категория 1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
}

}
