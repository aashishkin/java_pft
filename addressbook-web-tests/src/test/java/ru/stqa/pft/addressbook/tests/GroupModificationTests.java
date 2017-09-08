package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.group().list().size() == 0) {
            app.group().create(new GroupData("test1", null, null));
        }
    }

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

        app.goTo().groupPage();

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "ВТБ Ф", "Header8", text);
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @Test
    public void testGroupModification1() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "ВТБ Ф", "Header8", "Footer8");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());;
        before.sort(byId);
        after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);


    }
}
