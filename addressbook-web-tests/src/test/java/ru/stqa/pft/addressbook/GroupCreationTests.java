package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void newCat1() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Категория 1", "Header1", "Footer1"));
        submitGroupCreation();
        returnToGroupPage();
    }

    @Test
    public void newCat2() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Категория 2", "Header2", "Footer2"));
        submitGroupCreation();
        returnToGroupPage();
    }
}
