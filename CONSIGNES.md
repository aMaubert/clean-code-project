# Show me a product kata!

## Context

The problem we are trying to solve is to be able to visualize a product page with it's details and price.

For the sake of the exercice, it can be a web app, a web api or even a simple console app (depending on what's simple for you)


![page](https://gist.githubusercontent.com/rhwy/566e141f64f188a3b0772c8716900d22/raw/d9eb5e0194a7ee3a08b9abfd1278358b20662cb5/page.png)

In order to work, you'll have at your disposal these data sources:

![data sources](https://gist.githubusercontent.com/rhwy/566e141f64f188a3b0772c8716900d22/raw/bd24725f93ed593d731f1a74be97362644a53492/databases.png)

(note: 1 & 2 sections define the expected work, whereas section 3 contains the details of the exercice)

## 1. part one : design

Before starting the code part, you should take 20min with the team, to think about the problem and design (graphically) a solution.

A. We would like to have a design with a schema representing the structure of the code you'll implement (logical blocs, structure, interactions, etc...)

B. You must provide a quick resume of the architecture decisions you made as a team (if you can't finish your code, it's important at least to get the overall picture)

## 2. part two : code

It is expected here that you provide a clean implementation of your solution. It should be clean, have a clear structure and that all parts are separated (at least domain/infra). If you have unit tests on your domain function it will be even better!


### 3. Stories and Use cases

#### Scenario 1
```md
As public user (not logged)
when I call product 123
I see a page of information for the product, with product name, description, category, details (key, value) 
and the standard price
```


#### Scenario 2
```md
As user Paul
when I call product 123
I see a page of information for the product, with product name, description, category, details (key, value) 
and the a price which is the standard price + some calculations:
a) -10% if the user bought 3 or more other products during the last 6 months
b) +5% if the user bought the exact same product more than 5 times in the last year
```

#### Instructions

Create a console app or an api that has 2 parameters:
- product id
- user id (optional)
  when the user id is not present, then you'll consider to be in public mode and show the standard price.
  when the user id is provided, you'll consider to be logged as the user corresponding to this id and you'll need to apply pricing conditions.
  You must not bother with authentication strategies for this exercice