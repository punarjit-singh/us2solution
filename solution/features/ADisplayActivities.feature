#Author: punarjit.singh@hotmail.com

Feature: Activity List on Homepage
	In order to test activity list on Homepage
	As a registered user I want to view latest project activity listed on homepage

Scenario: As a user I launch ustwo sample app
  Latest project activity should be displayed on homepage

Given I launch ustwo sample app
When ustwo sample app is loaded
Then I see latest project activity listed on homepage