Feature: Search and place the order for products





Scenario: Search Experience for product both on home page and Offers page
Given user is on GreenCart Landing Page
When user searched with shortname "Tom" and extracted actual name of product
Then user searched for "Tom" shortname in offers page 
And validates product name in offers page matches with landing page
