# Automation Test Plan for Animed Direct
## Introduction
The purpose of this document is to outline the testing approach for the automation of the Animed Direct website.

## Objectives
The objectives of the test plan are:

To ensure that the Animed Direct website meets the specified requirements.
To ensure that the website is functioning as expected across different browsers and platforms.
To ensure that the website is user-friendly and provides a good user experience.
To identify any defects or issues with the website and report them to the development team.

## Scope
The scope of the test plan includes:

Functional testing of the website, including navigation, search, checkout, and account management.
Cross-browser testing of the website, including Chrome, Firefox, Safari, and Edge.
Cross-platform testing of the website, including Windows, MacOS, iOS, and Android.
Usability testing of the website, including ease of use, responsiveness, and accessibility.
Test Cases
The following test cases will be executed as part of the testing process:

## Navigation
Verify that the home page loads correctly and all elements are displayed.
Verify that the user can navigate to the product category pages from the home page.
Verify that the user can navigate back to the home page from the product category pages.
Verify that the user can navigate to the product detail page from the product category pages.
Verify that the user can navigate back to the product category page from the product detail page.
Verify that the user can navigate to the cart page from the product detail page.
Verify that the user can navigate back to the product detail page from the cart page.
Verify that the user can navigate to the checkout page from the cart page.
Verify that the user can navigate back to the cart page from the checkout page.
Verify that the user can navigate to the account management pages from the home page.
Verify that the user can log in to their account from the account management pages.
Verify that the user can log out of their account from the account management pages.
## Search
Verify that the search bar is displayed on all pages.
Verify that the user can enter a search term in the search bar.
Verify that the user can submit a search from the search bar.
Verify that the search results page displays correctly.
Verify that the user can navigate to the product detail page from the search results page.
Verify that the user can navigate back to the search results page from the product detail page.
## Checkout
Verify that the user can add items to their cart.
Verify that the user can remove items from their cart.
Verify that the user can update the quantity of items in their cart.
Verify that the user can apply a discount code to their cart.
Verify that the user can proceed to checkout from their cart.
Verify that the checkout page displays correctly.
Verify that the user can enter their billing and shipping information on the checkout page.
Verify that the user can select a shipping method on the checkout page.
Verify that the user can enter their payment information on the checkout page.
Verify that the user can submit their order on the checkout page.
## Account Management
Verify that the user can create a new account.
Verify that the user can log in to their account.
Verify that the user can update their account information.
Verify that the user can view their order history.
## Usability
Verify that the website is responsive and displays correctly on different screen sizes and devices.

# Sample Test Cases

|Test Case ID |Test Case Description | Test Steps | Expected Results | Actual Results | Pass/Fail |
|--|--|--|--|--|--|
|1	|Verify user can navigate to the homepage of the website.|	1. Launch the website URL. <br> 2. Verify the page title.	|The homepage is displayed and the page title matches the expected title.	|||	
|2	|Verify user can create an account.	|1. Navigate to the "Sign In" page. <br> 2. Click on the "Create an account" button. <br> 3. Fill in the required information. <br> 4. Click on the "Create account" button. <br> 5. Verify that the account was successfully created.	|The user is able to create an account and is redirected to the "My Account" page.|||	
|3	|Verify user can log in to their account.	|1. Navigate to the "Sign In" page. <br> 2. Fill in the required login information. <br> 3. Click on the "Sign In" button. <br> 4. Verify that the user is successfully logged in.	|The user is redirected to the "My Account" page and the account information is displayed.	|||	
|4	|Verify user can search for a product.	|1. Navigate to the homepage. <br> 2. Enter a product name in the search bar. <br> 3. Click on the "Search" button. <br> 4. Verify that the search results page is displayed.	|The search results page is displayed with relevant products matching the search term.		|||
|5	|Verify user can add a product to their cart.	|1. Navigate to the product page. <br> 2. Select the desired product options. <br> 3. Click on the "Add to cart" button. <br> 4. Verify that the product has been added to the cart.	|The product is added to the cart and the cart total is updated accordingly.	|||	
|6	|Verify user can view their cart.	|1. Navigate to the cart page. <br> 2. Verify that the correct products are displayed in the cart.|	The cart page is displayed with the correct products and their associated prices.		|||
|7	|Verify user can update the quantity of a product in their cart.	|1. Navigate to the cart page. <br> 2. Change the quantity of a product. <br> 3. Verify that the cart total is updated accordingly.	|The cart total is updated with the new quantity and the product price is multiplied by the new quantity.		|||
|8	|Verify user can remove a product from their cart.	|1. Navigate to the cart page. <br> 2. Click on the "Remove" button next to a product. <br> 3. Verify that the product has been removed from the cart.	|The product is removed from the cart and the cart total is updated accordingly.	|||	
|9	|Verify user can place an order.	|1. Navigate to the cart page. <br> 2. Click on the "Proceed to checkout" button. <br> 3. Fill in the required shipping and billing information. <br> 4. Select the desired payment method. <br> 5. Click on the "Place order" button		|Order palced, order number provided and can be verified on the customer's my account page|||	
