package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if(app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("Тест 1"));
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



        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("ВТБ Ф").withHeader("Header8").withFooter(text);
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
       }

    @Test
    public void testGroupModification1() {
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("ВТБ Ф").withHeader("Header8").withFooter("Footer 8");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);


    }
}
