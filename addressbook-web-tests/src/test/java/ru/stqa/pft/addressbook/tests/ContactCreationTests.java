package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("Категория 1"));
    }

    @Test
    public void testContactCreation() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/duck.jpg");
    ContactData newContact = new ContactData().withFirstName("Тест1").withLastName("Тест2").withMobile("+79301234567").withHomePhone("+74953331212").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.goTo().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(newContact,true);

    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
}

@Test(enabled=false)
    public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/duck.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

}

}
