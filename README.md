# Amazon Spark
Version 0.0.0: September 26, 2016

by [Vanessa Palacios Sharma](https://github.com/VanessaSharma)

## Description
An online bookstore

![screenshot of project running](picture here)


### Specifications
#### User Stories:
* As a user, I want to add a recipe with ingredients and instructions, so I remember how to prepare my favorite dishes.
* As a user, I want to tag my recipes with different categories like "Thanksgiving", "Gluten-Free", or "Good for Camping", so recipes are easier to find.
* As a user, I want to associate a recipe with a tag. A recipe should be able to have many tags and a tag should be able to include many recipes.
* As a user, I want to be able to update and delete tags, so I can have flexibility with how I categorize recipes.
* As a user, I want to edit my recipes, so I can make improvements or corrections.
* As a user, I want to be able to delete recipes I don't like or use, so I don't have to see them as choices.
* As a user, I want to rate my recipes, so I know which ones are the best.
* As a user, I want to list my recipes by highest rated so I can see which ones I like the best.
* As a user, I want to see all recipes that use a certain ingredient, so I can more easily find recipes for the ingredients I have.

#### Database Diagram:
![database diagram](database picture)

#### Technical Specifications:
| Behavior                   | Input                                                                                      | Output                                                                                     |
|----------------------------|--------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| Store recipe name          | Aloo Gobi                                                                                  | Aloo Gobi                                                                                  |
| Assign tag id to recipe    | 1                                                                                          | 1                                                                                          |
| Get recipe description     | "Traditional Punjabi dish made with warming spices and pan fried cauliflower and potatoes. | "Traditional Punjabi dish made with warming spices and pan fried cauliflower and potatoes. |
| Get ingredients for recipe | "Potatoes, cauliflower,onions,garlic,ginger,cumin seed, garam masala ,salt."               | Potatoes, cauliflower,onions,garlic,ginger,cumin seed, garam masala ,salt."                |
| Get recipe rating          | 5                                                                                          | 5                                                                                          |
| Get tag name               | Vegan                                                                                      | Vegan                                                                                      |
| Assign an id to tag        | 1                                                                                          | 1                                                                                          |
| Get ingredient id          | 3                                                                                          | 3                                                                                          |
| Get ingredient name        | potato                                                                                     | potato                                                                                     |

## Setup/Installation
* Clone directory
* Setup database in PSQL:
  * ...
* Type 'gradle run' inside the directory
* Navigate to 'http://localhost:4567'

## Support & Contact
For questions, concerns, or suggestions please email vanelunapalacios@live.com

## Known Issues
* N/A

## Technologies Used
Java, JUnit, Spark, PostgreSQL, Gradle

## Legal
*Licensed under the GNU General Public License v3.0*

Copyright (c) 2016 Copyright _Vanessa Palacios Sharma_ All Rights Reserved.
