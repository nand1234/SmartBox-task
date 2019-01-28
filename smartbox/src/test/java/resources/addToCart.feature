Feature: Verify Customer able to find desired box and add to the card to do adjustments prior to checkout

Scenario: Verify Customer add and remove desired box to cart
   Given Customer on smart Box Landing page
   When Customer select category and Subcategory
   Then  List of products displayed
   When Customer select the product
   Then Selected Product Detail displayed
   When Customer add item to the Cart
   Then Product display in the shopping cart
   And Customer can Remove the Item from the Cart

Scenario: Verify Customer continue shopping after adding item to cart
   Given Customer added item to cart
   Then Customer continue shopping by adding another item to the cart

Scenario: Verify Customer cannot add more than 5 boxes of each title to cart
   Given Customer added item to 6 items to cart
   Then Customer cannot do purchase