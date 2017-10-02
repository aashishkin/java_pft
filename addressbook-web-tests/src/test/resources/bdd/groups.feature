Feature: Groups

  Scenario Outline: Group creation
    Given a set of groups
    When I create a new group with name <name>, header <header> and footer <footer>
    Then the new set of groups is equal to the old set with the added group

    Examples:
      | name              | header               | footer           |
      | Тестовая группа 1 | Тестовый заголовок 1 | Тестовый футер 1 |
      | Тестовая группа 2 | Тестовый заголовок 2 | Тестовый футер 2 |
      | Тестовая группа 3 | Тестовый заголовок 3 | Тестовый футер 3 |
