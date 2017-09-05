package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void newCat1() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Категория 1", "Header1", "Footer1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

    @Test
    public void newCat2() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Категория 2", "Header2", "Footer2"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }
}
