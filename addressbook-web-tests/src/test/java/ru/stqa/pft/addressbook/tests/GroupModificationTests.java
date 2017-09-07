package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

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
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size()-1).getId(), "ВТБ Ф", "Header8", text);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @Test
    public void testGroupModification1() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size()-1).getId(), "ВТБ Ф", "Header8", "Footer8");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }
}
