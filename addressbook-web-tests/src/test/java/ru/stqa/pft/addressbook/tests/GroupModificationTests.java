package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModificationLongFooter() {
        String text = "Лика озадаченно переводила взгляд то на меня, то на медленно растворяющийся в воздухе охранный контур заклинания вызова. Придётся кое — что объяснить. Из — за клятвы присутствующие не смогут ничего рассказать чужим.\n" +
                "\n" +
                "— Не считайте меня волшебницей. Всего лишь обычный вызов духа семьи. Любая настоящая гадалка может это делать. Разве что пришлось кое — что переделать из рекомендаций по ритуалам, чтобы духа видели посторонние.\n" +
                "\n" +
                "Падение из кармана пиджака ручки деда, когда тот потянулся за носовым платком, прозвучало как раскат грома.\n" +
                "\n" +
                "— И дух доказал, что Тим жив? — неуверенно смотрел на меня дед, пытаясь вытереть выступивший на лбу пот дрожащей рукой.\n" +
                "\n" +
                "— Вон, спросите у невестки, — кивнула я на Лику, переводя стрелки на другой объект. — Она теперь должна чувствовать нити судьбы, связывающие родственников.\n";

        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("ВТБ Ф", "Header8", text));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }

    @Test
    public void testGroupModification1() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("ВТБ Ф", "Header8", "Footer8"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
