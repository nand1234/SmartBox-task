# new feature
# Tags: optional

Feature: Verify Customer view a list of products for purchase

Scenario: Verify customer searching a box using main search field
    Given Customer on smart box landing page
    When Customer enters box name on the main search field
    Then Suggestions are displayed as customer type

Scenario: Verify customer can see filter options on selecting category and subcategory
    Given Customer on smart box landing page
    When Customer select category and sub category
    Then filter options displays

Scenario: Verify customer can see suggestions in filter search box
    Given Customer on smart box landing page
    When Customer select category and sub category
    Then filter options displays on UI
    And suggestions displays in filter box

Scenario: Verify customer can see Review link on box page
    Given Customer on smart box landing page
    When Customer select category and sub category
    Then filter options displays
    And Review link displays on a box